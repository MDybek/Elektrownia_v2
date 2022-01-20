package com.company.Tests;

import com.company.AtakTerro.Sposob1ReakcjaNaAtakTerrorystyczny;
import com.company.Elektrownie.ElektrowniaWeglowa;
import com.company.Elektrownie.ListyDostawcy;
import com.company.Elektrownie.ListyDystrybutorzy;
import com.company.Elektrownie.ListyWlasciciele;
import com.company.Head.Gracz;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AtakSposob1Test {


    ListyDystrybutorzy dystrybutorzy = new ListyDystrybutorzy();
    ListyWlasciciele wlasciciele = new ListyWlasciciele();
    ListyDostawcy dostawcy = new ListyDostawcy();
    ElektrowniaWeglowa w1;
    Sposob1ReakcjaNaAtakTerrorystyczny s1 = new Sposob1ReakcjaNaAtakTerrorystyczny();
    Gracz gracz = new Gracz();


    @BeforeEach
    public void setUp() throws Exception {

        gracz = new Gracz();
        gracz.setBalans(1000000f);
        w1 = new ElektrowniaWeglowa("Turów", "Bogatynia", 0, 750, 10, 10,wlasciciele.getWlasciciele().get(0), false, "roksana wegiel", 3f, dystrybutorzy.getDystrybutorzyPradu().get(0), 103, dostawcy.dostawcyWegla.get(0), 190, 50000, 25000, 25000, 10);
        w1.setMocChwilowa(w1.getMocMaksymalna());

    }

    @Test
    public void reakcja1() {
        int bloki1 = 10-2;

        float balans1 = 1000000f - 4000;

        int mocChwilowa = 0;
        s1.ReakcjaNaAtakTerrorystyczny(w1);

        assertEquals(bloki1, w1.getLiczbaBlokow(),0.1);
        assertEquals(balans1, gracz.getBalans(), 0.1);
        assertEquals(mocChwilowa, w1.getMocChwilowa());

    }

}
