package ru.digital.rover.pwl.server.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class InspectionResult {

    private Long nodeId;

    private Float wireBreakPercent;

    private Float isolatorLostPercent;

    private Float gvpShiftedPercent;

    private Float score;
}
