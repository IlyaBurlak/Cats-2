package org.example.service;

import org.example.CatRepository;
import org.example.dto.CatDto;
import org.example.entity.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatService {

    private final CatRepository catRepository;

    @Autowired
    public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    public List<Cat> getAllCats() {
        return catRepository.findAll();
    }

    public CatDto getCatById(Long catId) {
        Cat cat = catRepository.findById(catId).orElse(null);
        if (cat != null) {
            CatDto catDto = new CatDto();
            catDto.setCatID(cat.getCatID());
            catDto.setName(cat.getName());
            catDto.setBirthDate(cat.getBirthDate());
            catDto.setBreed(cat.getBreed());
            catDto.setColor(cat.getColor());
            catDto.setOwnerId(cat.getOwnerId());
            return catDto;
        }
        return null;
    }

    public List<Cat> getCatsByColor(String color) {
        return catRepository.findByColor(color);
    }
}