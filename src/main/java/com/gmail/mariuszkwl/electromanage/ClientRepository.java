package com.gmail.mariuszkwl.electromanage;

import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Integer> {

    Client findByFirstNameAndLastName(String firstName, String lastName);
}
