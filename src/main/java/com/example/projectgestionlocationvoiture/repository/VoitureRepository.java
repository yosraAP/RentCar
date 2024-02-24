package com.example.projectgestionlocationvoiture.repository;

import com.example.projectgestionlocationvoiture.entity.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

public interface VoitureRepository extends JpaRepository<Voiture,Integer> {

    public List<Voiture> findVoitureByPrice(float price);

    public Voiture findVoitureByIdVoiture(int voiture);

    //upadate Attribute Status
    @Modifying
    @Query("update Voiture  v set v.status =?2 WHERE v.idVoiture=?1")
    void updateVoitureByIdVoiture( int idVoiture, String status);//update le status par idVoiture

    //List de voiture par Status  =loue  ou disponible
    public List<Voiture> findVoitureByStatus(String  status);


}
