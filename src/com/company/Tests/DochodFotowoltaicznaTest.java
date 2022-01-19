package com.company.Tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.company.Dochod.DochodFotowoltaiczna;
import com.company.Elektrownie.ElektrowniaFotowoltaiczna;

class DochodFotowoltaicznaTest {

    DochodFotowoltaiczna ob;
    ElektrowniaFotowoltaiczna elfot;

    @BeforeEach
    void setUp() throws Exception {

        ob = new DochodFotowoltaiczna();
        elfot = new ElektrowniaFotowoltaiczna();

        elfot.getDystrybutor().setCenaSkupu(30);
        elfot.setLiczbaPracownikow(5);
    }

    @Test
    void test1() {

        elfot.setZuzyciePaneli(100);

        int result = 0;

        assertEquals(result, ob.ObliczDochod(elfot));
    }

    @Test
    void test2() {

        elfot.setZuzyciePaneli(0);

        elfot.setMocChwilowa(80);

        int result = 12*(80*30 - 30*5);

        assertEquals(result, ob.ObliczDochod(elfot));

    }

    @Test
    void test3() {

        elfot.setZuzyciePaneli(40);

        elfot.setMocChwilowa(0);

        int result = 12*(0*30 - 30*5);

        assertEquals(result, ob.ObliczDochod(elfot));

    }

}
