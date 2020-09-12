package ru.digital.rover.pwl.graph.server.domain.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

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
}
