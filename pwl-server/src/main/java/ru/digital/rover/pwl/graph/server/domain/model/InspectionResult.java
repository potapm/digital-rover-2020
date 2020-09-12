package ru.digital.rover.pwl.graph.server.domain.model;

import javax.persistence.Embeddable;

@Embeddable
public class InspectionResult {

    private Long nodeId;

    private Float wireBreakPercent;

    private Float isolatorLostPercent;

    private Float gvpShiftedPercent;

    private Float score;
}
