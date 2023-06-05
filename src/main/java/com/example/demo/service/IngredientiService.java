package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.intefaccia.IngredientiRepo;
import com.example.demo.pojo.Ingredienti;



@Service
public class IngredientiService {

	@Autowired
	private IngredientiRepo ingredientiRepo;
	
	public List<Ingredienti> findAll() {
		
		return ingredientiRepo.findAll();
	}
	public Optional<Ingredienti> findById(int id) {
		
		return ingredientiRepo.findById(id);
	}
	public Ingredienti save(Ingredienti Ingredienti) {
		
		return ingredientiRepo.save(Ingredienti);
	}
	
	public void deleteIngredienti(Ingredienti Ingredienti){
		
		ingredientiRepo.delete(Ingredienti);
		
	}
	
	
	
}
