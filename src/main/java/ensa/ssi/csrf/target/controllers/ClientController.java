package ensa.ssi.csrf.target.controllers;

import ensa.ssi.csrf.target.entities.Client;
import ensa.ssi.csrf.target.services.client.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public String index(Model model) {
        List<Client> clients = clientService.getAllEntities();
        model.addAttribute("clients", clients);
        return "clients";
    }



//    @RequestMapping(value = "/clients", method = RequestMethod.POST)
//    public ResponseEntity.BodyBuilder add(@RequestBody Client client) {
//        clientService.saveEntity(client);
//        return ResponseEntity.created(URI.create("/clients"));
//    }
}
