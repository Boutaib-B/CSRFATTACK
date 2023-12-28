package ensa.ssi.csrf.target.controllers;

import ensa.ssi.csrf.target.entities.Compte;
import ensa.ssi.csrf.target.services.operation.IOperationService;
import ensa.ssi.csrf.target.services.operation.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class OperationController {
    private IOperationService operationService;

    @Autowired
    public OperationController(IOperationService operationService) {
        this.operationService = operationService;
    }

    @RequestMapping(value = "/operations", method = RequestMethod.GET)
    public String create(Model model, @RequestParam("codeCompte") String codeCompte,
                         @RequestParam("opType") String opType,
                         @RequestParam("montant") String montant,
                         @RequestParam("codeBeneficiaire") Optional<String> codeBeneficiaire){

        Long code = Long.valueOf(codeCompte);
        Long codeBenefic = null;
        double amount = 0;
        try {
            if (codeBeneficiaire.isPresent()){
                codeBenefic = Long.valueOf(codeBeneficiaire.get());
            }
            amount = Double.parseDouble(montant);

            try {
                if(opType.equals("versement")){
                    operationService.verser(code, amount);
                } else if (opType.equals("retrait")) {
                    operationService.retirer(code, amount);
                } else if (opType.equals("virement")) {
                    operationService.virement(code, codeBenefic, amount);
                }
            } catch (Exception e){
                model.addAttribute("processingError", e);
                return "redirect:/comptes/"+code+"?error="+e.getMessage();
            }

        } catch(Exception e){
            model.addAttribute("validationError", new Exception("code n'est pas valide!"));
            return "redirect:/comptes/"+code+"?error="+e.getMessage();
        }

        return "redirect:/comptes/"+code;

    }

}
