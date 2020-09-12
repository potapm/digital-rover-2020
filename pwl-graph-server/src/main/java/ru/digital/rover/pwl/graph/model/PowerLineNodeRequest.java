package ru.digital.rover.pwl.graph.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class PowerLineNodeRequest {

    private String name;

    private Double latitude;

    private Double longitude;

    private Integer age;

    private List<String> lineIds;

    private Integer voltage;

    private Boolean enabled;
}
