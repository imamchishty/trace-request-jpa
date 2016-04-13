package com.shedhack.trace.request.jpa.service;

import com.shedhack.trace.request.api.model.RequestModel;
import com.shedhack.trace.request.api.service.TraceRequestService;
import com.shedhack.trace.request.jpa.domain.Request;
import com.shedhack.trace.request.jpa.domain.RequestUtilities;
import com.shedhack.trace.request.jpa.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author imamchishty
 */
@Service
public class JpaTraceRequestService implements TraceRequestService {

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

        // check if the type is already a domain domain (i.e. an entity)
        // If not then convert.

        if(RequestUtilities.isRequestEntity(requestModel)) {
            repo.save((Request) requestModel);
        }

        repo.save(RequestUtilities.mapFromModelToEntity(requestModel));
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
    public List<? extends Request> findByApplicationId(String s) {
        return repo.findByApplicationId(s);
    }

    /**
     * {@inheritDoc}
     */
    public List<? extends Request> findByGroupId(String s) {
        return repo.findByGroupId(s);
    }

    /**
     * {@inheritDoc}
     */
    public List<? extends Request> findByCallerId(String s) {
        return repo.findByCallerId(s);
    }

    /**
     * {@inheritDoc}
     */
    public List<? extends Request> findByPath(String s) {
        return repo.findByPath(s);
    }

    /**
     * {@inheritDoc}
     */
    public List<? extends Request> findBySessionId(String s) {
        return repo.findBySessionId(s);
    }

    /**
     * {@inheritDoc}
     */
    public List<? extends Request> findByHttpMethod(String s) {
        return repo.findByHttpMethod(s);
    }

    /**
     * {@inheritDoc}
     */
    public List<? extends Request> findByClientAddress(String s) {
        return repo.findByClientAddress(s);
    }

    /**
     * {@inheritDoc}
     */
    public List<? extends Request> findByHostAddress(String s) {
        return repo.findByHostAddress(s);
    }

    /**
     * {@inheritDoc}
     */
    public List<? extends Request> findByHeaders(String s) {
        return repo.findByHeaders(s);
    }

    /**
     * {@inheritDoc}
     */
    public List<? extends Request> findByExceptionId(String s) {
        return repo.findByExceptionId(s);
    }

    /**
     * {@inheritDoc}
     */
    public List<? extends Request> findByStatus(String s) {
        return repo.findByStatus(s);
    }
}
