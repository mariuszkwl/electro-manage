package com.gmail.mariuszkwl.electromanage.repo;

import com.gmail.mariuszkwl.electromanage.domain.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Integer> {

    Client findByFirstNameAndLastName(String firstName, String lastName);
}
