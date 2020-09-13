package ru.digital.rover.pwl.server.domain.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "bypass_records")
public class BypassEntity extends BaseEntity<Long> {

    public BypassEntity(String description, LocalDateTime bypassTime, List<InspectionResult> results, Boolean hasDefects, Boolean isScheduled) {
        this.description = description;
        this.bypassTime = bypassTime;
        this.results = results;
        this.hasDefects = hasDefects;
        this.isScheduled = isScheduled;
    }

    private String description;

    private LocalDateTime bypassTime;

    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime updateDate;

    @ElementCollection
    private List<InspectionResult> results = new ArrayList<>();

    private Boolean hasDefects;

    private Boolean isScheduled;
}
