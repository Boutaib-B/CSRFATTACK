package ensa.ssi.csrf.target.repositories;

import ensa.ssi.csrf.target.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompteRepository extends JpaRepository<Compte, UUID> {
    Compte getOne(UUID code);
}
