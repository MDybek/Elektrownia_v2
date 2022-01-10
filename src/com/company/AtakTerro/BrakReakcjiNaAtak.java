package com.company.AtakTerro;

import com.company.Elektrownie.Elektrownia;
import com.company.Head.Gracz;

import java.io.Serializable;
import java.util.Random;

public class BrakReakcjiNaAtak implements ReakcjeNaAtakTerrorystyczny, Serializable {
    @Override
    public void ReakcjaNaAtakTerrorystyczny(Elektrownia e) {
        Random random = new Random();
        e.setLiczbaPracownikow(e.getLiczbaPracownikow() - random.nextInt(0,3));
        e.setLiczbaBlokow(e.getLiczbaBlokow() - random.nextInt(0,2));
        Gracz.balans -= random.nextInt(1000,5000);
        e.setMocChwilowa(0);
    }
}
