package com.shedhack.trace.request.jpa.service;

import com.shedhack.trace.request.api.model.RequestModel;
import com.shedhack.trace.request.api.service.TraceRequestService;
import com.shedhack.trace.request.jpa.model.Request;
import com.shedhack.trace.request.jpa.repository.RequestRepository;

import java.util.List;

/**
 * @author imamchishty
 */
public class JpaTraceRequestService implements TraceRequestService<Request> {

    private RequestRepository repo;

    public JpaTraceRequestService(RequestRepository repo) {
        this.repo = repo;
    }

    public void persist(RequestModel requestModel) {
        repo.save((Request) requestModel);
    }

    public Request findByRequestId(String s) {
        return repo.findOne(s);
    }

    public List<Request> findByApplicationId(String s) {
return null;    }

    public List<Request> findByGroupId(String s) {
        return null;
    }

    public List<Request> findByCallerId(String s) {
        return null;
    }

    public List<Request> findByPath(String s) {
        return null;
    }

    public List<Request> findBySessionId(String s) {
        return null;
    }

    public List<Request> findByHttpMethod(String s) {
        return null;
    }

    public List<Request> findByClientAddress(String s) {
        return null;
    }

    public List<Request> findByHostAddress(String s) {
        return null;
    }

    public List<Request> findByHeaders(String s) {
        return null;
    }

    public List<Request> findByExceptionId(String s) {
        return null;
    }

    public List<Request> findByStatus(String s) {
        return null;
    }
}
