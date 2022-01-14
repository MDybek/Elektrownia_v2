package com.company.GUI;

import javax.swing.*;

import com.company.Head.Gracz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ListaEle extends JPanel implements ActionListener {

    private int liczbaEle = 0;
    JLabel tytul;
    public JLabel stanKonta;
    String rodzajElektrowni;

    JPanel panelPrzyciskow;
    JButton dodaj;
    JButton powrot;
    JPanel dol;

    ListaEle(int szer, int wys,String title, Gracz g, String typ){
        rodzajElektrowni = typ;
        //USTAWIENIA PANELU
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(szer,wys));
        this.setBackground(Color.gray);

        //maly przycisk
        JPanel top = new JPanel();
        dodaj = new JButton("Dodaj elektrownie");
        dodaj.setPreferredSize(new Dimension(150,30));
        dodaj.addActionListener(this);
        top.setPreferredSize(new Dimension(szer,30));
        top.setBackground(Color.gray);
        top.add(dodaj);
        this.add(top);

        //TYTUŁ PANELU
        tytul = new JLabel("Lista twoich elektrowni " + title);
        this.add(Box.createRigidArea(new Dimension(0,30)));
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
        panelPrzyciskow.setLayout(new GridLayout());

        //DODANIE PRZYCISKÓW DO PANELU
        for(Kafelek button : g.getListaPrzyciskow()){
            if (button.ele.typ().equals(typ)) {
                panelPrzyciskow.add(button);
            }
        }
        JScrollPane scrollPane = new JScrollPane(panelPrzyciskow,JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        this.add(scrollPane);
        this.add(Box.createRigidArea(new Dimension(0,100)));

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
    void update(float stan){
        if (!this.stanKonta.getText().equals("Stan konta: " + stan)){
            this.stanKonta.setText("Stan konta: " + stan);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dodaj){
            new dodajElektrownie(rodzajElektrowni, panelPrzyciskow);
        }
        this.revalidate();
        this.repaint();
    }
}
