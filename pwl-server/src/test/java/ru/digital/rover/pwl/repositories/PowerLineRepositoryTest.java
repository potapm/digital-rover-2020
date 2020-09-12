package ru.digital.rover.pwl.repositories;

import ru.digital.rover.pwl.domain.PowerLineNode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author pdtyreus
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class PowerLineRepositoryTest {


    @Autowired
    private PowerLineRepository powerLineRepository;

    @Test
    public void graphTest() {
        powerLineRepository.save(PowerLineNode.builder().name("123").build());
        PowerLineNode byName = powerLineRepository.findByName("123");
        Assert.assertEquals("123", byName.getName());
    }

}
