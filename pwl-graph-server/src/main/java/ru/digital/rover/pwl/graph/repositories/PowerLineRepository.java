package ru.digital.rover.pwl.graph.repositories;

import ru.digital.rover.pwl.graph.domain.PowerLineNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface PowerLineRepository extends Neo4jRepository<PowerLineNode, Long> {
    PowerLineNode findByName(String name);
}
