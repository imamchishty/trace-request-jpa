package com.shedhack.trace.request.jpa.domain;

import com.shedhack.trace.request.api.constant.Status;
import com.shedhack.trace.request.api.model.RequestModel;

import java.util.Date;
import java.util.UUID;

/**
 * @author imamchishty
 */
public class RequestHelper {

    public static Request buildFixed() {

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

        return builder.build();
    }

    public static Request buildDynamic() {

        // Arrange
        String appId = "ABC" + Math.random();
        String reqId = UUID.randomUUID().toString();
        String grpId = UUID.randomUUID().toString();
        String calId = UUID.randomUUID().toString();
        String IPadd = "1.2.3.4";
        String path  = "/a/b/c";
        String sesId = UUID.randomUUID().toString();
        String headers = "{\"host\":\"localhost:8080\",\"connection\":\"keep-alive\",\"cache-control\":\"max-age=0\",\"accept\":\"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\",\"upgrade-insecure-requests\":\"1\",\"user-agent\":\"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.110 Safari/537.36\",\"dnt\":\"1\",\"accept-encoding\":\"gzip, deflate, sdch\",\"accept-language\":\"en-US,en;q=0.8\"}";
        String excId = UUID.randomUUID().toString();

        // Act
        Request.Builder builder = Request.builder(appId, reqId, grpId);
        builder.withRequestDateTime(new Date()).withCallerId(calId).withClientAddress(IPadd)
                .withHostAddress(IPadd).withHttpHeaders(headers).withPath(path).withSessionId(sesId)
                .withStatus(Status.FAILED).withResponseDateTime(new Date()).withExceptionId(excId)
                .withHttpMethod("GET");

        return builder.build();
    }
}
