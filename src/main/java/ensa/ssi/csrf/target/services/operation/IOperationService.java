package ensa.ssi.csrf.target.services.operation;

import ensa.ssi.csrf.target.entities.Operation;
import ensa.ssi.csrf.target.services.IBaseService;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface IOperationService extends IBaseService<Operation, Long> {
    void verser(UUID codeCompte, double montant);
    void retirer(UUID codeCompte, double montant);
    void virement(UUID codeCompte1, UUID codeCompte2, double montant);
    Page<Operation> opPageList(UUID codeCompte, int page, int size);
}
