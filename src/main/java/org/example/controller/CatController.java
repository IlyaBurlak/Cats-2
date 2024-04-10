package org.example.controller;

import org.example.dto.CatDto;
import org.example.entity.Cat;
import org.example.service.CatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CatController {


    private final CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }


    @GetMapping("/cats/{catId}")
    public CatDto getCatById(@PathVariable Long catId) {
        return catService.getCatById(catId);
    }

    @GetMapping("/cats")
    public List<Cat> getAllCats() {
        return catService.getAllCats();
    }


    @GetMapping("/cats/{color}")
    public List<Cat> getCatsByColor(@PathVariable String color) {
        return catService.getCatsByColor(color);
    }


}
