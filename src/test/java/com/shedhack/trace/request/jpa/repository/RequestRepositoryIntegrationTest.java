package com.shedhack.trace.request.jpa.repository;

import com.shedhack.trace.request.jpa.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author imamchishty
 *
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@Profile({"dev"})
public class RequestRepositoryIntegrationTest {

    @Autowired
    private RequestRepository repository;

    @Test
    public void test_context() {

    }

}
