package com.example.projectgestionlocationvoiture.repository;

import com.example.projectgestionlocationvoiture.entity.Client;
import com.example.projectgestionlocationvoiture.entity.Reservation;
import com.example.projectgestionlocationvoiture.entity.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Integer> {

    public Client findClientByIdClient(int idclient);

    public Client findClientByIdVoiture(int idVoiture);
}
