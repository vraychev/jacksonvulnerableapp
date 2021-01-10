package org.some.company.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import org.some.company.model.User;

import java.io.IOException;

@Controller
public class AppController {
    @Post(value = "/user", consumes = MediaType.APPLICATION_JSON)
    public void addUser(@Body String payload) throws IOException {
        System.out.println("Received add user request with payload: " + payload);

        ObjectMapper om = new ObjectMapper();
        om.enableDefaultTyping();

        User newUser = om.readValue(payload, User.class);

        System.out.println("Added new user with name:" + newUser.name +
                " and email " + newUser.email);

    }
}