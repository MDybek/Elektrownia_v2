package com.company.GUI;

import com.company.Elektrownie.*;

import javax.swing.*;

public class dodajElektrownie {
    ListyDystrybutorzy dystrybutorzy = new ListyDystrybutorzy();
    ListyWlasciciele wlasciciele = new ListyWlasciciele();
    ListyDostawcy dostawcy = new ListyDostawcy();
    JPanel p = new JPanel();
    dodajElektrownie(String rodzajElektrowni, JPanel panel){
        JTextField nazwaElektrowni = new JTextField(6);
        JTextField miasto = new JTextField(6);
        JTextField mocChwilowa = new JTextField(6);
        JTextField mocMaksymalna = new JTextField(6);
        JTextField liczbaBlokow = new JTextField(6);
        JTextField liczbaPracownikow = new JTextField(6);
        JTextField czyPracuje = new JTextField(6);
        JTextField cenaZakupu = new JTextField(6);
        JTextField cenaSprzedazy = new JTextField(6);
        JTextField cenaBloku = new JTextField(6);
        JTextField kiedyDokupic = new JTextField(6);

        JTextField stanMagazynu = new JTextField(6);
        JTextField pojemnoscMagazynu = new JTextField(6);
        JTextField rodzajPaliwa = new JTextField(6);
        JTextField zuzyciePaliwa = new JTextField(6);
        JTextField liczbaReaktorow = new JTextField(6);
        JTextField zuzycieWody = new JTextField(6);
        JTextField zuzyciepaneli = new JTextField(6);


        p.add(new JLabel("Nazwa elektrowi: "));
        p.add(nazwaElektrowni);
        p.add(new JLabel("Miasto: "));
        p.add(miasto);
        p.add(new JLabel("Moc chwilowa: "));
        p.add(mocChwilowa);
        p.add(new JLabel("Moc maksymalna: "));
        p.add(mocMaksymalna);
        p.add(new JLabel("Liczba blokow: "));
        p.add(liczbaBlokow);
        p.add(new JLabel("Liczba pracownikow: "));
        p.add(liczbaPracownikow);
        p.add(new JLabel("Czy pracuje: "));
        p.add(czyPracuje);
        p.add(new JLabel("Cena zakupu: "));
        p.add(cenaZakupu);
        p.add(new JLabel("Cena sprzedazy: "));
        p.add(cenaSprzedazy);
        p.add(new JLabel("Cena bloku: "));
        p.add(cenaBloku);
        p.add(new JLabel("Kiedy dokupic: "));
        p.add(kiedyDokupic);


        if(rodzajElektrowni == "atomowa" || rodzajElektrowni == "weglowa" ||rodzajElektrowni == "gazowa"){
            p.add(new JLabel("Stan magazynu: "));
            p.add(stanMagazynu);
            p.add(new JLabel("Pojemnosc magazynu: "));
            p.add(pojemnoscMagazynu);
        }
        if(rodzajElektrowni == "weglowa" ||rodzajElektrowni == "gazowa"){
            p.add(new JLabel("Rodzaj paliwa: "));
            p.add(rodzajPaliwa);
            p.add(new JLabel("Zuzycie paliwa: "));
            p.add(zuzyciePaliwa);
        }
        if(rodzajElektrowni == "atomowa"){
            p.add(new JLabel("Liczba reaktorow: "));
            p.add(liczbaReaktorow);
            p.add(new JLabel("Zuzycie wody: "));
            p.add(zuzycieWody);
        }
        if(rodzajElektrowni == "fotowoltaiczna"){
            p.add(new JLabel("Zuzycie paneli: "));
            p.add(zuzyciepaneli);
        }

        int result = JOptionPane.showConfirmDialog(null, p, "Nowa elektrownia " + rodzajElektrowni, JOptionPane.OK_CANCEL_OPTION);

        if(result == JOptionPane.OK_OPTION){
            if(rodzajElektrowni == "fotowoltaiczna" && !nazwaElektrowni.getText().equals("") && !miasto.getText().equals("") && !mocChwilowa.getText().equals("") && !mocMaksymalna.getText().equals("") && !liczbaBlokow.getText().equals("") && !liczbaPracownikow.getText().equals("") && !czyPracuje.getText().equals("") && !zuzyciepaneli.getText().equals("") && !cenaZakupu.getText().equals("") && !cenaSprzedazy.getText().equals("") && !cenaBloku.getText().equals("") && !kiedyDokupic.getText().equals("")){
                Kafelek newElektrownia = new Kafelek(new ElektrowniaFotowoltaiczna(nazwaElektrowni.getText(), miasto.getText(), Integer.valueOf(mocChwilowa.getText()), Integer.valueOf(mocMaksymalna.getText()), Integer.valueOf(liczbaBlokow.getText()), Integer.valueOf(liczbaPracownikow.getText()), wlasciciele.getWlasciciele().get(3), Boolean.valueOf(czyPracuje.getText()), Integer.valueOf(zuzyciepaneli.getText()), dystrybutorzy.getDystrybutorzyPradu().get(2), Integer.valueOf(cenaZakupu.getText()), Integer.valueOf(cenaSprzedazy.getText()), Integer.valueOf(cenaBloku.getText()),  Integer.valueOf(kiedyDokupic.getText())));
                panel.add(newElektrownia);
            }
            else if (rodzajElektrowni == "atomowa" && !nazwaElektrowni.getText().equals("") && !miasto.getText().equals("") && !mocChwilowa.getText().equals("") && !mocMaksymalna.getText().equals("") && !liczbaBlokow.getText().equals("") && !liczbaPracownikow.getText().equals("") && !liczbaReaktorow.getText().equals("") && !czyPracuje.getText().equals("") && !zuzycieWody.getText().equals("") && !stanMagazynu.getText().equals("") && !pojemnoscMagazynu.getText().equals("") && !cenaZakupu.getText().equals("") && !cenaSprzedazy.getText().equals("") && !cenaBloku.getText().equals("") && !kiedyDokupic.getText().equals("")){
                Kafelek newElektrownia = new Kafelek(new ElektrowniaAtomowa(nazwaElektrowni.getText(), miasto.getText(), Integer.valueOf(mocChwilowa.getText()), Integer.valueOf(mocMaksymalna.getText()), Integer.valueOf(liczbaBlokow.getText()), Integer.valueOf(liczbaPracownikow.getText()), wlasciciele.getWlasciciele().get(0), Boolean.valueOf(czyPracuje.getText()), Integer.valueOf(liczbaReaktorow.getText()), Float.valueOf(zuzycieWody.getText()), dystrybutorzy.getDystrybutorzyPradu().get(0), Integer.valueOf(stanMagazynu.getText()), Integer.valueOf(pojemnoscMagazynu.getText()),dostawcy.odbiocyOdpadow.get(0), Integer.valueOf(cenaZakupu.getText()), Integer.valueOf(cenaSprzedazy.getText()), Integer.valueOf(cenaBloku.getText()),  Integer.valueOf(kiedyDokupic.getText())));
                panel.add(newElektrownia);
            }
            else if (rodzajElektrowni == "weglowa" && !nazwaElektrowni.getText().equals("") && !miasto.getText().equals("") && !mocChwilowa.getText().equals("") && !mocMaksymalna.getText().equals("") && !liczbaBlokow.getText().equals("") && !liczbaPracownikow.getText().equals("") && !czyPracuje.getText().equals("") && !rodzajPaliwa.getText().equals("") && !zuzyciePaliwa.getText().equals("") && !stanMagazynu.getText().equals("") && !pojemnoscMagazynu.getText().equals("") && !cenaZakupu.getText().equals("") && !cenaSprzedazy.getText().equals("") && !cenaBloku.getText().equals("") && !kiedyDokupic.getText().equals("")){
                Kafelek newElektrownia = new Kafelek(new ElektrowniaWeglowa(nazwaElektrowni.getText(), miasto.getText(), Integer.valueOf(mocChwilowa.getText()), Integer.valueOf(mocMaksymalna.getText()), Integer.valueOf(liczbaBlokow.getText()), Integer.valueOf(liczbaPracownikow.getText()), wlasciciele.getWlasciciele().get(0), Boolean.valueOf(czyPracuje.getText()), rodzajPaliwa.getText(), Float.valueOf(zuzyciePaliwa.getText()), dystrybutorzy.getDystrybutorzyPradu().get(0), Integer.valueOf(stanMagazynu.getText()),dostawcy.dostawcyWegla.get(0), Integer.valueOf(pojemnoscMagazynu.getText()), Integer.valueOf(cenaZakupu.getText()), Integer.valueOf(cenaSprzedazy.getText()), Integer.valueOf(cenaBloku.getText()),  Integer.valueOf(kiedyDokupic.getText())));
                panel.add(newElektrownia);
            }
            else if (rodzajElektrowni == "gazowa" && !nazwaElektrowni.getText().equals("") && !miasto.getText().equals("") && !mocChwilowa.getText().equals("") && !mocMaksymalna.getText().equals("") && !liczbaBlokow.getText().equals("") && !liczbaPracownikow.getText().equals("") && !czyPracuje.getText().equals("") && !rodzajPaliwa.getText().equals("") && !zuzyciePaliwa.getText().equals("") && !stanMagazynu.getText().equals("") && !pojemnoscMagazynu.getText().equals("") && !cenaZakupu.getText().equals("") && !cenaSprzedazy.getText().equals("") && !cenaBloku.getText().equals("") && !kiedyDokupic.getText().equals("")){
                Kafelek newElektrownia = new Kafelek(new ElektrowniaGazowa(nazwaElektrowni.getText(), miasto.getText(), Integer.valueOf(mocChwilowa.getText()), Integer.valueOf(mocMaksymalna.getText()), Integer.valueOf(liczbaBlokow.getText()), Integer.valueOf(liczbaPracownikow.getText()), wlasciciele.getWlasciciele().get(0), Boolean.valueOf(czyPracuje.getText()), rodzajPaliwa.getText(), Float.valueOf(zuzyciePaliwa.getText()), dystrybutorzy.getDystrybutorzyPradu().get(0), Integer.valueOf(stanMagazynu.getText()),dostawcy.dostawcyGazu.get(0), Integer.valueOf(pojemnoscMagazynu.getText()), Integer.valueOf(cenaZakupu.getText()), Integer.valueOf(cenaSprzedazy.getText()), Integer.valueOf(cenaBloku.getText()),  Integer.valueOf(kiedyDokupic.getText())));
                panel.add(newElektrownia);
            }
        }
    }
}
