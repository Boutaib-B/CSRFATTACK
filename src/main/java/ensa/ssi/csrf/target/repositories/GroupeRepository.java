package ensa.ssi.csrf.target.repositories;

import ensa.ssi.csrf.target.entities.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupeRepository extends JpaRepository<Groupe, Long> {
}
