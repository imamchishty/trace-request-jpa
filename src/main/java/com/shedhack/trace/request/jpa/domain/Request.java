package com.shedhack.trace.request.jpa.domain;

import com.shedhack.trace.request.api.constant.Status;
import com.shedhack.trace.request.api.model.RequestModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * <pre>
 *  Request domain containing the following properties:
 *
 *  applicationId, requestId, groupId, callerId, path, sessionId, httpMethod,
 *  clientAddress, hostAddress, requestDateTime, http headers, status
 *  responseDateTime, exceptionId.
 *
 * </pre>
 *
 * @author imamchishty
 */
@Entity
public class Request implements RequestModel, Serializable {


    // ----------------------------------
    // Static inner class for the builder
    // ----------------------------------

    public static class Builder {

        public Builder(String appId, String reqId, String groupId) {
            withApplicationId(appId).withRequestId(reqId).withGroupId(groupId);
        }

        Request model = new Request();

        private Builder withApplicationId(String id) {
            model.applicationId = id;
            return this;
        }

        public Builder withRequestDateTime(Date date){
            model.requestDateTime = date;
            return this;
        }

        private Builder withRequestId(String requestId) {
            model.requestId = requestId;
            return this;
        }

        private Builder withGroupId(String groupId) {
            model.groupId = groupId;
            return this;
        }

        public Builder withCallerId(String callerId) {
            model.callerId = callerId;
            return this;
        }

        public Builder withPath(String path) {
            model.path = path;
            return this;
        }

        public Builder withSessionId(String sessionId) {
            model.sessionId = sessionId;
            return this;
        }

        public Builder withHttpMethod(String method) {
            model.httpMethod = method;
            return this;
        }

        public Builder withClientAddress(String address) {
            model.clientAddress = address;
            return this;
        }

        public Builder withHostAddress(String address) {
            model.hostAddress= address;
            return this;
        }

        public Builder withHttpHeaders(String headers) {
            model.headers = headers;
            return this;
        }

        public Builder withExceptionId(String exceptionId) {
            model.exceptionId = exceptionId;
            return this;
        }

        public Builder withStatus(Status status) {
            model.status = status;
            return this;
        }

        public Builder withResponseDateTime(Date date) {
            model.responseDateTime = date;
            return this;
        }


        public Request build() {
            return model;
        }


    }

    // ----------------
    // Static method
    // ----------------

    public static Builder builder(String applicationId, String requestId, String groupId) {
        return new Builder(applicationId, requestId, groupId);
    }

    // -----------------------
    // Request Model variables
    // -----------------------

    @Id
    @Column(name = "request_id", length = 36)
    private String requestId;

    @Column(name = "application_id", nullable = false, length = 36)
    private String applicationId;

    @Column(name = "group_id", nullable = false, length = 36)
    private String groupId;

    @Column(name = "caller_id", length = 36)
    private String callerId;

    @Column(name = "path", nullable = false, length =2048)
    private String path;

    @Column(name = "session_id", nullable = false, length = 36)
    private String sessionId;

    @Column(name = "http_method", nullable = false, length = 10)
    private String httpMethod;

    @Column(name = "client_address", nullable = false, length = 50)
    private String clientAddress;

    @Column(name = "host_address", nullable = false, length = 50)
    private String hostAddress;

    @Column(name = "headers", nullable = false, length =2048)
    private String headers;

    @Column(name = "exception_id", length = 36)
    private String exceptionId;

    @Column(name = "request_date_time", nullable = false)
    private Date requestDateTime;

    @Column(name = "response_date_time")
    private Date responseDateTime;

    @Column(name = "status", nullable = false, length = 16)
    private Status status;

    // Added for JPA, outside of JPA should use the Builder.
    protected Request() {
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getCallerId() {
        return callerId;
    }

    public void setCallerId(String callerId) {
        this.callerId = callerId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getHostAddress() {
        return hostAddress;
    }

    public void setHostAddress(String hostAddress) {
        this.hostAddress = hostAddress;
    }

    public Date getRequestDateTime() {
        return requestDateTime;
    }

    public void setRequestDateTime(Date requestDateTime) {
        this.requestDateTime = requestDateTime;
    }

    public String getHeaders() {
        return headers;
    }

    public void setHeaders(String headers) {
        this.headers = headers;
    }

    public Date getResponseDateTime() {
        return responseDateTime;
    }

    public void setResponseDateTime(Date responseDateTime) {
        this.responseDateTime = responseDateTime;
    }

    public String getExceptionId() {
        return exceptionId;
    }

    public void setExceptionId(String exceptionId) {
        this.exceptionId = exceptionId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Request request = (Request) o;

        if (requestId != null ? !requestId.equals(request.requestId) : request.requestId != null) return false;
        if (applicationId != null ? !applicationId.equals(request.applicationId) : request.applicationId != null)
            return false;
        if (groupId != null ? !groupId.equals(request.groupId) : request.groupId != null) return false;
        if (callerId != null ? !callerId.equals(request.callerId) : request.callerId != null) return false;
        if (path != null ? !path.equals(request.path) : request.path != null) return false;
        if (sessionId != null ? !sessionId.equals(request.sessionId) : request.sessionId != null) return false;
        if (httpMethod != null ? !httpMethod.equals(request.httpMethod) : request.httpMethod != null) return false;
        if (clientAddress != null ? !clientAddress.equals(request.clientAddress) : request.clientAddress != null)
            return false;
        if (hostAddress != null ? !hostAddress.equals(request.hostAddress) : request.hostAddress != null) return false;
        if (headers != null ? !headers.equals(request.headers) : request.headers != null) return false;
        if (exceptionId != null ? !exceptionId.equals(request.exceptionId) : request.exceptionId != null) return false;
        if (requestDateTime != null ? !requestDateTime.equals(request.requestDateTime) : request.requestDateTime != null)
            return false;
        if (responseDateTime != null ? !responseDateTime.equals(request.responseDateTime) : request.responseDateTime != null)
            return false;
        return status == request.status;

    }

    @Override
    public int hashCode() {
        int result = requestId != null ? requestId.hashCode() : 0;
        result = 31 * result + (applicationId != null ? applicationId.hashCode() : 0);
        result = 31 * result + (groupId != null ? groupId.hashCode() : 0);
        result = 31 * result + (callerId != null ? callerId.hashCode() : 0);
        result = 31 * result + (path != null ? path.hashCode() : 0);
        result = 31 * result + (sessionId != null ? sessionId.hashCode() : 0);
        result = 31 * result + (httpMethod != null ? httpMethod.hashCode() : 0);
        result = 31 * result + (clientAddress != null ? clientAddress.hashCode() : 0);
        result = 31 * result + (hostAddress != null ? hostAddress.hashCode() : 0);
        result = 31 * result + (headers != null ? headers.hashCode() : 0);
        result = 31 * result + (exceptionId != null ? exceptionId.hashCode() : 0);
        result = 31 * result + (requestDateTime != null ? requestDateTime.hashCode() : 0);
        result = 31 * result + (responseDateTime != null ? responseDateTime.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Request{" +
                "requestId='" + requestId + '\'' +
                ", applicationId='" + applicationId + '\'' +
                ", groupId='" + groupId + '\'' +
                ", callerId='" + callerId + '\'' +
                ", path='" + path + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", httpMethod='" + httpMethod + '\'' +
                ", clientAddress='" + clientAddress + '\'' +
                ", hostAddress='" + hostAddress + '\'' +
                ", headers='" + headers + '\'' +
                ", exceptionId='" + exceptionId + '\'' +
                ", requestDateTime=" + requestDateTime +
                ", responseDateTime=" + responseDateTime +
                ", status=" + status +
                '}';
    }
}
