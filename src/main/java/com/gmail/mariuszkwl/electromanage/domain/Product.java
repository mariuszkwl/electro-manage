package com.gmail.mariuszkwl.electromanage.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @NotNull
    private Client client;

    @Column
    @NotNull
    private String country;

    @Column
    @Enumerated
    private Voivodeship voivodeship;

    @Column
    @NotNull
    private String town;

    @Column
    @NotNull
    private String zipCode;

    @Column
    private String street;

    @Column
    @NotNull
    private Integer buildingNumber;

    @Column
    private Integer apartmentNumber;

    @Column
    @NotNull
    private Integer amount;

    @Column
    private String note;

    protected Product() {}

    public Product(
            Client client, String country, Voivodeship voivodeship, String town, String zipCode, String street,
            Integer buildingNumber, Integer apartmentNumber, Integer amount, String note
    ) {
        this.client = client;
        this.country = country;
        this.voivodeship = voivodeship;
        this.town = town;
        this.zipCode = zipCode;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.apartmentNumber = apartmentNumber;
        this.amount = amount;
        this.note = note;
    }

    public Integer getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Voivodeship getVoivodeship() {
        return voivodeship;
    }

    public void setVoivodeship(Voivodeship voivodeship) {
        this.voivodeship = voivodeship;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(Integer buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public Integer getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(Integer apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
