package com.shedhack.trace.request.jpa.domain;

import com.shedhack.trace.request.api.constant.Status;
import com.shedhack.trace.request.api.model.RequestModel;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Tests the {@link Request}
 */
public class RequestTest {

    @Test
    public void should_create_valid_model() {

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
        Request.Builder builder = Request.builder(appId, reqId, grpId);
        builder.withRequestDateTime(new Date()).withCallerId(calId).withClientAddress(IPadd)
                .withHostAddress(IPadd).withHttpHeaders(headers).withPath(path).withSessionId(sesId)
        .withStatus(Status.FAILED).withResponseDateTime(new Date()).withExceptionId(excId);

        RequestModel model = builder.build();

        // Assert
        assertEquals(appId, model.getApplicationId());
        assertEquals(reqId, model.getRequestId());
        assertEquals(grpId, model.getGroupId());
        assertEquals(calId, model.getCallerId());
        assertEquals(IPadd, model.getClientAddress());
        assertEquals(IPadd, model.getHostAddress());
        assertEquals(path, model.getPath());
        assertEquals(sesId, model.getSessionId());
        assertEquals(headers, model.getHeaders());
        assertEquals(Status.FAILED, model.getStatus());
        assertEquals(excId, model.getExceptionId());
        assertNotNull(model.getRequestDateTime());
        assertNotNull(model.getResponseDateTime());
    }

}
