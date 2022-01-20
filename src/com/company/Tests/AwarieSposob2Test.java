package com.company.Tests;

import com.company.Awarie.ReakcjaNaAwarieZasilania;
import com.company.Awarie.Sposob1ReakcjaNaAwarieZasilania;
import com.company.Awarie.Sposob2ReakcjaNaAwarieZasilania;
import com.company.Dochod.DochodGazowa;
import com.company.Elektrownie.*;
import com.company.Head.Gracz;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.assertEquals;

public class AwarieSposob2Test {

    ListyDystrybutorzy dystrybutorzy = new ListyDystrybutorzy();
    ListyWlasciciele wlasciciele = new ListyWlasciciele();
    ListyDostawcy dostawcy = new ListyDostawcy();
    ElektrowniaWeglowa w1;
    ReakcjaNaAwarieZasilania s2 = new Sposob2ReakcjaNaAwarieZasilania();
    Gracz gracz = new Gracz();


    @BeforeEach
    public void setUp() throws Exception {

        gracz = new Gracz();
        gracz.setBalans(1000000f);
        w1 = new ElektrowniaWeglowa("Turów", "Bogatynia", 0, 750, 10, 10,wlasciciele.getWlasciciele().get(0), false, "roksana wegiel", 3f, dystrybutorzy.getDystrybutorzyPradu().get(0), 103, dostawcy.dostawcyWegla.get(0), 190, 50000, 25000, 25000, 10);
        w1.setMocChwilowa(w1.getMocMaksymalna());

    }

    @Test
    public void reakcja2() {
        int bloki2 = 10-3;

        float balans2 = 1000000f - 4000;

        int mocChwilowa = 50*750/100;

        s2.ReakcjeNaAwarieZasilania(w1);

        assertEquals(bloki2, w1.getLiczbaBlokow());
        assertEquals(balans2, gracz.getBalans());
        assertEquals(mocChwilowa, w1.getMocChwilowa());
    }
}
