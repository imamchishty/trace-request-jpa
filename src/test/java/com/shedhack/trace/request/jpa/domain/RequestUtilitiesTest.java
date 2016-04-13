package com.shedhack.trace.request.jpa.domain;

import com.shedhack.trace.request.api.constant.Status;
import com.shedhack.trace.request.api.model.RequestDto;
import com.shedhack.trace.request.api.model.RequestModel;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

/**
 * Test the utilities
 */
public class RequestUtilitiesTest {

    @Test
    public void should_identify_request_entity_object() {
        Request request = Request.builder("app", "requestId", "groupId")
                .withRequestDateTime(new Date()).build();

        assertTrue(RequestUtilities.isRequestEntity(request));
    }

    @Test
    public void should_identify_request_dto_object() {
        RequestDto request = RequestDto.builder("app", "requestId", "groupId")
                .withRequestDateTime(new Date()).build();

        assertFalse(RequestUtilities.isRequestEntity(request));
    }

    @Test
    public void should_map_model_to_entity() {

        // Arrange
        String appId = "appId";
        String reqId = "reqId";
        String grpId = "grpId";
        String calId = "calId";
        String IPadd = "1.2.3.4";
        String path  = "/a/b/c";
        String sesId = "ABCDEF";
        String headers = "{\"host\":\"localhost:8080\",\"connection\":\"keep-alive\",\"cache-control\":\"max-age=0\",\"accept\":\"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\",\"upgrade-insecure-requests\":\"1\",\"user-agent\":\"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.110 Safari/537.36\",\"dnt\":\"1\",\"accept-encoding\":\"gzip, deflate, sdch\",\"accept-language\":\"en-US,en;q=0.8\"}";
        String excId = "GHJKL";

        // Act
        RequestDto.Builder builder = RequestDto.builder(appId, reqId, grpId);
        builder.withRequestDateTime(new Date()).withCallerId(calId).withClientAddress(IPadd)
                .withHostAddress(IPadd).withHttpHeaders(headers).withPath(path).withSessionId(sesId)
                .withStatus(Status.FAILED).withResponseDateTime(new Date()).withExceptionId(excId);

        RequestModel model = builder.build();

        // Convert
        Request entity = RequestUtilities.mapFromModelToEntity(model);

        // Assert
        assertEquals(appId, entity.getApplicationId());
        assertEquals(reqId, entity.getRequestId());
        assertEquals(grpId, entity.getGroupId());
        assertEquals(calId, entity.getCallerId());
        assertEquals(IPadd, entity.getClientAddress());
        assertEquals(IPadd, entity.getHostAddress());
        assertEquals(path, entity.getPath());
        assertEquals(sesId, entity.getSessionId());
        assertEquals(headers, entity.getHeaders());
        assertEquals(Status.FAILED, entity.getStatus());
        assertEquals(excId, entity.getExceptionId());
        assertEquals(model.getRequestDateTime(), entity.getRequestDateTime());
        assertEquals(model.getResponseDateTime(), entity.getResponseDateTime());

    }


}
