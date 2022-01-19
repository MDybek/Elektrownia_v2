package com.company.Tests;

import com.company.Dochod.DochodGazowa;
import com.company.Elektrownie.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DochodGazowaTest {
    ListyDystrybutorzy dystrybutorzy = new ListyDystrybutorzy();
    ListyWlasciciele wlasciciele = new ListyWlasciciele();
    ListyDostawcy dostawcy = new ListyDostawcy();
    DochodGazowa dochodGazowa = new DochodGazowa();

    Elektrownia e1 = new ElektrowniaGazowa("Polgazprom", "Dolna Odra", 0, 800, 10, 10, wlasciciele.getWlasciciele().get(0), false, "gaz", 4.75f, dystrybutorzy.getDystrybutorzyPradu().get(0), 123, dostawcy.dostawcyGazu.get(0), 200, 60000, 30000, 30000, 10);
    Elektrownia e2 = new ElektrowniaGazowa("MelnikGaz", "Pepikovice", 0, 800, 10, 10, wlasciciele.getWlasciciele().get(0), false, "gaz", 4.75f, dystrybutorzy.getDystrybutorzyPradu().get(1), 123, dostawcy.dostawcyGazu.get(1), 200, 112500, 55000, 37500, 10);
    Elektrownia e3 = new ElektrowniaGazowa("Gazprom", "Kacapowo", 0, 800, 10, 10, wlasciciele.getWlasciciele().get(0), false, "gaz", 4.75f, dystrybutorzy.getDystrybutorzyPradu().get(2), 123, dostawcy.dostawcyGazu.get(2), 200, 180000, 90000, 45000, 10);
    Elektrownia e4 = new ElektrowniaGazowa("ENBW", "Helmutsdorf", 0, 800, 10, 10, wlasciciele.getWlasciciele().get(0), false, "gaz", 4.75f, dystrybutorzy.getDystrybutorzyPradu().get(3), 123, dostawcy.dostawcyGazu.get(3), 200, 225000, 112000, 52500, 10);
    Elektrownia e5 = new ElektrowniaGazowa("Centrale", "Reno-Pari", 0, 800, 10, 10, wlasciciele.getWlasciciele().get(0), false, "gaz", 4.75f, dystrybutorzy.getDystrybutorzyPradu().get(4), 123, dostawcy.dostawcyGazu.get(4), 200, 270000, 135000, 60000, 10);

    @Before
    public void setUp() throws Exception {
        e1.setMocChwilowa(e1.getMocMaksymalna());
        e2.setMocChwilowa(e2.getMocMaksymalna());
        e3.setMocChwilowa(e3.getMocMaksymalna());
        e4.setMocChwilowa(e4.getMocMaksymalna());
        e5.setMocChwilowa(e5.getMocMaksymalna());
    }

    @Test
    public void obliczDochod() {
        float result = 6000;
        float result1 = 7500;
        float result2 = 9000;
        float result3 = 10500;
        float result4 = 12000;
        assertEquals(result, dochodGazowa.ObliczDochod(e1),0.1);
        assertEquals(result1, dochodGazowa.ObliczDochod(e2),0.1);
        assertEquals(result2, dochodGazowa.ObliczDochod(e3),0.1);
        assertEquals(result3, dochodGazowa.ObliczDochod(e4),0.1);
        assertEquals(result4, dochodGazowa.ObliczDochod(e5),0.1);
    }
}