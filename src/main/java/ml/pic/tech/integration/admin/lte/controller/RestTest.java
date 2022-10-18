package ml.pic.tech.integration.admin.lte.controller;

import ml.pic.tech.integration.admin.lte.entity.Utilisateur;
import ml.pic.tech.integration.admin.lte.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class
RestTest {
    private AccountService service;

    public RestTest(AccountService service) {
        this.service = service;
    }

    @GetMapping(value = "/users", produces = "application/json")
    public List<Utilisateur> utilisateurs() {
        return service.allUsers();
    }
}
