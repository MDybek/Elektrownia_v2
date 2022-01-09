package com.company.Elektrownie;

import com.company.AtakTerro.BrakReakcjiNaAtak;
import com.company.AtakTerro.ReakcjeNaAtakTerrorystyczny;
import com.company.AtakTerro.Sposob1ReakcjaNaAtakTerrorystyczny;
import com.company.AtakTerro.Sposob2ReakcjaNaAtakTerrorystyczny;
import com.company.Awarie.BrakReakcjiNaAwarie;
import com.company.Awarie.ReakcjaNaAwarieZasilania;
import com.company.Awarie.Sposob1ReakcjaNaAwarieZasilania;
import com.company.Awarie.Sposob2ReakcjaNaAwarieZasilania;
import com.company.Head.Gracz;
import com.company.Head.Pracownicy;
import com.company.Head.Wlasciciel;
import com.company.uslugodawcy.DystrybutorPradu;
import com.company.Dochod.ObliczDochodElektrowni;

import java.io.Serializable;
import java.util.Arrays;

public abstract class Elektrownia implements Serializable, ObliczDochodElektrowni, ReakcjeNaAtakTerrorystyczny,ReakcjaNaAwarieZasilania{

	private static final long serialVersionUID = 1234770990255762290L;

	private String nazwa;
	private String miasto;
	private int MocChwilowa;
	private int MocMaksymalna;
	private int liczbaBlokow;
	private int LiczbaPracownikow;
	private Wlasciciel wlasciciel;
	private boolean czyPracuje;
	private Pracownicy pracownicy[];
	private DystrybutorPradu Dystrybutor;
	private int kiedyDokupic;
	private int cenaZakupu;
	private int cenaSprzedazy;
	private int cenaBloku;


	protected ReakcjaNaAwarieZasilania reakcjaNaAwarieZasilania;
	protected ReakcjeNaAtakTerrorystyczny reakcjeNaAtakTerrorystyczny;
	protected ObliczDochodElektrowni obliczDochodElektrowni;

	public Elektrownia()
	{
		nazwa = " ";
		miasto = "";
		MocChwilowa = 0;
		MocMaksymalna = 0;
		LiczbaPracownikow = 0;
		czyPracuje = false;
		wlasciciel = new Wlasciciel();
		Dystrybutor = new DystrybutorPradu();
		cenaZakupu = 0;
		cenaSprzedazy = 0;
		cenaBloku = 0;
	}
	
	public Elektrownia(String nazwa, String miasto, int MocChwilowa, int MocMaksymalna, int liczbaBlokow, int LiczbaPracownikow, boolean czyPracuje, Wlasciciel wlasciciel, DystrybutorPradu Dystrybutor, int cenaZakupu, int cenaSprzedazy, int cenaBloku,int kiedyDokupic)
	{
		this.nazwa = nazwa;
		this.miasto = miasto;
		this.MocChwilowa = MocChwilowa;
		this.MocMaksymalna = MocMaksymalna;
		this.liczbaBlokow = liczbaBlokow;
		this.LiczbaPracownikow = LiczbaPracownikow;
		this.wlasciciel = wlasciciel;
		this.czyPracuje = czyPracuje;
		this.pracownicy = new Pracownicy[getLiczbaPracownikow()];
		this.Dystrybutor = Dystrybutor;
		this.kiedyDokupic = kiedyDokupic;
		this.cenaZakupu = cenaZakupu;
		this.cenaSprzedazy = cenaSprzedazy;
		this.cenaBloku = cenaBloku;
		reakcjaNaAwarieZasilania = new BrakReakcjiNaAwarie();
		reakcjeNaAtakTerrorystyczny = new BrakReakcjiNaAtak();

		for(int i = 0; i<pracownicy.length;i++){
			pracownicy[i] = new Pracownicy();
		}
	}

	public int getLiczbaBlokow() { return liczbaBlokow; }

	public void setLiczbaBlokow(int liczbaBlokow) { this.liczbaBlokow = liczbaBlokow; }

	public Wlasciciel getWlasciciel(){
		return wlasciciel;
	}

	public void setWlasciciel(Wlasciciel wlasciciel) {
		this.wlasciciel = wlasciciel;
	}

	public String getMiasto() {
		return miasto;
	}

	public void setMiasto(String miasto) {
		this.miasto = miasto;
	}

	public int getMocChwilowa() {
		return MocChwilowa;
	}

	public void setMocChwilowa(int mocChwilowa) {
		MocChwilowa = mocChwilowa;
	}

	public int getMocMaksymalna() {
		return MocMaksymalna;
	}

	public void setMocMaksymalna(int mocMaksymalna) {
		MocMaksymalna = mocMaksymalna;
	}

	public int getLiczbaPracownikow() {
		return LiczbaPracownikow;
	}

	public void setLiczbaPracownikow(int liczbaPracownikow) {
		LiczbaPracownikow = liczbaPracownikow;
	}

	public boolean isCzyPracuje() {
		return czyPracuje;
	}

	public void setCzyPracuje(boolean czyPracuje) {
		this.czyPracuje = czyPracuje;
	}

	public Pracownicy[] getPracownicy() {
		return pracownicy;
	}

	public void setPracownicy(Pracownicy[] pracownicy) {
		this.pracownicy = pracownicy;
	}

	public DystrybutorPradu getDystrybutor() {
		return Dystrybutor;
	}

	public void setDystrybutor(DystrybutorPradu dystrybutor) {
		Dystrybutor = dystrybutor;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public int getCenaZakupu() { return cenaZakupu; }

	public void setCenaZakupu(int cenaZakupu) { this.cenaZakupu = cenaZakupu; }

	public int getCenaSprzedazy() { return cenaSprzedazy; }

	public void setCenaSprzedazy(int cenaSprzedazy) { this.cenaSprzedazy = cenaSprzedazy; }

	public int getCenaBloku() { return cenaBloku; }

	public void setCenaBloku(int cenaBloku) { this.cenaBloku = cenaBloku; }

	public int getKiedyDokupic() {
		return kiedyDokupic;
	}

	public void setKiedyDokupic(int kiedyDokupic) {
		this.kiedyDokupic = kiedyDokupic;
	}
	public float uzupelnij(){
		return 0;
	}

	public ReakcjaNaAwarieZasilania getReakcjaNaAwarieZasilania() {
		return reakcjaNaAwarieZasilania;
	}

	public void setReakcjaNaAwarieZasilania(ReakcjaNaAwarieZasilania reakcjaNaAwarieZasilania) {
		this.reakcjaNaAwarieZasilania = reakcjaNaAwarieZasilania;
	}

	public ReakcjeNaAtakTerrorystyczny getReakcjeNaAtakTerrorystyczny() {
		return reakcjeNaAtakTerrorystyczny;
	}

	public void setReakcjeNaAtakTerrorystyczny(ReakcjeNaAtakTerrorystyczny reakcjeNaAtakTerrorystyczny) {
		this.reakcjeNaAtakTerrorystyczny = reakcjeNaAtakTerrorystyczny;
	}

	public ObliczDochodElektrowni getObliczDochodElektrowni() {
		return obliczDochodElektrowni;
	}
	public void ReakcjaNaAtakTerrorystyczny(Elektrownia e, Gracz g){
		reakcjeNaAtakTerrorystyczny.ReakcjaNaAtakTerrorystyczny(e, g);
	}

	public void ReakcjeNaAwarieZasilania(Elektrownia e){
		reakcjaNaAwarieZasilania.ReakcjeNaAwarieZasilania(e);
	}

	public void setObliczDochodElektrowni(ObliczDochodElektrowni obliczDochodElektrowni) {
		this.obliczDochodElektrowni = obliczDochodElektrowni;
	}

	public String toString()
	{
		 return "\nNazwa: " + nazwa +"\nMiasto: " + miasto + "\nmoc chwilowa: " + MocChwilowa + "\nmoc maksymalna: " + MocMaksymalna + "\nliczba pracownikow: " + LiczbaPracownikow + "\nczy pracuje: " + czyPracuje + " \nwlasciciel elektrowni:\t\t" + wlasciciel  + "\npracownicy: " + Arrays.toString(pracownicy) + "\nDystrybutor: " + Dystrybutor.toString();
	}

	public String  typ(){
		return "elektrownia";
	}


}
