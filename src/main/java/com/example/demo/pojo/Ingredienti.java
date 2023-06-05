package com.example.demo.pojo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Ingredienti {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "il nome non puo essere vuoto")
	@Size(min = 3,message = "minimo 3 caratteti")
	private String nome;

	@ManyToMany(mappedBy = "ingredienti")
	private List<Pizza> pizze;
	
	public List<Pizza> getPizze() {
		return pizze;
	}

	public void setPizze(List<Pizza> pizze) {
		this.pizze = pizze;
	}

	public Ingredienti() {}
	
	public Ingredienti(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Ingredienti [nome=" + nome + "]";
	}
	
	
	
	
	
}
