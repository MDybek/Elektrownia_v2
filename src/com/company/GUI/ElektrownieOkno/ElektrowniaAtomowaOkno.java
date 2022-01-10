package com.company.GUI.ElektrownieOkno;

import com.company.Elektrownie.Elektrownia;
import com.company.Elektrownie.ElektrowniaAtomowa;
import com.company.Head.Gracz;

import javax.swing.*;
import java.awt.*;

public class ElektrowniaAtomowaOkno extends ElektrowniaOknoAbstract{
    public ElektrowniaAtomowaOkno(Elektrownia e){
        super(e);
        dokupButton = new JButton();
        JLabel label = new JLabel("STAN MAGAZYNU",SwingConstants.CENTER);
        label.setFont(font);
        label.setForeground(Color.white);
        magazyn.add(label);
        pojedynczyPrzycisk(dokupButton,"DOKUP", magazyn, Color.green);

        skrot(stanMagazynuLabel, "Stan magazynu", String.valueOf((e.getStanMagazynu())),informacje);
        skrot(uzupelnianieLabel, "Cena wywozu odpadow", "420",informacje);
    }
}
