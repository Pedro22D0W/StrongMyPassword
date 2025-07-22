package com.strongmypassword.strongmypassword.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StrongMyPasswordController {

    @GetMapping("/strongme")
    public String StrongMyPassword(@RequestBody String password){
        String receved_password = "senha recebida = " + password;
        return receved_password;
    }
}
