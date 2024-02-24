package com.example.projectgestionlocationvoiture.controlleur;

import com.example.projectgestionlocationvoiture.entity.Client;
import com.example.projectgestionlocationvoiture.entity.Reservation;
import com.example.projectgestionlocationvoiture.entity.Voiture;
import com.example.projectgestionlocationvoiture.repository.ClientRepository;
import com.example.projectgestionlocationvoiture.repository.ReservationRepository;
import com.example.projectgestionlocationvoiture.repository.VoitureRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.sql.Date;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)

class ReservationTest {

    @Autowired
    private ClientRepository repoClient;

    @Autowired
    private VoitureRepository repoVoiture;

    @Autowired
    private ReservationRepository repoReservation;
    Client client = new Client();
    Voiture voiture = new Voiture();

    Reservation reservation=new Reservation();


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void saveReservation() {
        voiture.setModel("testModel");
        voiture.setLicense("testLicence");
        voiture.setMileage(126000);
        voiture.setPrice(20000);
        voiture.setYear(2022);
        voiture.setStatus("disponible");
        Voiture saveVoituer = repoVoiture.save(voiture);

        client.setIdVoiture(saveVoituer);
        client.setNom("testNom");
        client.setPrenom("testPrenom");
        client.setEmail("testEmail");
        Client saveClient = repoClient.save(client);

        reservation.setIdVoiture(saveVoituer);
        reservation.setidclient(saveClient);
        reservation.setDateReservation(Date.valueOf("2022-12-22"));
        reservation.setDateCirculation(Date.valueOf("2022-12-24"));
        Reservation saveReservation= repoReservation.save(reservation);

        Assertions.assertNotNull(saveReservation);

    }

    @Test
    void updateReservation() {
        voiture.setModel("testModel");
        voiture.setLicense("testLicence");
        voiture.setMileage(126000);
        voiture.setPrice(20000);
        voiture.setYear(2022);
        voiture.setStatus("disponible");
        Voiture saveVoituer = repoVoiture.save(voiture);

        client.setIdVoiture(saveVoituer);
        client.setNom("testNom");
        client.setPrenom("testPrenom");
        client.setEmail("testEmail");
        Client saveClient = repoClient.save(client);

        reservation.setIdVoiture(saveVoituer);
        reservation.setidclient(saveClient);
        reservation.setDateReservation(Date.valueOf("2022-12-22"));
        reservation.setDateCirculation(Date.valueOf("2022-12-24"));
        Reservation saveReservation= repoReservation.save(reservation);

        reservation.setDateRetour(Date.valueOf("2022-12-30"));
        Assertions.assertEquals(Date.valueOf("2022-12-30"),reservation.getDateRetour()) ;




    }

}