package com.company.Dochod;

import com.company.Elektrownie.*;

import java.io.Serializable;

public class DochodGazowa implements ObliczDochodElektrowni, Serializable {
    private static final long serialVersionUID = 123123L;

    float IloscCO2 = 0.1f;
    float OplataEmisyjna = 12.5f;
    int StawkaGodzinowa =35;
    int EnergiaProdukowanaPrzezJedenBlok = 80;

    public float ObliczDochod(Elektrownia e){

        ElektrowniaGazowa eg = (ElektrowniaGazowa) e;

        eg.setMocMaksymalna(eg.getLiczbaBlokow()*EnergiaProdukowanaPrzezJedenBlok);

        if (eg.getStanMagazynu()*100/eg.getPojemnoscMagazynu() < eg.getKiedyDokupic()){
            eg.setStanMagazynu(eg.getPojemnoscMagazynu());

            return  eg.getMocChwilowa()* eg.getDystrybutor().getCenaSkupu()*24
                    - eg.getMocChwilowa()*eg.getZuzyciePaliwa()*eg.getDostawcaGazu().getCenaZaM3()
                    -eg.getLiczbaPracownikow()*StawkaGodzinowa*24
                    -IloscCO2*eg.getMocChwilowa()*OplataEmisyjna
                    -eg.getDostawcaGazu().getCenaZaM3()*eg.getPojemnoscMagazynu();
        }

            return eg.getMocChwilowa() * eg.getDystrybutor().getCenaSkupu() * 24
                    - eg.getMocChwilowa() * eg.getZuzyciePaliwa() * eg.getDostawcaGazu().getCenaZaM3()
                    - eg.getLiczbaPracownikow() * StawkaGodzinowa * 24
                    - IloscCO2 * eg.getMocChwilowa() * OplataEmisyjna;

    }
}