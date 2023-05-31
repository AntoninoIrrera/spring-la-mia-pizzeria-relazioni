package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.pojo.OffertaSpeciale;
import com.example.demo.pojo.Pizza;
import com.example.demo.service.OffertaSpecialeService;
import com.example.demo.service.PizzaService;

import jakarta.validation.Valid;

@Controller
public class OffertaSpecialeController {

	
	@Autowired
	private OffertaSpecialeService offertaSpecialeService;
	
	@Autowired
	private PizzaService pizzaService;

	
	@GetMapping("/offerta/create")
	public String createOfferta(@RequestParam(name = "id") int idPizza, Model model) {
		
		OffertaSpeciale offertaSpeciale = new OffertaSpeciale();
		
		Optional<Pizza> pizzaOpt = pizzaService.findById(idPizza);
		Pizza pizza = pizzaOpt.get();
		
		offertaSpeciale.setPizza(pizza);
		
		
		model.addAttribute("offertaSpeciale", offertaSpeciale);
		
		return "createFormOfferta";
	}
	
	@PostMapping("/offerta/create")
	public String storeOfferta(@Valid @ModelAttribute OffertaSpeciale offertaSpeciale, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			
//			for(ObjectError err : bindingResult.getAllErrors()) {
//				System.out.println(err.getDefaultMessage());
//			}
			
			model.addAttribute("offertaSpeciale",offertaSpeciale);
			model.addAttribute("errori",bindingResult);
			
			return "createFormOfferta";
		}
		
		
		
	
	

		
		
	
		
		offertaSpecialeService.save(offertaSpeciale);
	
		
		
		return "redirect:/";
	}
	
	@GetMapping("/offerta/update/{id}")
	public String editOfferta(
			Model model,
			@PathVariable int id
		) {
		
		
		Optional<OffertaSpeciale> offertaOpt = offertaSpecialeService.findById(id);
		OffertaSpeciale offerta = offertaOpt.get();
		model.addAttribute("offertaSpeciale", offerta);
		
		return "updateFormOfferta";
	}
	@PostMapping("/offerta/update/{id}")
	public String updateOfferta(
			  @Valid
		      @ModelAttribute OffertaSpeciale offertaSpeciale,
		      BindingResult bindingResult,
		      Model model
			
			
		) {
		
		
		if(bindingResult.hasErrors()) {
			
			
			
			model.addAttribute("offertaSpeciale",offertaSpeciale);
			model.addAttribute("errori",bindingResult);
			
			return "updateFormOfferta";
		}
		
		
		
		
		offertaSpecialeService.save(offertaSpeciale);
		
		return "redirect:/";
	}

	
}
