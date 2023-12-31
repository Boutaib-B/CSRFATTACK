package ensa.ssi.csrf.target;

import ensa.ssi.csrf.target.entities.Client;
import ensa.ssi.csrf.target.entities.Compte;
import ensa.ssi.csrf.target.entities.CompteCourant;
import ensa.ssi.csrf.target.entities.CompteEpargne;
import ensa.ssi.csrf.target.services.client.IClientService;
import ensa.ssi.csrf.target.services.compte.ICompteService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class TargetApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(TargetApplication.class, args);

        System.out.println("________________ Clients ________________");
        IClientService clientService = ctx.getBean(IClientService.class);
        Client client1 = clientService.saveEntity(new Client("OTHMANE HANYF", "othmane"));
        Client client2 = clientService.saveEntity(new Client("WAFAE ABOUZBIBA", "wafae"));
        Client client3 = clientService.saveEntity(new Client("HIND GLIUOLA", "hind"));
        Client client4 = clientService.saveEntity(new Client("HAJAR FAIZ", "hajar"));
        List<Client> clients = clientService.getAllEntities();
        clients.forEach(c -> System.out.println(c.getNom()));

        System.out.println("________________ Comptes ________________");
        ICompteService compteService = ctx.getBean(ICompteService.class);
        compteService.saveEntity(new CompteCourant(new Date(), 9000, client1, 8000));
        compteService.saveEntity(new CompteCourant(new Date(), 10000, client2, 8000));
        compteService.saveEntity(new CompteEpargne(new Date(), 9000, client1, 5.5));

        List<Compte> comptes = compteService.getAllEntities();
        comptes.forEach(c -> System.out.println(c.getCode()));
    }
}
