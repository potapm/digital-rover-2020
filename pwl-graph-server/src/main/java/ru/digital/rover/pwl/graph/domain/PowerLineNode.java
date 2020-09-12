package ru.digital.rover.pwl.graph.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@NodeEntity
public class PowerLineNode {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Relationship(type = "WIRED", direction = Relationship.OUTGOING)
    private PowerLineNode belongRelationship;
}
