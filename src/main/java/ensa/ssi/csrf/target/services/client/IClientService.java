package ensa.ssi.csrf.target.services.client;

import ensa.ssi.csrf.target.entities.Client;
import ensa.ssi.csrf.target.services.IBaseService;

import java.util.List;

public interface IClientService extends IBaseService<Client, Long> {
    Client findClientByName(String name);
    List<Client> getByKeyword(String keyword);
}
