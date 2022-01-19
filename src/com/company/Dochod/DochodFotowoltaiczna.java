package com.company.Dochod;

import com.company.Elektrownie.Elektrownia;
import com.company.Elektrownie.ElektrowniaAtomowa;
import com.company.Elektrownie.ElektrowniaFotowoltaiczna;

import java.io.Serializable;

public class DochodFotowoltaiczna implements ObliczDochodElektrowni, Serializable {
    private static final long serialVersionUID = 1223143L;
    int EnergiaProdukowanaPrzezJedenBlok = 55;
    int StawkaGodzinowa =30;

    @Override
    public float ObliczDochod(Elektrownia e) {

        ElektrowniaFotowoltaiczna ef = (ElektrowniaFotowoltaiczna) e;

        ef.setMocMaksymalna(ef.getLiczbaBlokow() * EnergiaProdukowanaPrzezJedenBlok);

        if (ef.getZuzyciePaneli() < 100) {
            return
                    //przychod
                    ef.getMocChwilowa() * ef.getDystrybutor().getCenaSkupu() * 12
                            //wydatki
                            - ef.getLiczbaPracownikow() * StawkaGodzinowa * 12;
        }
            return 0;
    }
}
