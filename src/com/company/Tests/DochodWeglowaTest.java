package com.company.Tests;

import com.company.Dochod.DochodGazowa;
import com.company.Dochod.DochodWeglowa;
import com.company.Elektrownie.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DochodWeglowaTest {
    ListyDystrybutorzy dystrybutorzy = new ListyDystrybutorzy();
    ListyWlasciciele wlasciciele = new ListyWlasciciele();
    ListyDostawcy dostawcy = new ListyDostawcy();
    DochodWeglowa dochodWeglowa = new DochodWeglowa();

    Elektrownia e1 = new ElektrowniaWeglowa("Turów", "Bogatynia", 0, 750, 10, 10, wlasciciele.getWlasciciele().get(0), false, "roksana wegiel", 3f, dystrybutorzy.getDystrybutorzyPradu().get(0), 103, dostawcy.dostawcyWegla.get(0), 190, 50000, 25000, 25000, 10);

    @Before
    public void setUp() throws Exception {
        e1.setMocChwilowa(e1.getMocMaksymalna());
    }

    @Test
    public void obliczDochod() {
        float result = 750*24-750*3f*1.21f-10*35*24-0.5f*750*5f;

        assertEquals(result, dochodWeglowa.ObliczDochod(e1),0.1);
    }

    @Test
    public void obliczDochodUzupelnienieMagazynu() {
        e1.setStanMagazynu(0);
        float result2 = 750*24-750*3f*1.21f-10*35*24-0.5f*750*5f-1.21f*190;
        assertEquals(result2, dochodWeglowa.ObliczDochod(e1),0.1);
    }
}
