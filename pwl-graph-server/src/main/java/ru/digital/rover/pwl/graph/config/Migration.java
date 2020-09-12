package ru.digital.rover.pwl.graph.config;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.digital.rover.pwl.graph.domain.PowerLineNode;
import ru.digital.rover.pwl.graph.repositories.PowerLineRepository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Test data generation
 */
@Transactional
@RequiredArgsConstructor
@Component
public class Migration {

    private final PowerLineRepository powerLineRepository;

    @PostConstruct
    public void init() {
        List<PowerLineNode> line1 = new ArrayList<>();
        for (int index = 0; index < 10; index++) {
            PowerLineNode node = new PowerLineNode(null, "Node 1. " + index, 50. + index, 40. + index, 2,
                    index == 5 ? Arrays.asList("Line 1", "Line 2") : Collections.singletonList("Line 1"),
                    500, true, new ArrayList<>());
            line1.add(node);
            if (index > 0) {
                node.getNodes().add(line1.get(index - 1));
            }
        }

        List<PowerLineNode> line2 = new ArrayList<>();
        for (int index = 0; index < 10; index++) {
            PowerLineNode node = index == 5 ? line1.get(5) :
                    new PowerLineNode(null, "Node 2. " + index, 50. + index, 40. + index, 2,
                            Collections.singletonList("Line 2"), 500, true, new ArrayList<>());
            line2.add(node);
            if (index > 0) {
                if(index == 5){
                    line1.get(5).getNodes().add(line2.get(index-1));
                } else {
                    node.getNodes().add(line2.get(index - 1));
                }
            }
        }

        powerLineRepository.saveAll(line1);
        powerLineRepository.saveAll(line2);
    }

    @PreDestroy
    public void destructor() {
        powerLineRepository.deleteAll();
    }
}
