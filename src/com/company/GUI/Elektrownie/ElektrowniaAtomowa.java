package com.company.GUI.Elektrownie;
import javax.swing.*;
import java.awt.*;

public class ElektrowniaAtomowa extends JFrame {
    JLabel miasto;
    JLabel moc_chwilowa;
    JLabel moc_maksymalna;
    JLabel liczba_pracowanikow;
    JLabel wlasciciel;
    JLabel czypracuje;
    JLabel dystrybutor;
    JLabel liczba_reaktorow;
    JLabel zuzycie_wody;
    JLabel ilosc_odpadow;
    JLabel odbiorca_odpadow;


    public ElektrowniaAtomowa(){
        this.setTitle("Elektrownia atomowa");
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(900, 630);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.black);

        this.setLayout(new GridBagLayout());
        JPanel panel = new JPanel();

        panel.setBackground(Color.black);
        this.add(panel, new GridBagConstraints());

        miasto = new JLabel("Lokalizacja elektrowni: ");
        tekst(miasto);

        moc_chwilowa = new JLabel("Moc chwilowa elektrowni: ");
        tekst(moc_chwilowa);

        moc_maksymalna = new JLabel("Moc maksymalna elektrowni: ");
        tekst(moc_maksymalna);

        liczba_pracowanikow = new JLabel("Liczba pracowników elektrowni: ");
        tekst(liczba_pracowanikow);

        liczba_reaktorow = new JLabel("Liczba reaktorow elektrowni: ");
        tekst(liczba_reaktorow);

        zuzycie_wody = new JLabel("Zużycie wody przez elektrownie: ");
        tekst(zuzycie_wody);

        ilosc_odpadow = new JLabel("Ilość odpadów: ");
        tekst(ilosc_odpadow);

        wlasciciel = new JLabel("Wlasciciel elektrowni: ");
        tekst(wlasciciel);

        czypracuje = new JLabel("Czy elektrownia pracuje: ");
        tekst(czypracuje);

        dystrybutor = new JLabel("Dystrybutor pradu: ");
        tekst(dystrybutor);

        odbiorca_odpadow = new JLabel("Odbiorca odpadów: ");
        tekst(odbiorca_odpadow);

        panel.add(miasto);
        panel.add(moc_chwilowa);
        panel.add(moc_maksymalna);
        panel.add(liczba_pracowanikow);
        panel.add(liczba_reaktorow);
        panel.add(zuzycie_wody);
        panel.add(ilosc_odpadow);
        panel.add(wlasciciel);
        panel.add(czypracuje);
        panel.add(dystrybutor);
        panel.add(odbiorca_odpadow);
    }

    public void tekst(JLabel tekst){
        tekst.setFont(new Font("Arial black", Font.BOLD, 20));
        tekst.setForeground(Color.white);
    }
}