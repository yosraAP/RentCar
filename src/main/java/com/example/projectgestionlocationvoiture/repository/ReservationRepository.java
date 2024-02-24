package com.example.projectgestionlocationvoiture.repository;

import com.example.projectgestionlocationvoiture.entity.Reservation;
import com.example.projectgestionlocationvoiture.entity.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Integer> {

    public  Reservation findByIdVoiture(int idVoiture);

    //update attribute dateRetour a entity.Reservation
    @Modifying
    @Query("update Reservation  r set r.dateRetour=?2 WHERE r.idVoiture=?1")
    void updateReservationByDateRetour( int idVoiture, Date dateRetour);//update le dateRetour par idVoiture

    //getInformationVoitureByIdvoiture
    @Query(value="select v.id_voiture as id_voiture  ,v.model as model,v.price as price,v.status as status,c.nom as nom,c.prenom as prenom,r.date_reservation as date_reservation,r.date_circulation as date_circulation,r.date_retour as date_retour from voiture v  left join client c  on v.id_voiture=c.id_voiture_fk\n" +
            "left join reservation r on v.id_voiture=r.id_voiture_fk  where v.id_voiture=?1", nativeQuery= true)
    public List<ArrayList> getInformationVoitureByIdvoitureUsingNativeQuery(int idVoiture);
}
