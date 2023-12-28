package ensa.ssi.csrf.target.repositories;

import ensa.ssi.csrf.target.entities.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface OperationRepository extends JpaRepository<Operation, Long> {
    @Query("SELECT o FROM Operation o WHERE o.compte.code=:c")
    Page<Operation> opPageList(@Param("c") UUID code, Pageable pageable);
}
