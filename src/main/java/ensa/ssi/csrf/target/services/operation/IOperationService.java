package ensa.ssi.csrf.target.services.operation;

import ensa.ssi.csrf.target.entities.Operation;
import ensa.ssi.csrf.target.services.IBaseService;
import org.springframework.data.domain.Page;


public interface IOperationService extends IBaseService<Operation, Long> {
    void verser(Long codeCompte, double montant);
    void retirer(Long codeCompte, double montant);
    void virement(Long codeCompte1, Long codeCompte2, double montant);
    Page<Operation> opPageList(Long codeCompte, int page, int size);
}
