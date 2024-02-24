package com.example.projectgestionlocationvoiture.controlleur;

import com.example.projectgestionlocationvoiture.entity.Client;
import com.example.projectgestionlocationvoiture.entity.Voiture;
import com.example.projectgestionlocationvoiture.repository.ClientRepository;
import com.example.projectgestionlocationvoiture.repository.VoitureRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)

class ClientTest {

    @Autowired
    private ClientRepository repoClient;

    @Autowired
    private VoitureRepository repoVoiture;

    Client client = new Client();
    Voiture voiture = new Voiture();
    Voiture saveVoituer;
    Client saveClient;

    @BeforeEach
    void setUp() {
        voiture.setModel("testModel");
        voiture.setLicense("testLicence");
        voiture.setMileage(126000);
        voiture.setPrice(20000);
        voiture.setYear(2022);
        voiture.setStatus("disponible");
         saveVoituer = repoVoiture.save(voiture);

        client.setIdVoiture(saveVoituer);
        client.setNom("testNom");
        client.setPrenom("testPrenom");
        client.setEmail("testEmail");
         saveClient = repoClient.save(client);


    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void saveClient() {

       // Client saveClient = repoClient.save(client);

        Assertions.assertNotNull(saveClient);
    }

    @Test
    void listClient() {
        //Client saveClient = repoClient.save(client);

        List<Client> listClient = repoClient.findAll();
        Assertions.assertNotNull(listClient);
    }
}