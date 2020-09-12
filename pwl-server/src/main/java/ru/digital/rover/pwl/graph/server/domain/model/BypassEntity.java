package ru.digital.rover.pwl.graph.server.domain.model;

import lombok.*;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "bypass_records")
public class BypassEntity extends BaseEntity<Long> {

    private String description;

    private LocalDateTime bypassTime;

    @ElementCollection
    private List<InspectionResult> results;

    private Boolean hasDefects;

    private Boolean isScheduled;
}
