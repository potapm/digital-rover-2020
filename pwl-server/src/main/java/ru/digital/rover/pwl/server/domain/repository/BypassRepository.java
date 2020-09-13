package ru.digital.rover.pwl.server.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.digital.rover.pwl.server.domain.model.BypassEntity;

@Repository
public interface BypassRepository
        extends JpaRepository<BypassEntity, Long>, JpaSpecificationExecutor<BypassEntity> {
}
