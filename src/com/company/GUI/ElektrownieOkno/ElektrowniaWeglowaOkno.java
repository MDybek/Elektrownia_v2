package com.company.GUI.ElektrownieOkno;

import com.company.Elektrownie.Elektrownia;
import com.company.Head.Gracz;

import javax.swing.*;
import java.awt.*;

public class ElektrowniaWeglowaOkno extends ElektrowniaOknoAbstract{
    public ElektrowniaWeglowaOkno(Elektrownia elektrownia){
        super(elektrownia);
        dokupButton = new JButton();
        JLabel label = new JLabel("STAN MAGAZYNU",SwingConstants.CENTER);
        label.setFont(font);
        label.setForeground(Color.white);
        magazyn.add(label);
        pojedynczyPrzycisk(dokupButton,"DOKUP", magazyn, Color.green);

        skrot(stanMagazynuLabel, "Stan magazynu", String.valueOf(elektrownia.getStanMagazynu()),informacje);
        skrot(uzupelnianieLabel, "Cena uzupelnienia magazynu", "420",informacje);
    }
}

