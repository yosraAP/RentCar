package com.example.projectgestionlocationvoiture.controlleur;


import com.example.projectgestionlocationvoiture.entity.Client;
import com.example.projectgestionlocationvoiture.entity.Reservation;
import com.example.projectgestionlocationvoiture.entity.Voiture;
import com.example.projectgestionlocationvoiture.service.ClientService;
import com.example.projectgestionlocationvoiture.service.ReservationService;
import com.example.projectgestionlocationvoiture.service.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//@RestController //pour le voir en json
@Controller //pour le web
public class ReservationController {

    @Autowired
    private ReservationService  reservationService;
    private ClientService clientService;
    private VoitureService voitureService;

    //Constructoure
    public ReservationController(ReservationService reservationService, ClientService clientService, VoitureService voitureService) {
        this.reservationService = reservationService;
        this.clientService = clientService;
        this.voitureService = voitureService;
    }

    @GetMapping("/Reservation/{idVoiture}")
    public String getReservationByidVoiture(Model model, @PathVariable int idVoiture){


        //pour le object Reservation
        Reservation reservation = reservationService.getReservationByIdVoiture(idVoiture);
        model.addAttribute("reservation", reservation);

        return "reservation"; // nom de page html

    }

    @GetMapping("/getAllInformationVoiture/{idVoiture}")
    public String getAllInformationVoitureByIdvoitureUsingNativeQuery(Model model,@PathVariable int idVoiture) {
       List<ArrayList> info= reservationService.getAllProductsUsingNativeQuery(idVoiture);
        model.addAttribute("idVoiture", info.get(0).get(0));
        model.addAttribute("model", info.get(0).get(1));
        model.addAttribute("price", info.get(0).get(2));
        model.addAttribute("status", info.get(0).get(3));
        model.addAttribute("nom", info.get(0).get(4));
        model.addAttribute("prenom", info.get(0).get(5));
        model.addAttribute("date_reservation", info.get(0).get(6));
        model.addAttribute("date_circulation", info.get(0).get(7));
        model.addAttribute("date_retour", info.get(0).get(8));
         return "reservation";
    }

  }
