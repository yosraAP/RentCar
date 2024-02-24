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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

//@RestController //pour le voir en json
@Controller //pour le web
public class ClientController {
    @Autowired
    private ClientService clientService;
    private VoitureService voitureService;

    private ReservationService reservationService;

    //Constructor
    public ClientController(ClientService clientService, VoitureService voitureService, ReservationService reservationService) {
        this.clientService = clientService;
        this.voitureService = voitureService;
        this.reservationService = reservationService;
    }

    @GetMapping("/Client/{idVoituer}")
    public String showClientForm(@PathVariable Integer idVoituer, Model model, RedirectAttributes re) {
        // pour object de voiture
        Voiture voiture = voitureService.getVoitureByIdVoiture(idVoituer);
        model.addAttribute("voiture", voiture);

        //pour  object  de client
        Client client = new Client();
        model.addAttribute("client", client);

        // pour object de reservation
        Reservation reservation = new Reservation();
        model.addAttribute("reservation", reservation);

        // verifier le Voiture que  on ne peut pas être relouée
        if (voiture.getStatus().equals("loue")) {
            // afficher le message que on  ne peut pas être relouée
            re.addFlashAttribute("messageechec", "Cette voiture a déjà été louée et ne peut pas être relouée");

            return "redirect:/voitures";
        } else

            return "client_form"; // nom de page html
    }


    @PostMapping("/Client/New/{idVoiture}") //insérer un client avec idvoiture
    public String saveClient(Model model, @ModelAttribute("client") Client client, @ModelAttribute("reservation") Reservation reservation, @PathVariable Integer idVoiture, RedirectAttributes re) {

        //insere Client avec idVoiture
        client.setIdVoiture(voitureService.getVoitureByIdVoiture(idVoiture));
        clientService.save(client);

        // update status a loue
        String status = "loue";
        voitureService.updateVoitureStatus(idVoiture, status);

        //insert information de reservation
        reservation.setIdVoiture(voitureService.getVoitureByIdVoiture(idVoiture));
        reservation.setidclient(clientService.getClientByIdclient(client.getIdClient()));
        reservationService.save(reservation);

        // afficher le message success
        re.addFlashAttribute("message", "Vos informations ont été enregistrées avec succès sur la location de voitures ");
        return "redirect:/voitures";
    }

    @GetMapping("/clients")
    public List<Client> listClient() {
        return clientService.listsAll();
    }
}
