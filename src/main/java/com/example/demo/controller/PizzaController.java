package com.example.demo.controller;

import java.util.List;
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

import com.example.demo.pojo.Pizza;
import com.example.demo.service.PizzaService;

import jakarta.validation.Valid;

@Controller
public class PizzaController {

	
	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping("/")
	public String index(Model model) {
		
		List<Pizza> pizze = pizzaService.findAll();
		
		model.addAttribute("pizze", pizze);
		
		return "pizzaIndex";
	}
	
	@PostMapping("/pizza/filtro")
	public String indexFiltro(Model model,@RequestParam(required = false) String nome) {
		
		List<Pizza> pizze = pizzaService.findByNome(nome);
		
		model.addAttribute("pizze", pizze);
		model.addAttribute("nome",nome);
		
		return "pizzaIndex";
	}
	
	
	
	@GetMapping("/pizza/{id}")
	public String show(
			Model model,
			@PathVariable("id") int id
	) {
		
		Optional<Pizza> optPizza = pizzaService.findById(id);
		Pizza pizza = optPizza.get();
		
		Optional<Pizza> firstPizzaOpt = pizzaService.findByIdWithOffertaSpeciale(id);
		Pizza offertePizza = firstPizzaOpt.get();
		
	
		
		model.addAttribute("pizza", pizza);
		model.addAttribute("offerte",offertePizza.getOffertaSpeciales());
		
		return "pizzaShow";
	}
	
	
	@GetMapping("/pizza/create")
	public String createPizza(Model model) {
		
		model.addAttribute("pizza",new Pizza());
		
		return "createForm";
	}
	
	@PostMapping("/pizza/create")
	public String storePizza(@Valid @ModelAttribute Pizza pizza, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			
//			for(ObjectError err : bindingResult.getAllErrors()) {
//				System.out.println(err.getDefaultMessage());
//			}
			
			model.addAttribute("pizza",pizza);
			model.addAttribute("errori",bindingResult);
			
			return "createForm";
		}
		
		
		pizzaService.save(pizza);
		
		return "redirect:/";
	}
	
	
	@GetMapping("/pizza/delete/{id}")
	public String deletePizza(
			@PathVariable int id
		) {
		
		Optional<Pizza> pizzaOpt = pizzaService.findById(id);
		Pizza pizza = pizzaOpt.get();
		pizzaService.deletePizza(pizza);
		
		return "redirect:/";
	}
	

	@GetMapping("/pizza/update/{id}")
	public String editPizza(
			Model model,
			@PathVariable int id
		) {
		
		Optional<Pizza> pizzaOpt = pizzaService.findById(id);
		Pizza pizza = pizzaOpt.get();
		model.addAttribute("pizza", pizza);
		
		return "updateForm";
	}
	@PostMapping("/pizza/update/{id}")
	public String updatePizza(
			  @Valid
		      @ModelAttribute Pizza pizza,
		      BindingResult bindingResult,
		      @PathVariable int id,
		      Model model
			
			
		) {
		
		
		if(bindingResult.hasErrors()) {
			
			
			
			model.addAttribute("pizza",pizza);
			model.addAttribute("errori",bindingResult);
			
			return "updateForm";
		}
		
		
		
		pizzaService.save(pizza);
		
		return "redirect:/";
	}
	
}
