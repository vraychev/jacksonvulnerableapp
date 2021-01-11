package org.some.company.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import org.some.company.model.Org;
import org.some.company.model.User;

import java.io.IOException;

@Controller
public class AppController {

    @Get
    @Produces(MediaType.TEXT_PLAIN)
    public String index() {
        return "Hello Michael!";
    }

    // Vulnerable because User class uses JsonTypeInfo annotation and has field of type Object
    @Post(value = "/user", consumes = MediaType.APPLICATION_JSON)
    public void addUser(@Body String payload) throws IOException {
        System.out.println("Received add user request with payload: " + payload);

        ObjectMapper om = new ObjectMapper();
        User newUser = om.readValue(payload, User.class);

        System.out.println("Added new user with name:" + newUser.name +
                " and email " + newUser.email);
    }

    // Vulnerable because Org class has field of type Object and is deserialized with
    // ObjectMapper with enabled polymorphic type handling (enableDefaultTyping)
    @Post(value = "/org", consumes = MediaType.APPLICATION_JSON)
    public void addOrganization(@Body String payload) throws IOException {
        System.out.println("Received add organization request with payload: " + payload);

        ObjectMapper om = new ObjectMapper();
        om.enableDefaultTyping();

        Org newOrg = om.readValue(payload, Org.class);

        System.out.println("Added new org with name:" + newOrg.name +
                " and id " + newOrg.id);
    }
}