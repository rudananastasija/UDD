package com.example.naucna.model;

public class FieldDto {

	private String tipPretrage;
	private String tipUpita;
	private String tekst;
	private String operator;
	public String getTipPretrage() {
		return tipPretrage;
	}
	public void setTipPretrage(String tipPretrage) {
		this.tipPretrage = tipPretrage;
	}
	public String getTekst() {
		return tekst;
	}
	public void setTekst(String tekst) {
		this.tekst = tekst;
	}
	
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public FieldDto(String tipPretrage, String tekst, String operator) {
		super();
		this.tipPretrage = tipPretrage;
		this.tekst = tekst;
		this.operator = operator;
	}
	public FieldDto() {
		super();
	}
	public String getTipUpita() {
		return tipUpita;
	}
	public void setTipUpita(String tipUpita) {
		this.tipUpita = tipUpita;
	}
}
