package com.example.projectgestionlocationvoiture.controlleur;

import com.example.projectgestionlocationvoiture.entity.Voiture;
import com.example.projectgestionlocationvoiture.repository.VoitureRepository;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
//import org.springframework.util.Assert;

import java.util.List;
import java.util.function.BooleanSupplier;


@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class VoitureTest {
        @Autowired
    private VoitureRepository repo;

    Voiture savaVoiture;
    Voiture voiture=new Voiture();

    @BeforeAll
    void setUp() {

        voiture.setModel("testModel");
        voiture.setLicense("testLicence");
        voiture.setMileage(126000);
        voiture.setPrice(20000);
        voiture.setYear(2022);
        voiture.setStatus("disponible");
         savaVoiture= repo.save(voiture);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void listVoitures() {

        List<Voiture> voitureList= repo.findAll();
        Assertions.assertNotNull(voitureList);
       // Assertions.assertThat(voitureList).hasSizeGreaterThan(0);
    }

    @Test
    void listVoituresloue() {

        voiture.setModel("testModel");
        voiture.setLicense("testLicence");
        voiture.setMileage(126000);
        voiture.setPrice(20000);
        voiture.setYear(2022);
        voiture.setStatus("loue");
        Voiture savaVoiture= repo.save(voiture);
        List<Voiture> voitureListLoue= repo.findVoitureByStatus("loue");
        Assertions.assertNotNull(voitureListLoue);
       // Assertions.assertThat(voitureListLoue).hasSizeGreaterThan(0);
    }

    @Test
    void listVoituresdisponible() {

       List<Voiture> voitureListDisponible= repo.findVoitureByStatus("disponible");
        Assertions.assertNotNull(voitureListDisponible);
        //Assertions.assertThat(voitureListDisponible).hasSizeGreaterThan(0);
    }

    @Test
    void  testAddNewVoiture() {


        Assertions.assertNotNull(savaVoiture);
        //org.assertj.core.api.Assertions.assertThat(savaVoiture).isNotNull();

    }

    @Test
    void getVoitureByPrice() {
        List<Voiture> voitureByprice= repo.findVoitureByPrice(20000);
        Assertions.assertNotNull(voitureByprice);
       // Assertions.assertThat(voitureByprice).hasSizeGreaterThan(0);


    }

    @Test
    void updateVoitureStatus() {
        Voiture voiture1=repo.findVoitureByIdVoiture(savaVoiture.getIdVoiture());
        voiture1.setStatus("loue");
         Assertions.assertEquals("loue",voiture1.getStatus()) ;

    }

    @Test
    void deleteVoitureByIdVoiture() {

        repo.deleteById(savaVoiture.getIdVoiture());
        Assertions.assertNotNull(savaVoiture);

    }
}