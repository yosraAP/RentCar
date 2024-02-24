package com.example.projectgestionlocationvoiture.entity;

import javax.persistence.*;

@Entity
@Table(name = "voiture")
public class Voiture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idVoiture")
    private Integer idVoiture;
    private Integer year;
    private Integer mileage;
    private String status; //loue  et disponible
    private String model;
    private String picture;
    private String license;
    private float price;

    public Voiture() {
    }

    public Voiture(Integer idVoiture, Integer year, Integer mileage, String status, String model, String picture, String license, float price) {
        this.idVoiture = idVoiture;
        this.year = year;
        this.mileage = mileage;
        this.status = status;
        this.model = model;
        this.picture = picture;
        this.license = license;
        this.price = price;
    }

    public Voiture(Integer year, Integer mileage, String status, String model, String picture, String license, float price) {
        this.year = year;
        this.mileage = mileage;
        this.status = status;
        this.model = model;
        this.picture = picture;
        this.license = license;
        this.price = price;
    }

    public Voiture(Integer idVoiture, Integer year, Integer mileage, String status, String model, String license, float price) {
        this.idVoiture = idVoiture;
        this.year = year;
        this.mileage = mileage;
        this.status = status;
        this.model = model;
        this.license = license;
        this.price = price;
    }

    public Integer getIdVoiture() {
        return idVoiture;
    }

    public void setIdVoiture(Integer idVoiture) {
        this.idVoiture = idVoiture;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Voiture{" +
                "idVoiture=" + idVoiture +
                ", year=" + year +
                ", mileage=" + mileage +
                ", status='" + status + '\'' +
                ", model='" + model + '\'' +
                ", picture='" + picture + '\'' +
                ", license='" + license + '\'' +
                ", price=" + price +
                '}';
    }
}
