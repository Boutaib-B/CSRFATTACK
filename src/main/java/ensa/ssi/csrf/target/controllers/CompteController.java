package ensa.ssi.csrf.target.controllers;

import ensa.ssi.csrf.target.entities.Compte;
import ensa.ssi.csrf.target.entities.Operation;
import ensa.ssi.csrf.target.services.compte.CompteService;
import ensa.ssi.csrf.target.services.operation.OperationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
public class CompteController {
    private CompteService compteService;
    private OperationService operationService;

    @Autowired
    public CompteController(CompteService compteService, OperationService operationService) {
        this.compteService = compteService;
        this.operationService = operationService;
    }

    @RequestMapping("/comptes")
    public String index(Model model){
        try {
            List<Compte> comptes = compteService.getAllEntities();
            model.addAttribute("comptes", comptes);
        } catch (Exception e) {
            model.addAttribute("exception", e);
        } finally {
            return "compte";
        }
    }

    @RequestMapping("/comptes/{suuid}")
    public String single(Model model, @PathVariable("suuid") String suuid){
        UUID uuid = UUID.fromString(suuid);
        try {
            Optional<Compte> compte = compteService.findEntityByKey(uuid);
            if (compte.isEmpty()) {
                return "404";
            }
            Page<Operation> opListPage = operationService.opPageList(uuid, 0, 4);
            model.addAttribute("opListPage", opListPage.getContent());
            model.addAttribute("compte", compte.get());
        } catch (Exception e) {
            model.addAttribute("exception", e);
        } finally {
            return "compte";
        }
    }
}
