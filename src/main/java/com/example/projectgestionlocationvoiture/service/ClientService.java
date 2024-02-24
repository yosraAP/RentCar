package com.example.projectgestionlocationvoiture.service;

import com.example.projectgestionlocationvoiture.entity.Client;
import com.example.projectgestionlocationvoiture.entity.Voiture;
import com.example.projectgestionlocationvoiture.repository.ClientRepository;
import com.example.projectgestionlocationvoiture.repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ClientService {

    @Autowired
    private ClientRepository clientRepository ;

    public void save(Client client) {

        clientRepository.save(client);
    }

    public List<Client> listsAll() {

        return clientRepository.findAll();
    }

    public Client getClientByIdclient(int idclient){
        return this.clientRepository.findClientByIdClient(idclient);
    }

    public Client getClientByIdVoiture(int idVoiture){
        return this.clientRepository.findClientByIdVoiture(idVoiture);
    }

}
