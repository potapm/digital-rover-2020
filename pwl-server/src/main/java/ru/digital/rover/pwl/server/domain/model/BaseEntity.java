package ru.digital.rover.pwl.server.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@MappedSuperclass
abstract class BaseEntity<T extends Serializable> implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private T id;
}
