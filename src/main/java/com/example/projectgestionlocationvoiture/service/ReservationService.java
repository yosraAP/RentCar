package com.example.projectgestionlocationvoiture.service;

import com.example.projectgestionlocationvoiture.entity.Reservation;
import com.example.projectgestionlocationvoiture.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public void save(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    public Reservation getReservationByIdVoiture(int idVoiture) {
        return this.reservationRepository.findByIdVoiture(idVoiture);
    }

    public void updateReservation(Integer idVoiture, Date dateReservation,Date dateCirculation) {
        if (reservationRepository.existsById(idVoiture)) {
            Reservation reservation = reservationRepository.findById(idVoiture).get();
            reservation.setDateReservation((java.sql.Date) dateReservation);
            reservation.setDateCirculation((java.sql.Date) dateCirculation);
        }
        }


    public void updateReservationDateRetour(Integer idVoiture, Date dateRetour) {
        if (reservationRepository.existsById(idVoiture)) {
            Reservation reservation =  reservationRepository.findById(idVoiture).get();
            reservation.setDateRetour((java.sql.Date) dateRetour);
        }

    }

    public List<ArrayList> getAllProductsUsingNativeQuery(int idVoiture) {
        return this.reservationRepository.getInformationVoitureByIdvoitureUsingNativeQuery(idVoiture);
    }


}
