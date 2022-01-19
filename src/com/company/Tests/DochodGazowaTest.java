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

    @Before
    public void setUp() throws Exception {
        e1.setMocChwilowa(e1.getMocMaksymalna());
    }

    @Test
    public void obliczDochod() {
        float result = 800*24-800*4.75f-10*35*24-0.1f*800*12.5f;

        assertEquals(result, dochodGazowa.ObliczDochod(e1),0.1);
    }

    @Test
    public void obliczDochodUzupelnienieMagazynu() {
        e1.setStanMagazynu(0);
        float result2 = 800*24-800*4.75f-10*35*24-0.1f*800*12.5f-200;
        assertEquals(result2, dochodGazowa.ObliczDochod(e1),0.1);
    }
}