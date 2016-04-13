package com.shedhack.trace.request.jpa.service;

import com.shedhack.trace.request.api.constant.Status;
import com.shedhack.trace.request.api.model.RequestModel;
import com.shedhack.trace.request.jpa.Application;
import com.shedhack.trace.request.jpa.domain.Request;
import com.shedhack.trace.request.jpa.domain.RequestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author imamchishty
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@Profile({"dev"})
public class JpaTraceRequestServiceTest {

    @Autowired
    private JpaTraceRequestService service;

    @Test
    public void should_persist_request() {

        Request model = RequestHelper.buildDynamic();

        // Try to save
        service.persist(model);

        // Try and load
        assertNotNull(service.findByRequestId(model.getRequestId()));
    }

    @Test
    public void should_find_by_app_id() {

        // Arrange the requests
        Request model1 = RequestHelper.buildDynamic();
        Request model2 = RequestHelper.buildDynamic();
        Request model3 = RequestHelper.buildDynamic();
        Request model4 = RequestHelper.buildDynamic();

        // set the app id
        model1.setApplicationId("ABC");
        model2.setApplicationId("ABC");
        model3.setApplicationId("ABC");
        model4.setApplicationId("ABC");

        // Save all
        service.persist(model1);
        service.persist(model2);
        service.persist(model3);
        service.persist(model4);

        // Act
        List<Request> requests = (List<Request>) service.findByApplicationId("ABC");
        assertEquals(4, requests.size());
        assertEquals(model1, requests.get(0));
        assertEquals(model2, requests.get(1));
        assertEquals(model3, requests.get(2));
        assertEquals(model4, requests.get(3));
    }

    @Test
    public void should_find_by_group_id() {

        // Arrange the requests
        Request model1 = RequestHelper.buildDynamic();
        Request model2 = RequestHelper.buildDynamic();
        Request model3 = RequestHelper.buildDynamic();
        Request model4 = RequestHelper.buildDynamic();

        // set the group id
        model1.setGroupId("ABC");
        model2.setGroupId("ABC");
        model3.setGroupId("ABC");
        model4.setGroupId("ABC");

        // Save all
        service.persist(model1);
        service.persist(model2);
        service.persist(model3);
        service.persist(model4);

        // Act
        List<Request> requests = (List<Request>) service.findByGroupId("ABC");
        assertEquals(4, requests.size());
        assertEquals(model1, requests.get(0));
        assertEquals(model2, requests.get(1));
        assertEquals(model3, requests.get(2));
        assertEquals(model4, requests.get(3));
    }

}
