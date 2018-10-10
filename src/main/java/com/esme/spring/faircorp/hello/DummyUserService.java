package com.esme.spring.faircorp.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service

public class DummyUserService implements UserService {

    @Autowired
    GreetingService gs;

    @Override
    public void greetAll() {
        List<String> users = Arrays.asList("Elodie", "Charles");
        users.forEach(name -> gs.greet(name));

    }

}
