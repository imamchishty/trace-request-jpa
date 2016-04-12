package com.shedhack.trace.request.jpa.service;

import com.shedhack.trace.request.api.model.RequestModel;
import com.shedhack.trace.request.api.service.TraceRequestService;
import com.shedhack.trace.request.jpa.model.Request;
import com.shedhack.trace.request.jpa.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author imamchishty
 */
@Service
public class JpaTraceRequestService implements TraceRequestService<Request> {

    @Autowired
    private RequestRepository repo;

    public JpaTraceRequestService() {
    }

    public JpaTraceRequestService(RequestRepository repo) {
        this.repo = repo;
    }

    /**
     * {@inheritDoc}
     */
    public void persist(RequestModel requestModel) {
        repo.save((Request) requestModel);
    }

    /**
     * {@inheritDoc}
     */
    public Request findByRequestId(String s) {
        return repo.findOne(s);
    }

    /**
     * {@inheritDoc}
     */
    public List<Request> findByApplicationId(String s) {
        return repo.findByApplicationId(s);
    }

    /**
     * {@inheritDoc}
     */
    public List<Request> findByGroupId(String s) {
        return repo.findByGroupId(s);
    }

    /**
     * {@inheritDoc}
     */
    public List<Request> findByCallerId(String s) {
        return repo.findByCallerId(s);
    }

    /**
     * {@inheritDoc}
     */
    public List<Request> findByPath(String s) {
        return repo.findByPath(s);
    }

    /**
     * {@inheritDoc}
     */
    public List<Request> findBySessionId(String s) {
        return repo.findBySessionId(s);
    }

    /**
     * {@inheritDoc}
     */
    public List<Request> findByHttpMethod(String s) {
        return repo.findByHttpMethod(s);
    }

    /**
     * {@inheritDoc}
     */
    public List<Request> findByClientAddress(String s) {
        return repo.findByClientAddress(s);
    }

    /**
     * {@inheritDoc}
     */
    public List<Request> findByHostAddress(String s) {
        return repo.findByHostAddress(s);
    }

    /**
     * {@inheritDoc}
     */
    public List<Request> findByHeaders(String s) {
        return repo.findByHeaders(s);
    }

    /**
     * {@inheritDoc}
     */
    public List<Request> findByExceptionId(String s) {
        return repo.findByExceptionId(s);
    }

    /**
     * {@inheritDoc}
     */
    public List<Request> findByStatus(String s) {
        return repo.findByStatus(s);
    }
}
