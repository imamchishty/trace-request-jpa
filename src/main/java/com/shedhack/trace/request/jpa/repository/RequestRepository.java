package com.shedhack.trace.request.jpa.repository;

import com.shedhack.trace.request.jpa.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author imamchishty
 */
public interface RequestRepository extends JpaRepository<Request, String> {
    
    List<Request> findByApplicationId(String applicationId);

    List<Request> findByGroupId(String groupId);

    List<Request> findByCallerId(String callerId);

    List<Request> findByPath(String path);

    List<Request> findBySessionId(String sessionId);

    List<Request> findByHttpMethod(String httpMethod);

    List<Request> findByClientAddress(String clientAddress);

    List<Request> findByHostAddress(String hostAddress);

    List<Request> findByHeaders(String headers);

    List<Request> findByExceptionId(String exceptionId);

    List<Request> findByStatus(String status);
    
}
