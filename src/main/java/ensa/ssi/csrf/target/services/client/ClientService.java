package ensa.ssi.csrf.target.services.client;

import ensa.ssi.csrf.target.entities.Client;
import ensa.ssi.csrf.target.repositories.ClientRepository;
import ensa.ssi.csrf.target.services.BaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service @Transactional @Slf4j
public class ClientService extends BaseService<Client, Long> implements IClientService {
    private final ClientRepository repository;

    @Autowired
    public ClientService(ClientRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public Client findClientByName(String name) {
        return repository.findByNom(name);
    }

    @Override
    public List<Client> getByKeyword(String keyword) {
        log.info("Searching in clients by kw : " + keyword);
        return repository.findByKeyword(keyword);
    }

}
