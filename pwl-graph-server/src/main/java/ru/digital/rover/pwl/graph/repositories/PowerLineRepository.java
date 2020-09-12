package ru.digital.rover.pwl.graph.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import ru.digital.rover.pwl.graph.domain.PowerLineNode;

import java.util.List;

public interface PowerLineRepository extends Neo4jRepository<PowerLineNode, Long> {

    List<PowerLineNode> findAll();

    PowerLineNode findByName(String name);

    List<PowerLineNode> findAllByLineIdsContains(List<String> lineIds);
}
