package com.company.Awarie;
import java.util.Random;

import com.company.Elektrownie.Elektrownia;
import com.company.Head.Gracz;

import java.io.Serializable;

public class Sposob1ReakcjaNaAwarieZasilania implements ReakcjaNaAwarieZasilania , Serializable {
    private static final long serialVersionUID = 1234670990555762290L;


    @Override
    public void ReakcjeNaAwarieZasilania(Elektrownia e) {

        e.setLiczbaBlokow(e.getLiczbaBlokow() - 1);
        e.setLiczbaPracownikow(e.getLiczbaPracownikow() - 3);
        Gracz.balans -= 2000;
        e.setMocChwilowa(75*e.getMocMaksymalna()/100);
        //pomimo awarii elektrownia parcuje na 75% i pracownicy naprawiają elektrownie wiec giną
    }

}
