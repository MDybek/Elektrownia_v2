package com.company.AtakTerro;

import com.company.Elektrownie.Elektrownia;
import java.io.Serializable;
import java.util.Random;
import com.company.Head.Gracz;


public class Sposob1ReakcjaNaAtakTerrorystyczny implements ReakcjeNaAtakTerrorystyczny, Serializable {

    private static final long serialVersionUID = 34670990255762290L;

    @Override
    public void ReakcjaNaAtakTerrorystyczny(Elektrownia e) {
		e.setLiczbaBlokow(e.getLiczbaBlokow() - 2);
		Gracz.balans -= 4000;
        e.setMocChwilowa(0);
        }
        //pracownicy jak najszybciej się ewakuują
}

