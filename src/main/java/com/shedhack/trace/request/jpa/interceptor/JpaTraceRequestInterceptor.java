package com.shedhack.trace.request.jpa.interceptor;

import com.shedhack.trace.request.api.interceptor.TraceRequestInterceptor;
import com.shedhack.trace.request.api.model.RequestModel;
import com.shedhack.trace.request.api.service.TraceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author imamchishty
 */
@Service
public class JpaTraceRequestInterceptor implements TraceRequestInterceptor {

    @Autowired
    private TraceRequestService service;

    public JpaTraceRequestInterceptor() {
    }

    public JpaTraceRequestInterceptor(TraceRequestService service) {
        this.service = service;
    }

    /**
     * {@inheritDoc}
     */
    public void onEntry(RequestModel request) {
        service.persist(request);
    }

    /**
     * {@inheritDoc}
     */
    public void onExit(RequestModel request) {
        service.persist(request);
    }
}
