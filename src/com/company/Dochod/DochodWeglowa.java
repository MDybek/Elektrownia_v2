package com.company.Dochod;

import com.company.Elektrownie.Elektrownia;
import com.company.Elektrownie.ElektrowniaGazowa;
import com.company.Elektrownie.ElektrowniaWeglowa;

import java.io.Serializable;

public class DochodWeglowa implements ObliczDochodElektrowni, Serializable {
    private static final long serialVersionUID = 1223123L;

    float IloscCO2 = 0.5f;
    float OplataEmisyjna = 5f;
    int StawkaGodzinowa = 35;
    int EnergiaProdukowanaPrzezJedenBlok = 75;

    public float ObliczDochod(Elektrownia e){

        ElektrowniaWeglowa ew = (ElektrowniaWeglowa) e;

        ew.setMocMaksymalna(ew.getLiczbaBlokow()*EnergiaProdukowanaPrzezJedenBlok);

        if(ew.getStanMagazynu()*100/ew.getStanMagazynu() < ew.getKiedyDokupic()){
            ew.setStanMagazynu(ew.getPojemnoscMagazynu());

            return  ew.getMocChwilowa()* ew.getDystrybutor().getCenaSkupu()*24  // dochód
                    //wydatki na wegiel
                    - ew.getMocChwilowa()*ew.getZuzyciePaliwa()*ew.getDostawcaWegla().getCenaZaTone()
                    //wydatki na pracownikow
                    -ew.getLiczbaPracownikow()*StawkaGodzinowa*24
                    //wydatki na kary emisyjne
                    -IloscCO2*ew.getMocChwilowa()*OplataEmisyjna
                    -ew.getDostawcaWegla().getCenaZaTone()*ew.getPojemnoscMagazynu()-ew.getStanMagazynu();
        }

        return  ew.getMocChwilowa()* ew.getDystrybutor().getCenaSkupu()*24  // dochód
                //wydatki na wegiel
                - ew.getMocChwilowa()*ew.getZuzyciePaliwa()*ew.getDostawcaWegla().getCenaZaTone()
                //wydatki na pracownikow
                -ew.getLiczbaPracownikow()*StawkaGodzinowa*24
                //wydatki na kary emisyjne
                -IloscCO2*ew.getMocChwilowa()*OplataEmisyjna;
    }
}
