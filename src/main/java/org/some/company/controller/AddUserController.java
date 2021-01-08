package org.some.company.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.some.company.model.User;
import org.springframework.web.bind.annotation.*;


@SuppressWarnings("unused")
@RestController
public class AddUserController {

    @PostMapping("/users")
    public void index(@RequestBody String pBody) throws Exception {
        ObjectMapper om = new ObjectMapper();
        om.enableDefaultTyping();

        User newUser = om.readValue(pBody, User.class);

        System.out.println("Added new user with name:" + newUser.name +
                " and email " + newUser.email);
    }
}
