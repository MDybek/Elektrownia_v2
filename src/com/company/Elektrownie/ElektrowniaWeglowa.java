package com.company.Elektrownie;

import com.company.AtakTerro.Sposob1ReakcjaNaAtakTerrorystyczny;
import com.company.Awarie.Sposob1ReakcjaNaAwarieZasilania;
import com.company.Dochod.DochodWeglowa;
import com.company.Head.Pracownicy;
import com.company.Head.Wlasciciel;
import com.company.uslugodawcy.DostawcaWegla;
import com.company.uslugodawcy.DystrybutorPradu;

import java.util.Arrays;

public class ElektrowniaWeglowa extends ElektrowniaNaPaliwoStale  {

    private com.company.uslugodawcy.DostawcaWegla DostawcaWegla;
    private float IloscWeglaWMagazynie;
    private float MaxPojemnoscMagazynu;

    public ElektrowniaWeglowa() {
        super();
        DostawcaWegla = new DostawcaWegla();
        IloscWeglaWMagazynie = 100;
    }

    public ElektrowniaWeglowa(String Nazwa, String Miasto, int MocChwilowa, int MocMaksymalna, int liczbaBlokow, int LiczbaPracownikow,
                              Wlasciciel wlasciciel, boolean czyPracuje, String RodzajPaliwa, float ZuzyciePaliwa, int LiczbaBlokow,
                              DystrybutorPradu DystrybutorPradu, float IloscWeglaWMagazynie, DostawcaWegla DostawcaWegla,
                              float MaxPojemnoscMagazynu, int cenaZakupu, int cenaSprzedazy, int cenaBloku,int kiedyDokupic) {

        super(Nazwa, Miasto, MocChwilowa, MocMaksymalna, liczbaBlokow, LiczbaPracownikow, wlasciciel, czyPracuje, RodzajPaliwa,
                ZuzyciePaliwa, LiczbaBlokow, DystrybutorPradu, cenaZakupu, cenaSprzedazy, cenaBloku, kiedyDokupic);
        this.DostawcaWegla = DostawcaWegla;
        this.IloscWeglaWMagazynie = IloscWeglaWMagazynie;
        this.MaxPojemnoscMagazynu = MaxPojemnoscMagazynu;

        obliczDochodElektrowni = new DochodWeglowa();
    }

    public DostawcaWegla getDostawcaWegla() {
        return DostawcaWegla;
    }

    public void setDostawcaWegla(DostawcaWegla dostawcaWegla) {
        DostawcaWegla = dostawcaWegla;
    }

    public float getIloscWeglaWMagazynie() {
        return IloscWeglaWMagazynie;
    }

    public void setIloscWeglaWMagazynie(float iloscWeglaWMagazynie) {
        IloscWeglaWMagazynie = iloscWeglaWMagazynie;
    }

    public float getMaxPojemnoscMagazynu() {
        return MaxPojemnoscMagazynu;
    }

    public void setMaxPojemnoscMagazynu(float maxPojemnoscMagazynu) {
        MaxPojemnoscMagazynu = maxPojemnoscMagazynu;
    }
    public float uzupelnij(){
        return (this.getMaxPojemnoscMagazynu()-this.IloscWeglaWMagazynie)*this.DostawcaWegla.getCenaZaTone();
    }

    @Override
    public String toString() {
        return "ElektrowniaWeglowa: " + super.toString() +
                "\nDostawcaWegla: " + DostawcaWegla.toString() +
                "\nIloscWeglaWMagazynie: " + IloscWeglaWMagazynie +
                "\nMaksymalna Pojemność Magazynu: " + MaxPojemnoscMagazynu;
    }
    public String  typ(){
        return "weglowa";
    }

    @Override
    public float ObliczDochod(Elektrownia e) {
        return obliczDochodElektrowni.ObliczDochod(e);
    }
}
