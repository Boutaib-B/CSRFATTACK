package ensa.ssi.csrf.target.services.compte;

import ensa.ssi.csrf.target.entities.Compte;
import ensa.ssi.csrf.target.repositories.CompteRepository;
import ensa.ssi.csrf.target.services.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service @Transactional @Slf4j
public class CompteService extends BaseService<Compte, UUID> implements ICompteService {
    private CompteRepository repository;

    @Autowired
    public CompteService(CompteRepository repository) {
        super(repository);
        this.repository = repository;
    }



}
