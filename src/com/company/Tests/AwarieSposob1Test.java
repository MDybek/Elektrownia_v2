package com.company.Tests;

import com.company.Awarie.ReakcjaNaAwarieZasilania;
import com.company.Awarie.Sposob1ReakcjaNaAwarieZasilania;
import com.company.Dochod.DochodGazowa;
import com.company.Elektrownie.ElektrowniaWeglowa;
import com.company.Elektrownie.ListyDostawcy;
import com.company.Elektrownie.ListyDystrybutorzy;
import com.company.Elektrownie.ListyWlasciciele;
import com.company.Head.Gracz;
import org.junit.Before;
import org.testng.annotations.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class AwarieSposob1Test {

    ListyDystrybutorzy dystrybutorzy = new ListyDystrybutorzy();
    ListyWlasciciele wlasciciele = new ListyWlasciciele();
    ListyDostawcy dostawcy = new ListyDostawcy();
    ElektrowniaWeglowa w1 = new ElektrowniaWeglowa("Turów", "Bogatynia", 0, 750, 10, 10,wlasciciele.getWlasciciele().get(0), false, "roksana wegiel", 3f, dystrybutorzy.getDystrybutorzyPradu().get(0), 103, dostawcy.dostawcyWegla.get(0), 190, 50000, 25000, 25000, 10);
    ReakcjaNaAwarieZasilania s1 = new Sposob1ReakcjaNaAwarieZasilania();
    Gracz gracz = new Gracz();


    @Before
    public void setUp() throws Exception {

        gracz = new Gracz();
        w1 = new ElektrowniaWeglowa("Turów", "Bogatynia", 0, 750, 10, 10,wlasciciele.getWlasciciele().get(0), false, "roksana wegiel", 3f, dystrybutorzy.getDystrybutorzyPradu().get(0), 103, dostawcy.dostawcyWegla.get(0), 190, 50000, 25000, 25000, 10);
        w1.setMocChwilowa(w1.getMocMaksymalna());

    }

    @Test
    public void reakcja1() {
        int bloki1 = 10-1;

        int pracownicy1 = 10-3;

        float balans1 = 1000000f - 2000;

        s1.ReakcjeNaAwarieZasilania(w1);

        assertEquals(bloki1, w1.getLiczbaBlokow(),0.1);
        assertEquals(pracownicy1, w1.getLiczbaPracownikow(), 0.1);
        assertEquals(balans1, gracz.getBalans(), 0.1);

    }
}
