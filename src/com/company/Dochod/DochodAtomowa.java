package com.company.Dochod;

import com.company.Elektrownie.Elektrownia;
import com.company.Elektrownie.ElektrowniaAtomowa;

import java.io.Serializable;

public class DochodAtomowa implements ObliczDochodElektrowni, Serializable {
    private static final long serialVersionUID = 1113123L;
    float cenaWody = 0.1f;
    int StawkaGodzinowa = 40;
    int EnegiaProdukowanaPrzezReaktor = 150;

    @Override
    public float ObliczDochod(Elektrownia e) {

        ElektrowniaAtomowa ea = (ElektrowniaAtomowa) e;

        ea.setMocMaksymalna(ea.getLiczbaBlokow()*ea.getLiczbaReaktorow()*EnegiaProdukowanaPrzezReaktor);

        if(ea.getStanMagazynu()*100/ea.getPojemnoscMagazynu() < ea.getKiedyDokupic()){
            ea.setStanMagazynu(ea.getPojemnoscMagazynu());
            return
                    //przychod
                    ea.getMocChwilowa()* ea.getDystrybutor().getCenaSkupu()*24
                            //wydatki
                            - ea.getMocChwilowa()* ea.getZuzycieWody()*cenaWody
                            - ea.getLiczbaPracownikow()*StawkaGodzinowa*24;
        }

        return
                //przychod
                ea.getMocChwilowa()* ea.getDystrybutor().getCenaSkupu()*24
                //wydatki
                        //na wode
                - ea.getMocChwilowa()*ea.getZuzycieWody()*cenaWody
                        //na pracownikow
                - ea.getLiczbaPracownikow()*StawkaGodzinowa*24;
    }
}
