package org.example;

import org.example.entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CatRepository extends JpaRepository<Cat, Long> {
    List<Cat> findAll();

    Optional<Cat> findById(Long catId);

    List<Cat> findByColor(String color);
}