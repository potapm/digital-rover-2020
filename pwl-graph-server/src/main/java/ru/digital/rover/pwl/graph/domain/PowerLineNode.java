package ru.digital.rover.pwl.graph.domain;

import lombok.*;
import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@NodeEntity
public class PowerLineNode {

    @Id
    @GeneratedValue
    private Long id;

    @Property
    private String name;

    @Property
    private Double latitude;

    @Property
    private Double longitude;

    @Property
    private Integer age;

    @Property
    private List<String> lineIds;

    @Property
    private Integer voltage;

    @Property
    private Boolean enabled;

    @Relationship(type = "WIRED", direction = Relationship.UNDIRECTED)
    private List<PowerLineNode> nodes = new ArrayList<>();
}
