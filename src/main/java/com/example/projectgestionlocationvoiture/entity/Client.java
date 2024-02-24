package com.example.projectgestionlocationvoiture.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idClient")
    private Integer idClient;
    private String nom;
    private String prenom;
    private String email;

    /*orphanRemoval = true//si on supprime le Client => on supprime les
     Voitures qui sont liés dans la bd*/
    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "idVoiture_FK",nullable = false)
    private Voiture idVoiture;


    /*
   la valeur de mappedBy est le nom de l'attribut
    de mappage d'association du côté propriétaire*/
    @OneToMany(mappedBy="idClient",cascade = CascadeType.ALL) //@OneToMany(mappedBy = "client", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    public Client() {
    }


    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Voiture getIdVoiture() {
        return idVoiture;
    }

    public void setIdVoiture(Voiture idVoiture) {
        this.idVoiture = idVoiture;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Client(Integer idClient, String nom, String prenom, String email, Voiture idVoiture, List<Reservation> reservations) {
        this.idClient = idClient;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.idVoiture = idVoiture;
        this.reservations = reservations;
    }

    public Client(String nom, String prenom, String email, Voiture idVoiture, List<Reservation> reservations) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.idVoiture = idVoiture;
        this.reservations = reservations;
    }

    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", idVoiture=" + idVoiture +
                ", reservations=" + reservations +
                '}';
    }
}
