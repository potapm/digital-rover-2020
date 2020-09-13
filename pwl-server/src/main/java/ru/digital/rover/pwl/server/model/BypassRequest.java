package ru.digital.rover.pwl.server.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BypassRequest {

    private String description;

    private LocalDateTime bypassTime;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    private List<InspectionResultDto> results = new ArrayList<>();

    private Boolean hasDefects;

    private Boolean isScheduled;

}
