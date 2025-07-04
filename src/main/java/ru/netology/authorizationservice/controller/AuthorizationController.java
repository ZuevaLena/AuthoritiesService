package ru.netology.authorizationservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.authorizationservice.model.Authorities;
import ru.netology.authorizationservice.service.AuthorizationService;

import java.util.List;

@RestController
public class AuthorizationController {

    private final AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public String getAuthorities(
            @RequestParam("user") String user,
            @RequestParam("password") String password) {

        List<Authorities> authorities = service.getAuthorities(user, password);
        System.err.println(authorities);


       return service.getAuthorities(user, password).toString();

    }
}
