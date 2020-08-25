package com.example.naucna.model;

import java.util.ArrayList;

public class RecenzentUnit {
	private String username;
	private Float duzina;
	private Float sirina;
	private ArrayList<Float> lokacija = new ArrayList<>();
	
	public RecenzentUnit(String username, ArrayList<Float> lokacija) {
		super();
		this.username = username;
		this.lokacija = lokacija;
	}
	
	public RecenzentUnit(String username, Float duzina,Float sirina) {
		super();
		this.username = username;
		this.lokacija.add(duzina);
		this.lokacija.add(sirina);
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public ArrayList<Float> getLokacija() {
		return lokacija;
	}
	public void setLokacija(ArrayList<Float> lokacija) {
		this.lokacija = lokacija;
	}
	public Float getDuzina() {
		return duzina;
	}
	public void setDuzina(Float duzina) {
		this.duzina = duzina;
	}
	public Float getSirina() {
		return sirina;
	}
	public void setSirina(Float sirina) {
		this.sirina = sirina;
	}
	
	
	
}
