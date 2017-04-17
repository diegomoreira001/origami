package org.origami.trading.core.worker.persistences;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by dmoreira on 4/16/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceRoutingManagerIT.TestConfiguration.class)
@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
public class PersistenceRoutingManagerIT {

//    @Autowired
//    private PersistenceRoutingManager persistenceRoutingManager;
//
    @Test
    public void findBarHappyTest() {


    }

    @Configuration
    public static class TestConfiguration {

    }
}