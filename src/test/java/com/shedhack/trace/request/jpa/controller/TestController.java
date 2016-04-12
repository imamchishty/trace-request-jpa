package com.shedhack.trace.request.jpa.controller;

import com.shedhack.trace.request.api.constant.Status;
import com.shedhack.trace.request.api.model.RequestModel;
import com.shedhack.trace.request.jpa.model.Request;
import com.shedhack.trace.request.jpa.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by imamchishty on 12/04/2016.
 */
@RestController
public class TestController {

    @Autowired
    private RequestRepository repo;

    @RequestMapping("/make")
    public Request make() {
        Request request = Request.builder("hello-world", UUID.randomUUID().toString(),
                UUID.randomUUID().toString())
                .withRequestDateTime(new Date())
                .withClientAddress("12345")
                .withHostAddress("00000")
                .withHttpMethod("GET")
                .withHttpHeaders("headers")
                .withPath("/path")
                .withSessionId("khjdtyby")
                .withStatus(Status.COMPLETED).build();

        repo.save(request);

        return request;
    }


    @RequestMapping("/all")
    public List<Request> all() {
        return repo.findAll();
    }

    @RequestMapping("/one/{id}")
    public Request one(@PathVariable String id) {
        return repo.findOne(id);
    }

}
