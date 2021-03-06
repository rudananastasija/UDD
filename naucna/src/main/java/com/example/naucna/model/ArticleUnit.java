package com.example.naucna.model;

public class ArticleUnit {
	private long id;
	private String magazin;
	private String sadrzaj;
	private String naslov;
	private String koautori;
	private String kljucneRijeci;
	private String naucnaOblast;
	private String openAccess;
	public ArticleUnit() {
		super();
	}
	public ArticleUnit(String magazin, String sadrzaj, String naslov, String koautori, String kljucneRijeci,
			String naucnaOblast) {
		super();
		this.magazin = magazin;
		this.sadrzaj = sadrzaj;
		this.naslov = naslov;
		this.koautori = koautori;
		this.kljucneRijeci = kljucneRijeci;
		this.naucnaOblast = naucnaOblast;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMagazin() {
		return magazin;
	}
	public void setMagazin(String magazin) {
		this.magazin = magazin;
	}
	public String getSadrzaj() {
		return sadrzaj;
	}
	public void setSadrzaj(String sadrzaj) {
		this.sadrzaj = sadrzaj;
	}
	public String getNaslov() {
		return naslov;
	}
	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}
	public String getKoautori() {
		return koautori;
	}
	public void setKoautori(String koautori) {
		this.koautori = koautori;
	}
	public String getKljucneRijeci() {
		return kljucneRijeci;
	}
	public void setKljucneRijeci(String kljucneRijeci) {
		this.kljucneRijeci = kljucneRijeci;
	}
	public String getNaucnaOblast() {
		return naucnaOblast;
	}
	public void setNaucnaOblast(String naucnaOblast) {
		this.naucnaOblast = naucnaOblast;
	}
	public String getOpenAccess() {
		return openAccess;
	}
	public void setOpenAccess(String openAccess) {
		this.openAccess = openAccess;
	}
	
	
}
