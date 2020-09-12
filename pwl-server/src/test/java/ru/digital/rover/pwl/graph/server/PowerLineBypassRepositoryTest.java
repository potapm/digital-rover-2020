package ru.digital.rover.pwl.graph.server;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.digital.rover.pwl.graph.server.domain.model.BypassEntity;
import ru.digital.rover.pwl.graph.server.domain.repository.BypassRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author pdtyreus
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PowerLineBypassRepositoryTest {

    @Autowired
    private BypassRepository bypassRepository;

    @Test
    void dbTest() {
        bypassRepository.save(new BypassEntity("123"));
        List<BypassEntity> all = bypassRepository.findAll();
        Assert.assertEquals(1, all.size());
    }

}
