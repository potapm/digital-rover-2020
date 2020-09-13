package ru.digital.rover.pwl.server.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InspectionResultDto {

    private Long nodeId;

    private Float wireBreakPercent;

    private Float isolatorLostPercent;

    private Float gvpShiftedPercent;

    private Float score;
}
