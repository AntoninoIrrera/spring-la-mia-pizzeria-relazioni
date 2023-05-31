package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.intefaccia.OffertaSpecialeRepo;
import com.example.demo.pojo.OffertaSpeciale;

@Service
public class OffertaSpecialeService {
	
	
	@Autowired
	private OffertaSpecialeRepo offertaSpecialeRepo;
	
	public List<OffertaSpeciale> findAll() {
		
		return offertaSpecialeRepo.findAll();
	}
	public Optional<OffertaSpeciale> findById(int id) {
		
		return offertaSpecialeRepo.findById(id);
	}
	public OffertaSpeciale save(OffertaSpeciale offertaSpeciale) {
		
		return offertaSpecialeRepo.save(offertaSpeciale);
	}
	
}
