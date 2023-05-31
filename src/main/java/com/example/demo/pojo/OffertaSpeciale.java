package com.example.demo.pojo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class OffertaSpeciale {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Pizza pizza;
	
	@NotNull(message = "la data di inizio non puo essere vuoto")
	private LocalDate dataDiInizio;
	
	@NotNull(message = "la data di fine non puo essere vuoto")
	private LocalDate dataDiFine;
	
	@NotBlank(message = "il titolo non puo essere vuoto")
	@Size(min = 3,message = "minimo 3 caratteti")
	private String titolo;
	
	@NotNull(message = "lo sconto non puo essere vuoto")
	@Min(value = 5, message = "lo sconto non puo essere inferiore al 5%")
	@Max(value = 50, message = "lo sconto non puo essere superiore al 50%")
	private int percSconto;


	public OffertaSpeciale() {}


	
	
	
	public OffertaSpeciale(LocalDate dataDiInizio,
			LocalDate dataDiFine,
			String titolo,
			 int percSconto,
			 Pizza pizza) {
		
		this.dataDiInizio = dataDiInizio;
		this.dataDiFine = dataDiFine;
		this.titolo = titolo;
		this.percSconto = percSconto;
		this.pizza = pizza;
	}





	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDataDiInizio() {
		return dataDiInizio;
	}

	public void setDataDiInizio(LocalDate dataDiInizio) {
		this.dataDiInizio = dataDiInizio;
	}

	public LocalDate getDataDiFine() {
		return dataDiFine;
	}

	public void setDataDiFine(LocalDate dataDiFine) {
		this.dataDiFine = dataDiFine;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getPercSconto() {
		return percSconto;
	}

	public void setPercSconto(int percSconto) {
		this.percSconto = percSconto;
	}


	


	public Pizza getPizza() {
		return pizza;
	}





	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}





	@Override
	public String toString() {
		return "OffertaSpeciale [id=" + id + ", pizza=" + pizza + ", dataDiInizio=" + dataDiInizio + ", dataDiFine="
				+ dataDiFine + ", titolo=" + titolo + ", percSconto=" + percSconto + "]";
	}






	
	
	
	
	
	
}
