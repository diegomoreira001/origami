package org.origami.trading.core.worker.daos.rest.byma.connectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.origami.trading.core.worker.daos.rest.byma.MarketConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

/**
 * Created by dmoreira on 4/16/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BymaConnectionManagerIT.TestConfiguration.class)
@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
public class BymaConnectionManagerIT {

    @Autowired
    private BymaConnectionManager connectionManager;

    @Test
    public void getMarketConnectionHappyTest() throws Exception {
        MarketConnection marketConnection = connectionManager.getMarketConnection();
        assertEquals("https://wq.bolsar.com", marketConnection.getHost());
        assertTrue(marketConnection.getCookies() != null  && !marketConnection.getCookies().isEmpty());
        assertTrue(marketConnection.isAlive());
    }

    @Test
    public void establishConnectionHappyTest() throws Exception {
        MarketConnection marketConnection = connectionManager.establishConnection();
        assertEquals("https://wq.bolsar.com", marketConnection.getHost());
        assertTrue(marketConnection.getCookies() != null  && !marketConnection.getCookies().isEmpty());
        assertTrue(marketConnection.isAlive());
    }

    @Test
    public void establishConnectionInvalidHostTest() {
        boolean pass = false;
        connectionManager.setHost("https://wq.bolsar.co3131m");
        try {
            MarketConnection marketConnection = connectionManager.establishConnection();
        } catch (ResourceAccessException e) {
            pass = true;
        }
        assertTrue(pass);
    }

    @Configuration
    public static class TestConfiguration {
        @Bean
        public RestTemplate restTemplate() {
            return new RestTemplate();
        }

        @Bean
        public BymaConnectionManager bymaConnectionManager() {

            final String token = "ZG1vcmVpcmE2MkIyMTAwNkJGMzk1RTM3M0Y1NjQ1NUIyNUQzQ0U4NTA4";

            BymaConnectionManager manager = new BymaConnectionManager();
            manager.setHost("https://wq.bolsar.com");
            manager.setLoginPath("/BWQ/WQLogin.aspx");
            manager.setMaxAge(1500000L);
            manager.setRestTemplate(restTemplate());
            manager.setToken(token);
            manager.setMaxAttempts(2);

            return manager;
        }
    }

}