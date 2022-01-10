package com.company.AtakTerro;

import com.company.Elektrownie.Elektrownia;
import com.company.GUI.Gra;
import com.company.Head.Gracz;

import java.io.Serializable;
import java.util.Random;

public class Sposob2ReakcjaNaAtakTerrorystyczny implements ReakcjeNaAtakTerrorystyczny, Serializable {

    private static final long serialVersionUID = 1234670990255712290L;

    @Override
    public void ReakcjaNaAtakTerrorystyczny(Elektrownia e) {
		e.setLiczbaPracownikow(e.getLiczbaPracownikow() - 2);
		Gracz.balans -= 3000;
        e.setMocChwilowa(0);
		//pracownicy do ostatniej chwili walczą z atakiem
    }
}
