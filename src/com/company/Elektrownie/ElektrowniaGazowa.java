package com.company.Elektrownie;

import com.company.Dochod.DochodGazowa;
import com.company.Head.Wlasciciel;
import com.company.uslugodawcy.DostawcaGazu;
import com.company.uslugodawcy.DystrybutorPradu;

public class ElektrowniaGazowa extends ElektrowniaNaPaliwoStale  {


	private DostawcaGazu DostawcaGazu;

	public ElektrowniaGazowa() {
		super();
		DostawcaGazu = new DostawcaGazu();
	}

	public ElektrowniaGazowa(String Nazwa, String Miasto, int MocChwilowa, int MocMaksymalna, int liczbaBlokow, int LiczbaPracownikow,
							 Wlasciciel wlasciciel, boolean czyPracuje, String RodzajPaliwa, float ZuzyciePaliwa, int LiczbaBlokow,
							 DystrybutorPradu Dystrubutor, int stanMagazynu, DostawcaGazu DostawcaGazu,
							 int pojemnoscMagazynu, int cenaZakupu, int cenaSprzedazy, int cenaBloku,int kiedyDokupic) {
		super(Nazwa, Miasto, MocChwilowa, MocMaksymalna, liczbaBlokow, LiczbaPracownikow, wlasciciel, czyPracuje,
				RodzajPaliwa, ZuzyciePaliwa, LiczbaBlokow, Dystrubutor, cenaZakupu, cenaSprzedazy, cenaBloku,
				kiedyDokupic,stanMagazynu,pojemnoscMagazynu);

		this.DostawcaGazu = DostawcaGazu;

		obliczDochodElektrowni = new DochodGazowa();
	}



	public DostawcaGazu getDostawcaGazu() {	return DostawcaGazu; }

	public void setDostawcaGazu(DostawcaGazu dostawcaGazu) { DostawcaGazu = dostawcaGazu; }

	@Override
	public String toString() {
		return "ElektrowniaGazowa:" + super.toString() +
				"\nDostawcaGazu: " + DostawcaGazu.toString() ;
	}
	public String  typ(){
		return "gazowa";
	}

	@Override
	public float ObliczDochod(Elektrownia e) {
		return obliczDochodElektrowni.ObliczDochod(this);
	}


	public float uzupelnij(){
		return (this.getPojemnoscMagazynu()-this.getStanMagazynu())*this.DostawcaGazu.getCenaZaM3();
	}
}
