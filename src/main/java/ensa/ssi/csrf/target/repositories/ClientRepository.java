package ensa.ssi.csrf.target.repositories;

import ensa.ssi.csrf.target.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByNom(String nom);
    @Query("SELECT c FROM Client c WHERE c.nom LIKE :kw")
    List<Client> findByKeyword(@Param("kw") String kw);
}
