package com.gmail.mariuszkwl.electromanage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.RepresentationModel;

public class ClientProduct extends RepresentationModel<ClientProduct> {

    private final String firstName;
    private final String lastName;
    private final String country;
    private final String voivodeship;
    private final String town;
    private final String zipCode;
    private final String street;
    private final Integer buildingNumber;
    private final Integer apartmentNumber;
    private final Integer amount;
    private final String note;

    @JsonCreator
    public ClientProduct(
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("country") String country,
            @JsonProperty("voivodeship") String voivodeship,
            @JsonProperty("town") String town,
            @JsonProperty("zipCode") String zipCode,
            @JsonProperty("street") String street,
            @JsonProperty("buildingNumber") Integer buildingNumber,
            @JsonProperty("apartmentNumber") Integer apartmentNumber,
            @JsonProperty("amount") Integer amount,
            @JsonProperty("note") String note
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCountry() {
        return country;
    }

    public String getVoivodeship() {
        return voivodeship;
    }

    public String getTown() {
        return town;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getStreet() {
        return street;
    }

    public Integer getBuildingNumber() {
        return buildingNumber;
    }

    public Integer getApartmentNumber() {
        return apartmentNumber;
    }

    public Integer getAmount() {
        return amount;
    }

    public String getNote() {
        return note;
    }
}
