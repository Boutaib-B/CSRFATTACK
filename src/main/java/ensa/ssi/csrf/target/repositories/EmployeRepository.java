package ensa.ssi.csrf.target.repositories;

import ensa.ssi.csrf.target.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
}
