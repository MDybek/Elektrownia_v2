package com.company.Awarie;

import com.company.Elektrownie.Elektrownia;
import com.company.GUI.Gra;
import com.company.Head.Gracz;

import java.io.Serializable;
import java.util.Random;

public class BrakReakcjiNaAwarie implements ReakcjaNaAwarieZasilania, Serializable {
    @Override
    public void ReakcjeNaAwarieZasilania(Elektrownia e) {
        Random random = new Random();
        e.setLiczbaBlokow(e.getLiczbaBlokow() - random.nextInt(0,4));
        e.setLiczbaPracownikow(e.getLiczbaPracownikow() - random.nextInt(0,3));
        Gracz.balans -= random.nextInt(2000,6000);
        e.setMocChwilowa(random.nextInt(50,80)*e.getMocMaksymalna()/100);
    }
}
