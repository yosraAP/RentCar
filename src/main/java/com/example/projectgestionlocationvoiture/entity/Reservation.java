package com.example.projectgestionlocationvoiture.entity;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idReservation")
    private Integer idReservation;
    private Date dateReservation;
    private Date dateCirculation;
    private Date dateRetour;

    @ManyToOne  //   @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idClient_FK",nullable = false)
    private Client idClient;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idVoiture_FK",nullable = false)
    private Voiture idVoiture;

    public Reservation() {
    }

    public Reservation(Integer idReservation, Date dateReservation, Date dateCirculation, Date dateRetour, Client idClient, Voiture idVoiture) {
        this.idReservation = idReservation;
        this.dateReservation = dateReservation;
        this.dateCirculation = dateCirculation;
        this.dateRetour = dateRetour;
        this.idClient = idClient;
        this.idVoiture = idVoiture;
    }



    public Reservation(Date dateReservation, Date dateCirculation, Date dateRetour, Client idClient, Voiture idVoiture) {
        this.dateReservation = dateReservation;
        this.dateCirculation = dateCirculation;
        this.dateRetour = dateRetour;
        this.idClient = idClient;
        this.idVoiture = idVoiture;
    }

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public Date getDateCirculation() {
        return dateCirculation;
    }

    public void setDateCirculation(Date dateCirculation) {
        this.dateCirculation = dateCirculation;
    }

    public Date getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }

    public Client getidClient() {
        return idClient;
    }

    public void setidclient(Client idClient) {
        this.idClient = idClient;
    }

    public Voiture getIdVoiture() {
        return idVoiture;
    }

    public void setIdVoiture(Voiture idVoiture) {
        this.idVoiture = idVoiture;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "idReservation=" + idReservation +
                ", dateReservation=" + dateReservation +
                ", dateCirculation=" + dateCirculation +
                ", dateRetour=" + dateRetour +
                ", idClient=" + idClient +
                ", idVoiture=" + idVoiture +
                '}';
    }
}
