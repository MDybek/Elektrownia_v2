package com.company.Elektrownie;

import com.company.Dochod.ObliczDochodElektrowni;
import com.company.Head.Wlasciciel;
import com.company.uslugodawcy.DystrybutorPradu;

public abstract class ElektrowniaNaPaliwoStale extends Elektrownia  {


	private String RodzajPaliwa;
	private float ZuzyciePaliwa;
	private int kiedyDokupic;

	public ElektrowniaNaPaliwoStale() {
		super();
		this.RodzajPaliwa =" 0";
		this.ZuzyciePaliwa = 0;
		this.kiedyDokupic = 0;
	}

	public ElektrowniaNaPaliwoStale(String Nazwa, String miasto, int MocChwilowa, int MocMaksymalna, int liczbaBlokow,
									int LiczbaPracownikow, Wlasciciel wlasciciel, boolean czyPracuje, String RodzajPaliwa,
									float ZuzyciePaliwa, DystrybutorPradu Dystrybutor, int cenaZakupu,
									int cenaSprzedazy, int cenaBloku,int kiedyDokupic,int stanMagazynu, int pojemnoscMagazynu)
	{
		super(Nazwa, miasto, MocChwilowa, MocMaksymalna, liczbaBlokow, LiczbaPracownikow, czyPracuje, wlasciciel, Dystrybutor,
				cenaZakupu, cenaSprzedazy, cenaBloku, kiedyDokupic,stanMagazynu,pojemnoscMagazynu);
		this.RodzajPaliwa = RodzajPaliwa;
		this.ZuzyciePaliwa = ZuzyciePaliwa;
		this.kiedyDokupic = kiedyDokupic;

	}



	public String getRodzajPaliwa() {
		return RodzajPaliwa;
	}

	public void setRodzajPaliwa(String rodzajPaliwa) {
		RodzajPaliwa = rodzajPaliwa;
	}

	public float getZuzyciePaliwa() {
		return ZuzyciePaliwa;
	}

	public void setZuzyciePaliwa(float zuzyciePaliwa) {
		ZuzyciePaliwa = zuzyciePaliwa;
	}

	public int getKiedyDokupic() { return kiedyDokupic; }

	public void setKiedyDokupic(int kiedyDokupic) { this.kiedyDokupic = kiedyDokupic; }

	public String toString()
	{
		return super.toString() + "\nrodzaj paliwa: " + RodzajPaliwa + "\nzuzycie paliwa: " + ZuzyciePaliwa;
	}


}
