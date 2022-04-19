package com.gmail.mariuszkwl.electromanage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/electro-manage")
public class ClientProductController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping("/add")
    public HttpEntity<ClientProduct> add(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("country") String country,
            @RequestParam("voivodeship") String voivodeship,
            @RequestParam("town") String town,
            @RequestParam("zipCode") String zipCode,
            @RequestParam("street") String street,
            @RequestParam("buildingNumber") Integer buildingNumber,
            @RequestParam("apartmentNumber") Integer apartmentNumber,
            @RequestParam("amount") Integer amount,
            @RequestParam("note") String note
    ) {
        clientRepository.save(new Client(firstName, lastName));
        productRepository.save(new Product(
                clientRepository.findByFirstNameAndLastName(firstName, lastName),
                country, Voivodeship.findByLabel(voivodeship), town, zipCode, street, buildingNumber,
                apartmentNumber, amount, note
        ));
        return new HttpEntity<>(new ClientProduct(
                firstName, lastName, country, voivodeship, town, zipCode,
                street, buildingNumber, apartmentNumber, amount, note
                ));
    }
}
