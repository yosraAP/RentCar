package com.example.projectgestionlocationvoiture.controlleur;

import com.example.projectgestionlocationvoiture.entity.Client;
import com.example.projectgestionlocationvoiture.entity.Reservation;
import com.example.projectgestionlocationvoiture.entity.Voiture;
import com.example.projectgestionlocationvoiture.service.ReservationService;
import com.example.projectgestionlocationvoiture.service.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import  java.sql.Timestamp;

//@RestController //pour le voir en json
@Controller //pour le web
public class VoitureController {
    @Autowired
    private VoitureService voitureService;
    private ReservationService reservationService;

    //Constructor
    public VoitureController(VoitureService voitureService, ReservationService reservationService) {
        this.voitureService = voitureService;
        this.reservationService = reservationService;
    }

    @GetMapping("/")
    public String welCome( ){

        return "index"; // nom de page html
    }

    @GetMapping("/voitures")
    public String listVoitures( Model model){

        List<Voiture> listVoiture = voitureService.listsAll();
        model.addAttribute("voiture", new Voiture());
        model.addAttribute("listVoiture", listVoiture);
        model.addAttribute("pageTitle", "List des Voiture ");
        return "voitures"; // nom de page html
    }

    @GetMapping("/voitures/loue")
    public String listVoituresloue( Model model){

        List<Voiture> listVoiture = voitureService.getVoitureByStatus("loue");
        model.addAttribute("voiture", new Voiture());
        model.addAttribute("listVoiture", listVoiture);
        model.addAttribute("pageTitle", "List des Voiture loue");
        return "voitures"; // nom de page html
    }

    @GetMapping("/voitures/disponible")
    public String listVoituresdisponible( Model model){

        List<Voiture> listVoiture= voitureService.getVoitureByStatus("disponible");
        model.addAttribute("voiture", new Voiture());
        model.addAttribute("listVoiture", listVoiture);
        model.addAttribute("pageTitle", "List des Voiture disponible");
        return "voitures"; // nom de page html
    }

    @PostMapping //insérer un Voiture
    public void registerNewVoiture(@RequestBody Voiture voituer){//Via un formulaire : le Voiture
        voitureService.save(voituer);}



    @RequestMapping("/getVoitureByPrice")
    public String getVoitureByPrice( float price,Model model){
        List<Voiture> voitureList= voitureService.getVoitureByPrice(price);
        model.addAttribute("listVoiture", voitureList);
        return "rechercheVoiturParPrice_Form";
    }


    @GetMapping("/voitures/price")
    public String showRechercheVoitureParPriceForm( Model model) {
        // pour object de voiture
        List<Voiture> listVoiture = voitureService.listsAll();
        model.addAttribute("listVoiture", listVoiture);
        model.addAttribute("voiture", new Voiture());
        return "rechercheVoiturParPrice_Form"; // nom de page html
    }

    @GetMapping("/voituresReturn/{idVoiture}")
    public String showretourVoiture_form( Model model,@PathVariable  Integer idVoiture) {
        // pour object de voiture
        Voiture voiture = voitureService.getVoitureByIdVoiture(idVoiture);
        model.addAttribute("voiture", voiture);

        return "retourVoiture_form"; // nom de page html
    }


    /**
     * @PathVariable Pour indiquer ce idVoiture est lié a ce que je mets dans url
     * @param idVoiture
     *
     */
    @GetMapping(path = "/voituresReturn/return/{idVoiture}")
    public String updateVoitureStatus(@PathVariable  Integer idVoiture , Date dateRetour, @ModelAttribute("reservation") Reservation reservation, @ModelAttribute("voiture") Voiture voiture
                                      //, @RequestParam(value = "dateRetour", required = false) Date dateRetour  //Parametres qu'on veut modifier
                              ) {


     String status="disponible";
     voitureService.updateVoitureStatus(idVoiture,status);

     //insert attribute dateRetour sur le tabel reservation
     reservationService.updateReservationDateRetour(idVoiture, dateRetour);

     return "redirect:/voitures";
    }



   // @DeleteMapping
    @GetMapping ("/voitures/Delete/{idVoiture}")
    public String deleteVoitureByIdVoiture(@PathVariable Integer idVoiture, RedirectAttributes re) {

        Voiture voiture = voitureService.getVoitureByIdVoiture(idVoiture);
        // verifier le Voiture ,si on a déjà été louee,  on ne peut pas supprimer
        if (voiture.getStatus().equals("loue")) {
            // afficher le message que on ne peut pas supprimmer
            re.addFlashAttribute("messageechec", "Cette voiture a déjà été louée et ne peut pas supprimer");
        }

        //status="disponible"
               else {
                voitureService.deleteByidVoiture(idVoiture);
                re.addFlashAttribute("message", "Cette voiture a supprime avec succès");
                }


        return "redirect:/voitures";

    }
}
