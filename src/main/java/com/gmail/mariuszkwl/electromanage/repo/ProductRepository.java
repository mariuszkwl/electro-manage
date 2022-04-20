package com.gmail.mariuszkwl.electromanage.repo;

import com.gmail.mariuszkwl.electromanage.domain.Client;
import com.gmail.mariuszkwl.electromanage.domain.Product;
import com.gmail.mariuszkwl.electromanage.domain.Voivodeship;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    Product findByClientAndCountryAndVoivodeshipAndTownAndZipCodeAndStreetAndBuildingNumberAndApartmentNumberAndAmountAndNote(
            Client client, String country, Voivodeship voivodeship, String town, String zipCode, String street,
            Integer buildingNumber, Integer apartmentNumber, Integer amount, String note
            );
}
