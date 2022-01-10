package com.company.Awarie;

import com.company.Elektrownie.Elektrownia;
import com.company.Head.Gracz;

import java.io.Serializable;
import java.util.Random;

public class Sposob2ReakcjaNaAwarieZasilania implements ReakcjaNaAwarieZasilania, Serializable {

    private static final long serialVersionUID = 1234670990255762299L;

    @Override
    public void ReakcjeNaAwarieZasilania(Elektrownia e) {
        e.setLiczbaBlokow(e.getLiczbaBlokow() - 3);
        Gracz.balans -= 4000;
        e.setMocChwilowa(50*e.getMocMaksymalna()/100);
        //pracownicy prawie wyłączają elektrownie wiec moc na 50%, nie giną ale przez to tracą bloki
    }
}
