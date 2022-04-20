package com.gmail.mariuszkwl.electromanage.web;


import com.gmail.mariuszkwl.electromanage.domain.Client;
import com.gmail.mariuszkwl.electromanage.domain.Product;
import com.gmail.mariuszkwl.electromanage.domain.Voivodeship;
import com.gmail.mariuszkwl.electromanage.repo.ClientRepository;
import com.gmail.mariuszkwl.electromanage.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class ClientProductController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProductRepository productRepository;


    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public HttpEntity<ClientProductIds> add(ClientProduct clientProduct) {
        Product product = null;
        Client client = createClient(clientProduct.getClient());
        if (client != null) {
            product = createProduct(client, clientProduct.getAddress(),
                    clientProduct.getAmount(), clientProduct.getNote());
        }
        if (client != null){
            return new HttpEntity<>(new ClientProductIds(client.getId(), product.getId()));
        } else {
            return new HttpEntity<>(new ClientProductIds(-1, -1));
        }
    }

    @PutMapping(path = "/modify/client")
    @ResponseStatus(HttpStatus.OK)
    public void  modifyClient(Integer clientId, String clientInfo) {
        Client client = verifyClient(clientId);
        if (client != null) {
            List<String> info = new ArrayList<>(2);
            info.addAll(Arrays.asList(clientInfo.split(", ")));
            if (info.get(0) != null && info.get(1) != null) {
                client.setFirstName(info.get(0));
                client.setLastName(info.get(1));
                clientRepository.save(client);
            }
        }
    }

    @PutMapping(path = "/modify/product")
    @ResponseStatus(HttpStatus.OK)
    public void  modifyProduct(Integer productId, ClientProduct clientProduct) {
        Product product = verifyProduct(productId);
        if (product != null) {
            List<String> info = new ArrayList<>(7);
            info.addAll(Arrays.asList(clientProduct.getAddress().split(", ")));
            product.setCountry(info.get(0));
            product.setVoivodeship(Voivodeship.findByLabel(info.get(1)));
            product.setTown(info.get(2));
            product.setZipCode(info.get(3));
            product.setStreet(info.get(4));
            product.setBuildingNumber(Integer.parseInt(info.get(5)));
            product.setApartmentNumber(Integer.parseInt(info.get(6)));
            product.setAmount(clientProduct.getAmount());
            product.setNote(clientProduct.getNote());
            productRepository.save(product);
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

    private Client verifyClient(Integer clientId) {
        Client client = null;
        if (clientRepository.findById(clientId).isPresent()) {
            client = clientRepository.findById(clientId).get();
        }
        return client;
    }

    private Product verifyProduct(Integer productId) {
        Product product = null;
        if (productRepository.findById(productId).isPresent()) {
            product = productRepository.findById(productId).get();
        }
        return product;
    }
}
