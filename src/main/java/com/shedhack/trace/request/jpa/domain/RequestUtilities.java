package com.shedhack.trace.request.jpa.domain;

import com.shedhack.trace.request.api.model.RequestModel;
import com.shedhack.trace.request.jpa.domain.Request;

/**
 * Provides utilities for the JPA module.
 *
 * @author imamchishty
 */
public class RequestUtilities {

    /**
     * Checks if the provided implementation of the
     * {@link RequestModel} is actually an entity,
     * i.e. {@link Request}.
     *
     * @return true if 'domain' is an entity.
     */
    public static boolean isRequestEntity(RequestModel model) {

        if(model.getClass().isAssignableFrom(Request.class)) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    /**
     * Converts the Model to the Entity type.
     */
    public static Request mapFromModelToEntity(RequestModel model) {

        return new Request().builder(model.getApplicationId(),
                model.getRequestId(), model.getGroupId())
                .withRequestDateTime(model.getRequestDateTime())
                .withHttpMethod(model.getHttpMethod())
                .withStatus(model.getStatus())
                .withSessionId(model.getSessionId())
                .withCallerId(model.getCallerId())
                .withExceptionId(model.getExceptionId())
                .withHostAddress(model.getHostAddress())
                .withClientAddress(model.getClientAddress())
                .withPath(model.getPath())
                .withHttpHeaders(model.getHeaders())
                .withResponseDateTime(model.getResponseDateTime()).build();
    }

}
