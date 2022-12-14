package com.usa.palcosapp_1.repository;

import com.usa.palcosapp_1.model.Client;
import com.usa.palcosapp_1.repository.crudrepository.BoxCrudRepository;
import com.usa.palcosapp_1.repository.crudrepository.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {
    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<Client> getAll(){
        return (List<Client>) clientCrudRepository.findAll();
    }

    public Optional<Client> getById(Integer id){
        return clientCrudRepository.findById(id);
    }

    public Client save(Client client){
        return clientCrudRepository.save(client);
    }

    public  void  delete (Client client){
        clientCrudRepository.delete(client);
    }
}

