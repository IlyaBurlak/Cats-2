package org.example.controller;

import org.example.dto.CatDto;
import org.example.entity.User;
import org.example.security.UsersDetails;
import org.example.service.CatService;
import org.example.service.UsersDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    private final CatService catService;

    @Autowired
    public Controller(CatService catService) {
        this.catService = catService;
    }

    @GetMapping("/cat/{catId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public CatDto getCatById(@PathVariable Long catId) {
        return catService.getCatById(catId);
    }

    @GetMapping("/cats")
    @PreAuthorize("hasRole('ADMIN')")
    public List<CatDto> getAllCats() {
        return catService.getAllCats();
    }

    @GetMapping("/cats/color/{color}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<CatDto> getCatsByColor(@PathVariable String color) {
        return catService.getCatsByColor(color);
    }

    @PostMapping("/new-user")
    public String addUser(@RequestBody User user){
        UsersDetailsService.addUser(user);
        return "User is saves";
    }
}