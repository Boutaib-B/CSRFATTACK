package ensa.ssi.csrf.target.services.operation;

import ensa.ssi.csrf.target.entities.*;
import ensa.ssi.csrf.target.repositories.CompteRepository;
import ensa.ssi.csrf.target.repositories.OperationRepository;
import ensa.ssi.csrf.target.services.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service @Transactional @Slf4j
public class OperationService extends BaseService<Operation, Long> implements IOperationService {
    private OperationRepository operationRepository;
    private CompteRepository compteRepository;

    @Autowired
    public OperationService(OperationRepository operationRepository, CompteRepository compteRepository) {
        super(operationRepository);
        this.operationRepository = operationRepository;
        this.compteRepository = compteRepository;
    }

    @Override
    public void verser(UUID codeCompte, double montant) {
        log.info("Versement dans compte "+codeCompte.toString()+", montant : "+montant);
        Compte compte = compteRepository.getOne(codeCompte);
        if (compte == null)
            throw new RuntimeException("Compte untrouvable");
        Operation op = new Versement(new Date(), montant, compte);
        compte.setSolde(compte.getSolde()+montant);
        compteRepository.save(compte);
        operationRepository.save(op);
    }

    @Override
    public void retirer(UUID codeCompte, double montant) {
        log.info("Retrait sur compte "+codeCompte.toString()+", montant : "+montant);
        Compte compte = compteRepository.getOne(codeCompte);
        if (compte == null)
            throw new RuntimeException("Compte untrouvable");
        double facilitesCaisse = 0;
        if (compte instanceof CompteCourant)
            facilitesCaisse = ((CompteCourant) compte).getDecouvert();
        if(compte.getSolde()+facilitesCaisse < montant)
            throw new RuntimeException("Solde unsuffisant");
        Operation op = new Retrait(new Date(), montant, compte);
        compte.setSolde(compte.getSolde()-montant);
        compteRepository.save(compte);
        operationRepository.save(op);
    }

    @Override
    public void virement(UUID codeCompte1, UUID codeCompte2, double montant) {
        if (codeCompte1.equals(codeCompte2))
            throw new RuntimeException("Impossible virement sur le meme compte!");
        retirer(codeCompte1, montant);
        verser(codeCompte2, montant);
    }

    @Override
    public Page<Operation> opPageList(UUID codeCompte, int page, int size) {
        return operationRepository.opPageList(codeCompte, PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "date")));
    }
}
