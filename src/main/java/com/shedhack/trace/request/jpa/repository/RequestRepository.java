package com.shedhack.trace.request.jpa.repository;

import com.shedhack.trace.request.jpa.domain.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author imamchishty
 */
public interface RequestRepository extends JpaRepository<Request, String> {
    
    List<? extends Request> findByApplicationId(String applicationId);

    List<? extends Request> findByGroupId(String groupId);

    List<? extends Request> findByCallerId(String callerId);

    List<? extends Request> findByPath(String path);

    List<? extends Request> findBySessionId(String sessionId);

    List<? extends Request> findByHttpMethod(String httpMethod);

    List<? extends Request> findByClientAddress(String clientAddress);

    List<? extends Request> findByHostAddress(String hostAddress);

    List<? extends Request> findByHeaders(String headers);

    List<? extends Request> findByExceptionId(String exceptionId);

    List<? extends Request> findByStatus(String status);
    
}
