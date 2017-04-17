package org.origami.trading.core.worker.daos.repositories;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.origami.trading.core.worker.entities.OrigamiProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by dmoreira on 4/17/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@TestPropertySource("classpath:test.application.properties")
public class BasicJpaIT {

    @Autowired
    OrigamiPropertiesRepository origamiPropertiesRepository;

    @Test
    public void saveOrigamiProperty() {
        OrigamiProperty origamiProperty = new OrigamiProperty();
        origamiProperty.setOpId("test_property.something");
        origamiProperty.setOpValue("234");
        origamiPropertiesRepository.save(origamiProperty);

        OrigamiProperty result = origamiPropertiesRepository.findOne("test_property.something");
        assertNotNull(result);
        assertEquals("234",result.getOpValue());
    }

    @Test
    public void findOneDefaultConfig() {
        OrigamiProperty result = origamiPropertiesRepository.findOne("tv.supports_search");
        assertNotNull(result);
        assertEquals("true",result.getOpValue());
    }

    @Test
    public void findOneNonExistentConfig() {
        OrigamiProperty result = origamiPropertiesRepository.findOne("tv.supports_searchGarbarge");
        assertNull(result);
    }

}
