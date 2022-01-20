package com.company.Tests;

import com.company.AtakTerro.Sposob2ReakcjaNaAtakTerrorystyczny;
import com.company.Elektrownie.ElektrowniaWeglowa;
import com.company.Elektrownie.ListyDostawcy;
import com.company.Elektrownie.ListyDystrybutorzy;
import com.company.Elektrownie.ListyWlasciciele;
import com.company.Head.Gracz;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AtakSposob2Test {
    ListyDystrybutorzy dystrybutorzy = new ListyDystrybutorzy();
    ListyWlasciciele wlasciciele = new ListyWlasciciele();
    ListyDostawcy dostawcy = new ListyDostawcy();
    ElektrowniaWeglowa w1;
    Sposob2ReakcjaNaAtakTerrorystyczny s2 = new Sposob2ReakcjaNaAtakTerrorystyczny();
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
        int pracownicy1 = 10-2;

        float balans1 = 1000000f - 3000;

        int mocChwilowa = 0;
        s2.ReakcjaNaAtakTerrorystyczny(w1);

        assertEquals(pracownicy1, w1.getLiczbaPracownikow());
        assertEquals(balans1, gracz.getBalans());
        assertEquals(mocChwilowa, w1.getMocChwilowa());

    }
}
