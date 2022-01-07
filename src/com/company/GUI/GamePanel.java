package com.company.GUI;
import com.company.GUI.ElektrownieOkno.*;
import com.company.Head.Gracz;
import com.company.Head.Serializacja;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {
    final int width = 942;
    final int height = 628;
    Serializacja serializacje;
    Gracz gracz;
    Menue menu;
    Gra gra;
    ListaEle listaAtom;
    ListaEle listaWegiel;
    ListaEle listaGaz;
    ListaEle listaFoto;

    public GamePanel() {
        this.setPreferredSize(new Dimension(width, height));

        new OknoFrame();
        menu = new Menue(width, height);
        gra = new Gra(width, height);

        menu.nowaGra.addActionListener(this);
        menu.wczytajGre.addActionListener(this);
        menu.zakoncz.addActionListener(this);
        this.add(menu);
        gra.atomowa.addActionListener(this);
        gra.weglowa.addActionListener(this);
        gra.gazowa.addActionListener(this);
        gra.fotowoltaiczna.addActionListener(this);
        gra.nastepnyDzien.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        serializacje = new Serializacja();
        if (e.getSource() == menu.nowaGra) {
            gracz = new Gracz();
            listaAtom = new ListaEle(width, height, "atomowych", gracz, "atomowa");
            listaFoto = new ListaEle(width, height, "fotowoltaicnych", gracz, "fotowoltaiczna");
            listaWegiel = new ListaEle(width, height, "weglowych", gracz, "weglowa");
            listaGaz = new ListaEle(width, height, "gazowych", gracz, "gazowa");

            listaAtom.powrot.addActionListener(this);
            listaFoto.powrot.addActionListener(this);
            listaWegiel.powrot.addActionListener(this);
            listaGaz.powrot.addActionListener(this);
            this.remove(menu);
            this.add(gra, BorderLayout.CENTER);
        }
        else if(e.getSource()==menu.wczytajGre){
            System.out.println("Otwieram zapisana gre...");
            this.remove(menu);
            gracz = new Gracz(serializacje.odczyt(),serializacje.odczytStanuKonta());
            listaAtom = new ListaEle(width, height, "atomowych", gracz, "atomowa");
            listaFoto = new ListaEle(width, height, "fotowoltaicnych", gracz, "fotowoltaiczna");
            listaWegiel = new ListaEle(width, height, "weglowych", gracz, "weglowa");
            listaGaz = new ListaEle(width, height, "gazowych", gracz, "gazowa");

            listaAtom.powrot.addActionListener(this);
            listaFoto.powrot.addActionListener(this);
            listaWegiel.powrot.addActionListener(this);
            listaGaz.powrot.addActionListener(this);
            this.add(gra, BorderLayout.CENTER);
        }
        else if (e.getSource() == menu.zakoncz) {
            System.exit(0);
        } else if (e.getSource() == gra.atomowa) {
            this.remove(gra);
            this.add(listaAtom, BorderLayout.CENTER);
        } else if (e.getSource() == gra.weglowa) {
            this.remove(gra);
            this.add(listaWegiel, BorderLayout.CENTER);
        } else if (e.getSource() == gra.gazowa) {
            this.remove(gra);
            this.add(listaGaz, BorderLayout.CENTER);
        } else if (e.getSource() == gra.fotowoltaiczna) {
            this.remove(gra);
            this.add(listaFoto, BorderLayout.CENTER);
        }else if(e.getSource()==gra.nastepnyDzien){
            Random random = new Random();
            for (Kafelek k : gracz.getListaPrzyciskow()){
                int tym = random.nextInt(0,100);
                if (k.isEnabled()){
                    /*
                    if (tym == 13){
                        k.ele.ReakcjaNaAtakTerrorystyczny(k.ele, gracz);
                        atakNotification(k.ele.getMiasto());
                    }
                    if (tym < 2){
                        k.ele.ReakcjeNaAwarieZasilania(k.ele);
                        awariaNotification(k.ele.getMiasto());
                    }

                     */
                    gracz.dodajBalans(k.ele.ObliczDochod(k.ele));
                    gra.stan_konta.setText("Aktualny stan konta: " + Gracz.balans);
                }
            }
            serializacje.zapis(gracz.getListaPrzyciskow());
            serializacje.zapisStanuKonta(Gracz.balans);
        }
        //-------------------------------------------------------------------------
        else if (e.getSource() == listaAtom.powrot) {
            this.remove(listaAtom);
            add(gra, BorderLayout.CENTER);
        }
        else if (e.getSource() == listaFoto.powrot) {
            this.remove(listaFoto);
            add(gra, BorderLayout.CENTER);
        }
        else if (e.getSource() == listaWegiel.powrot) {
            this.remove(listaWegiel);
            add(gra, BorderLayout.CENTER);
        }
        else if (e.getSource() == listaGaz.powrot) {
            this.remove(listaGaz);
            add(gra, BorderLayout.CENTER);
        }
        gra.stan_konta.setText("Aktualny stan konta: " + Gracz.balans);

        this.revalidate();
        this.repaint();

    }
    public void awariaNotification(String miasto) {
        JOptionPane.showMessageDialog(null, "Doszło do awarii elektrowni w " + miasto + "!", "Komunikat", JOptionPane.INFORMATION_MESSAGE);
    }

    public void atakNotification(String miasto) {
        JOptionPane.showMessageDialog(null, "Doszło do ataku terrorystycznego na elektrownie w " + miasto + "!", "Komunikat", JOptionPane.INFORMATION_MESSAGE);
    }
}


