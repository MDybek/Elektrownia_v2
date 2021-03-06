package com.company.Elektrownie;


import com.company.AtakTerro.Sposob1ReakcjaNaAtakTerrorystyczny;
import com.company.Awarie.Sposob1ReakcjaNaAwarieZasilania;
import com.company.Dochod.DochodFotowoltaiczna;
import com.company.Head.Wlasciciel;
import com.company.uslugodawcy.DystrybutorPradu;

public class ElektrowniaFotowoltaiczna extends Elektrownia {


	private float ZuzyciePaneli;

	public ElektrowniaFotowoltaiczna() {
		super();
		ZuzyciePaneli = 10;
	}

	public ElektrowniaFotowoltaiczna(String Nazwa, String Miasto, int MocChwilowa, int MocMaksymalna, int liczbaBlokow, int LiczbaPracownikow, Wlasciciel wlasciciel,
			boolean czyPracuje, float ZuzyciePaneli, DystrybutorPradu Dystrybutor, int cenaZakupu, int cenaSprzedazy, int cenaBloku,int kiedyDokupic)
	{
		super(Nazwa, Miasto, MocChwilowa, MocMaksymalna, liczbaBlokow, LiczbaPracownikow, czyPracuje, wlasciciel, Dystrybutor, cenaZakupu, cenaSprzedazy, cenaBloku, kiedyDokupic,0,0);
		
		this.ZuzyciePaneli = ZuzyciePaneli;

		obliczDochodElektrowni = new DochodFotowoltaiczna();
	}

	
	//Metody typu get i metody typu set
	public float getZuzyciePaneli()
	{
		return ZuzyciePaneli;
	}

	public void setZuzyciePaneli(float zuzyciePaneli)
	{
		ZuzyciePaneli = zuzyciePaneli;
	}

	@Override
	public String toString() {
		return "ElektrowniaFotowoltaiczna: " + super.toString() +
				"\nZuzyciePaneli: " + ZuzyciePaneli + '\'';
	}
	public String  typ(){
		return "fotowoltaiczna";
	}

	@Override
	public float ObliczDochod(Elektrownia e) {
		return obliczDochodElektrowni.ObliczDochod(this);
	}
}
