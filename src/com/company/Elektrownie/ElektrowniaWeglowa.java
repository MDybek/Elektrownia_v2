package com.company.Elektrownie;

import com.company.Dochod.DochodWeglowa;
import com.company.Head.Wlasciciel;
import com.company.uslugodawcy.DostawcaWegla;
import com.company.uslugodawcy.DystrybutorPradu;

public class ElektrowniaWeglowa extends ElektrowniaNaPaliwoStale  {

    private com.company.uslugodawcy.DostawcaWegla DostawcaWegla;

    public ElektrowniaWeglowa() {
        super();
        DostawcaWegla = new DostawcaWegla();
    }

    public ElektrowniaWeglowa(String Nazwa, String Miasto, int MocChwilowa, int MocMaksymalna, int liczbaBlokow, int LiczbaPracownikow,
                              Wlasciciel wlasciciel, boolean czyPracuje, String RodzajPaliwa, float ZuzyciePaliwa, int LiczbaBlokow,
                              DystrybutorPradu DystrybutorPradu, int stanMagazynu, DostawcaWegla DostawcaWegla,
                              int pojemnoscMagazynu, int cenaZakupu, int cenaSprzedazy, int cenaBloku,int kiedyDokupic) {

        super(Nazwa, Miasto, MocChwilowa, MocMaksymalna, liczbaBlokow, LiczbaPracownikow, wlasciciel, czyPracuje, RodzajPaliwa,
                ZuzyciePaliwa, LiczbaBlokow, DystrybutorPradu, cenaZakupu, cenaSprzedazy, cenaBloku, kiedyDokupic,stanMagazynu,pojemnoscMagazynu);
        this.DostawcaWegla = DostawcaWegla;

        obliczDochodElektrowni = new DochodWeglowa();
    }

    public DostawcaWegla getDostawcaWegla() {
        return DostawcaWegla;
    }

    public void setDostawcaWegla(DostawcaWegla dostawcaWegla) {
        DostawcaWegla = dostawcaWegla;
    }
    public float uzupelnij(){
        return (this.getPojemnoscMagazynu()-this.getStanMagazynu())*this.DostawcaWegla.getCenaZaTone();
    }

    @Override
    public String toString() {
        return "ElektrowniaWeglowa: " + super.toString() +
                "\nDostawcaWegla: " + DostawcaWegla.toString() ;
    }
    public String  typ(){
        return "weglowa";
    }

    @Override
    public float ObliczDochod(Elektrownia e) {
        return obliczDochodElektrowni.ObliczDochod(e);
    }
}
