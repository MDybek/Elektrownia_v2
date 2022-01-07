package com.company.GUI;

import javax.swing.*;

import com.company.Head.Gracz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ListaEle extends JPanel implements ActionListener {

    private int liczbaEle = 0;
    JLabel tytul;
    public static JLabel stanKonta;

    JPanel panelPrzyciskow;
    JButton powrot;
    JPanel dol;

    ListaEle(int szer, int wys,String title, Gracz g, String typ){
        //USTAWIENIA PANELU
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(szer,wys));
        this.setBackground(Color.gray);

        //TYTUŁ PANELU
        tytul = new JLabel("Lista twoich elektrowni " + title);
        this.add(Box.createRigidArea(new Dimension(0,50)));
        tytul.setFont(new Font("Ink Free",Font.BOLD,40));
        tytul.setForeground(Color.white);
        tytul.setAlignmentX(CENTER_ALIGNMENT);
        this.add(tytul);


        //STAN KONTA GRACZA
        stanKonta = new JLabel();
        stanKonta.setText("Stan konta: " + Gracz.balans);
        stanKonta.setFont(new Font("Ink Free",Font.BOLD,20));
        stanKonta.setForeground(Color.white);
        stanKonta.setAlignmentX(CENTER_ALIGNMENT);
        this.add(stanKonta);

        //USTAWIENIA PANELU Z PRZYCISKAMI
        panelPrzyciskow = new JPanel();
        this.add(Box.createRigidArea(new Dimension(0,130)));
        panelPrzyciskow.setPreferredSize(new Dimension(szer,160));

        //DODANIE PRZYCISKÓW DO PANELU
        for(Kafelek button : g.getListaPrzyciskow()){
            if (button.ele.typ().equals(typ)) {
                panelPrzyciskow.add(button);
            }
        }


        panelPrzyciskow.setLayout(new GridLayout());

        this.add(panelPrzyciskow);
        this.add(Box.createRigidArea(new Dimension(0,120)));

        //DOLNY PANEL
        dol = new JPanel();
        dol.setLayout(null);
        dol.setBackground(Color.gray);
        dol.setPreferredSize(new Dimension(szer,80));

        //PRZYCISK POWROTU
        powrot = new JButton("Powrot");
        powrot.setBounds(szer-150,0,130,60);
        powrot.setFont(new Font("Arial black", Font.BOLD, 18));
        powrot.addActionListener(this);
        dol.add(powrot);
        this.add(dol);

    }
    public static void update(float stan){
        if (!stanKonta.getText().equals("Stan konta: " + stan)){
            stanKonta.setText("Stan konta: " + stan);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        this.revalidate();
        this.repaint();
    }
}
