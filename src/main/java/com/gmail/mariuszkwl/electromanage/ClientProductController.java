package com.gmail.mariuszkwl.electromanage;

import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController("/electro-manage")
public class ClientProductController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProductRepository productRepository;


    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(
            ClientProduct clientProduct
    ) {
        Client client = createClient(clientProduct.getClient());
        if (client != null) {
            Product product = createProduct(client, clientProduct.getAddress(),
                    clientProduct.getAmount(), clientProduct.getNote());
        }

    }

    private Client createClient(String clientInfo) {
        Client client;
        List<String> info = new ArrayList<>(2);
        info.addAll(Arrays.asList(clientInfo.split(", ")));
        if (info.get(0) != null && info.get(1) != null) {
            client = clientRepository.findByFirstNameAndLastName(info.get(0), info.get(1));
            if (client == null) {
                client = clientRepository.save(new Client(info.get(0), info.get(1)));
            }
            return client;
        }
        return null;
    }

    private Product createProduct(Client client, String address, Integer amount, String  note) {
        Product product;
        List<String> info = new ArrayList<>(7);
        info.addAll(Arrays.asList(address.split(", ")));
        product = productRepository.findByClientAndCountryAndVoivodeshipAndTownAndZipCodeAndStreetAndBuildingNumberAndApartmentNumberAndAmountAndNote(
                client, info.get(0), Voivodeship.findByLabel(info.get(1)), info.get(2), info.get(3), info.get(4),
                        Integer.parseInt(info.get(5)), Integer.parseInt(info.get(6)), amount, note
        );
        if (product == null) {
            product = productRepository.save(new Product(client, info.get(0), Voivodeship.findByLabel(info.get(1)),
                    info.get(2), info.get(3), info.get(4), Integer.parseInt(info.get(5)), Integer.parseInt(info.get(6)),
                    amount, note));
        }
        return product;
    }
}
