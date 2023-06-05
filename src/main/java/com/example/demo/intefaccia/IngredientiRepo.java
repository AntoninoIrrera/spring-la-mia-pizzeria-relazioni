package com.example.demo.intefaccia;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojo.Ingredienti;

public interface IngredientiRepo extends JpaRepository<Ingredienti, Integer> {

}
