package com.company.GUI.ElektrownieOkno;

import com.company.Elektrownie.Elektrownia;
import com.company.Elektrownie.ElektrowniaAtomowa;
import com.company.Head.Gracz;

public class ElektrowniaAtomowaOkno extends ElektrowniaOknoAbstract{
    public ElektrowniaAtomowaOkno(Elektrownia e){
        super(e);
        skrot(stanMagazynuLabel, "Stan magazynu", String.valueOf((e.getStanMagazynu())),informacje);
        skrot(uzupelnianieLabel, "Cena wywozu odpadow", "420",informacje);
    }
}
