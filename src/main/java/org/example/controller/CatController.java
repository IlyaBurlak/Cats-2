package org.example.controller;

import org.example.dto.CatDto;
import org.example.entity.Cat;
import org.example.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CatController {

    private final CatService catService;

    @Autowired
    public CatController(CatService catService) {
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
}