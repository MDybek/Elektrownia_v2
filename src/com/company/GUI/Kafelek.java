package com.company.GUI;

import com.company.AtakTerro.Sposob1ReakcjaNaAtakTerrorystyczny;
import com.company.AtakTerro.Sposob2ReakcjaNaAtakTerrorystyczny;
import com.company.Awarie.BrakReakcjiNaAwarie;
import com.company.Awarie.Sposob1ReakcjaNaAwarieZasilania;
import com.company.Awarie.Sposob2ReakcjaNaAwarieZasilania;
import com.company.Elektrownie.Elektrownia;
import com.company.GUI.ElektrownieOkno.*;
import com.company.Head.Gracz;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Kafelek extends JButton implements ActionListener, ChangeListener {
    final int cenaZatrudnieniaPracownika = 100;
    private JLabel nazwa;
    private JLabel miasto;
    private JButton kup;
    private JLabel cena;

    ElektrowniaOknoAbstract okno;

    Elektrownia ele;
    public Kafelek(Elektrownia e){
        ele = e;
        Font font = new Font("Arial black", Font.BOLD, 20);

        nazwa = new JLabel(ele.getNazwa());
        nazwa.setFont(font);
        nazwa.setAlignmentX(CENTER_ALIGNMENT);
        miasto = new JLabel(ele.getMiasto());
        miasto.setFont(font);
        miasto.setAlignmentX(CENTER_ALIGNMENT);

        kup = new JButton("KUP");
        kup.setFont(font);
        kup.setFocusable(false);
        kup.setForeground(Color.black);
        kup.setBackground(Color.red);
        kup.setAlignmentX(CENTER_ALIGNMENT);
        kup.addActionListener(this);

        cena = new JLabel(String.valueOf(ele.getCenaZakupu()));
        cena.setFont(font);
        cena.setAlignmentX(CENTER_ALIGNMENT);

        this.setEnabled(false);
        this.setPreferredSize(new Dimension(180,200));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(Box.createRigidArea(new Dimension(0,10)));
        this.add(nazwa);
        this.add(miasto);
        this.add(Box.createRigidArea(new Dimension(0,10)));
        this.add(kup);
        this.add(cena);
        this.addActionListener(this);



    }
    public void przypisOkna(){
        if (ele.typ().equals("atomowa")){
            okno = new ElektrowniaAtomowaOkno(ele);
        }else if (ele.typ().equals("fotowoltaiczna")){
            okno = new ElektrowniaFotowoltaicznaOkno(ele);
        }else if (ele.typ().equals("weglowa")){
            okno = new ElektrowniaWeglowaOkno(ele);
        }else{
            okno = new ElektrowniaGazowaOkno(ele);
        }
        okno.dokupButton.addActionListener(this);
        okno.zatrudnijPracownika.addActionListener(this);
        okno.zwolnijPracownika.addActionListener(this);
        okno.kupBloki.addActionListener(this);
        okno.sprzedajButton.addActionListener(this);
        okno.zapiszIZamknij.addActionListener(this);
        okno.atakBrak.addActionListener(this);
        okno.atak1.addActionListener(this);
        okno.atak2.addActionListener(this);
        okno.awariaBrak.addActionListener(this);
        okno.awaria1.addActionListener(this);
        okno.awaria2.addActionListener(this);
        okno.mocSlider.addChangeListener(this);
        okno.kiedySlider.addChangeListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == kup && Gracz.balans > ele.getCenaZakupu()){
            przypisOkna();
            Gracz.balans -= ele.getCenaZakupu();
            kup.setVisible(false);
            cena.setVisible(false);
            this.setEnabled(true);
        }else if(e.getSource() == kup && Gracz.balans < ele.getCenaZakupu()){
            JOptionPane.showMessageDialog(null,"Nie stać cię biedaku!","Komunikat",JOptionPane.INFORMATION_MESSAGE);
        }
        else if(e.getSource() == this){
            OknoFrame.mainPanel.removeAll();
            OknoFrame.mainPanel.add(okno);
            OknoFrame.frame.setVisible(true);
        }
        else if (e.getSource() == okno.sprzedajButton){
            Gracz.balans += ele.getCenaSprzedazy();
            this.setEnabled(false);
            kup.setVisible(true);
            cena.setVisible(true); //cena się nie zaktualizowała, elektrownia po modyfikacjach ma taką samą cenę(naprawić)
            OknoFrame.frame.dispose();
        }
        else if(e.getSource() == okno.kupBloki){
            Gracz.balans -= ele.getCenaBloku();
            ele.setLiczbaBlokow(ele.getLiczbaBlokow() + 1);
            okno.mocMaksymalnaLabel.setText("<html><div style='text-align: center;'> Moc maksymalna elektrowni: <br> " + String.valueOf(Integer.valueOf(ele.getMocMaksymalna())) +"<html>");
            okno.liczbaBlokowLabel.setText("<html><div style='text-align: center;'> Liczba blokow elektrowni: <br> " + ele.getLiczbaBlokow() +"<html>");
            odswierzSlider();
        }
        else if(e.getSource() == okno.zatrudnijPracownika){
            Gracz.balans -= cenaZatrudnieniaPracownika;
            ele.setLiczbaPracownikow(ele.getLiczbaPracownikow() + 1);
            okno.liczbaPracownikowLabel.setText("<html><div style='text-align: center;'> Liczba pracowników elektrowni: <br> " + ele.getLiczbaPracownikow() +"<html>");
            odswierzSlider();
        }
        else if(e.getSource() == okno.zwolnijPracownika){
            ele.setLiczbaPracownikow(ele.getLiczbaPracownikow() - 1);
            okno.liczbaPracownikowLabel.setText("<html><div style='text-align: center;'> Liczba pracowników elektrowni: <br> " + ele.getLiczbaPracownikow() +"<html>");
            odswierzSlider();
        }
        else if(e.getSource() == okno.dokupButton){
            Gracz.balans -= ele.uzupelnij();
            //rodzaj.uzupelnienieMagazynu(indeksEle%5);    dodać do konstuktora głównego stan magazynu
            //okno.stanMagazynuLabel.setText("<html><div style='text-align: center;'> Stan magazynu: <br> " + "maks" +"<html>");
        }
        else if(e.getSource() == okno.zapiszIZamknij) {
            //dodać serializacje
            OknoFrame.frame.dispose();
        }
        //REAKCJE ATAK JBUTTON
        else if (e.getSource() == okno.atakBrak){
            ele.setReakcjaNaAwarieZasilania(new BrakReakcjiNaAwarie());  //trzeba w konstruktorze usunąć sposobna reakcje(int)
        }else if (e.getSource() == okno.atak1){
            ele.setReakcjeNaAtakTerrorystyczny(new Sposob1ReakcjaNaAtakTerrorystyczny());
        }else if (e.getSource() == okno.atak2){
            ele.setReakcjeNaAtakTerrorystyczny(new Sposob2ReakcjaNaAtakTerrorystyczny());
        }
        //REAKCJE NA AWARIE
        else if (e.getSource() == okno.awariaBrak){
            ele.setReakcjaNaAwarieZasilania(new BrakReakcjiNaAwarie());
        }else if (e.getSource() == okno.awaria1){
            ele.setReakcjaNaAwarieZasilania(new Sposob1ReakcjaNaAwarieZasilania());
        }else if (e.getSource() == okno.awaria2){
            ele.setReakcjaNaAwarieZasilania(new Sposob2ReakcjaNaAwarieZasilania());
        }
        GamePanel.listaAtom.update(Gracz.balans);
        GamePanel.listaWegiel.update(Gracz.balans);
        GamePanel.listaGaz.update(Gracz.balans);
        GamePanel.listaFoto.update(Gracz.balans);
        OknoFrame.frame.revalidate();
        OknoFrame.frame.repaint();
        
    }
    void odswierzSlider(){
        int tym = ele.getLiczbaPracownikow() * 100 / ele.getLiczbaBlokow();
        if (okno.mocSlider.getValue() > tym) {
            okno.mocSlider.setValue(tym);
        } else if (okno.mocSlider.getValue() == tym) {
            okno.mocLabel.setForeground(Color.red);
        } else {
            okno.mocLabel.setForeground(Color.white);
        }
        ele.setMocChwilowa(okno.mocSlider.getValue() * ele.getMocMaksymalna() / 100);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == okno.mocSlider) {
            ele.setMocChwilowa(okno.mocSlider.getValue() * ele.getMocMaksymalna() / 100);
            int tym = ele.getLiczbaPracownikow() * 100 / ele.getLiczbaBlokow();
            if (okno.mocSlider.getValue() > tym) {
                okno.mocSlider.setValue(tym);
            } else if (okno.mocSlider.getValue() == tym) {
                okno.mocLabel.setForeground(Color.red);
            } else {
                okno.mocLabel.setForeground(Color.white);
            }
        }
        if (e.getSource() == okno.kiedySlider) {
            ele.setKiedyDokupic(okno.kiedySlider.getValue());
        }
        okno.stateChanged(e);
    }
}
