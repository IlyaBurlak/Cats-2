package org.example.service;

import org.example.CatRepository;
import org.example.dto.CatDto;
import org.example.entity.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CatService {

    private final CatRepository catRepository;

    @Autowired
    public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    private CatDto convertToCatDto(Cat cat) {
        CatDto catDto = new CatDto();
        catDto.setCatID(cat.getCatID());
        catDto.setName(cat.getName());
        catDto.setBirthDate(cat.getBirthDate());
        catDto.setBreed(cat.getBreed());
        catDto.setColor(cat.getColor());
        catDto.setOwnerId(cat.getOwnerId());
        return catDto;
    }

    private List<CatDto> convertToCatDtoList(List<Cat> cats) {
        return cats.stream()
                .map(this::convertToCatDto)
                .collect(Collectors.toList());
    }

    public List<CatDto> getAllCats() {
        List<Cat> cats = catRepository.findAll();
        return convertToCatDtoList(cats);
    }

    public CatDto getCatById(Long catId) {
        Cat cat = catRepository.findById(catId).orElse(null);
        if (cat != null) {
            return convertToCatDto(cat);
        }
        return null;
    }

    public List<CatDto> getCatsByColor(String color) {
        List<Cat> cats = catRepository.findByColor(color);
        return convertToCatDtoList(cats);
    }
}