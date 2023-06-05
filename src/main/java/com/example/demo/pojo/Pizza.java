package com.example.demo.pojo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToMany(mappedBy = "pizza")
	private List<OffertaSpeciale> offertaSpeciales;
	
	@NotBlank(message = "il nome non puo essere vuoto")
	@Size(min = 3,message = "almeno 3 caratteri")
	private String nome;
	
	@NotBlank(message = "il messaggio non puo essere vuoto")
	@Size(min = 3,message = "almeno 3 caratteri")
	@Column(columnDefinition = "TEXT")
	private String descrizione;
	
	@NotBlank(message = "la foto non puo essere vuoto")
	@Column(columnDefinition = "TEXT")
	private String fotoUrl;
	
	@Min(value = 1,message = "il prezzo non puo essere minore di 1")
	@NotNull(message = "il prezzo non puo essere vuoto")
	private float prezzo;
	
	@ManyToMany
	private List<Ingredienti> ingredienti;
	
	public Pizza() {}

	public Pizza(String nome, String descrizione, String fotoUrl, float prezzo) {
		this.nome = nome;
		this.descrizione = descrizione;
		this.fotoUrl = fotoUrl;
		this.prezzo = prezzo;
	}

	public int getId() {
		return id;
	}

	public List<Ingredienti> getIngredienti() {
		return ingredienti;
	}

	public void setIngredienti(List<Ingredienti> ingredienti) {
		this.ingredienti = ingredienti;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getFotoUrl() {
		return fotoUrl;
	}

	public void setFotoUrl(String fotoUrl) {
		this.fotoUrl = fotoUrl;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	
	
	public List<OffertaSpeciale> getOffertaSpeciales() {
		return offertaSpeciales;
	}

	public void setOffertaSpeciales(List<OffertaSpeciale> offertaSpeciales) {
		this.offertaSpeciales = offertaSpeciales;
	}

	@Override
	public String toString() {
		return "Pizza [id=" + id + ", nome=" + nome + ", descrizione=" + descrizione + ", fotoUrl=" + fotoUrl
				+ ", prezzo=" + prezzo + "]";
	}
	
	
	
	
	
}
