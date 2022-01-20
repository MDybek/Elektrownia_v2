package com.company.Elektrownie;

import com.company.Head.Wlasciciel;
import com.company.uslugodawcy.DostawcaGazu;
import com.company.uslugodawcy.DostawcaWegla;
import com.company.uslugodawcy.DystrybutorPradu;
import com.company.uslugodawcy.OdbiorcaOdpadow;

import java.io.Serializable;
import java.util.ArrayList;

public class ListyElektrowni implements Serializable {
    ListyDystrybutorzy dystrybutorzy = new ListyDystrybutorzy();
    ListyWlasciciele wlasciciele = new ListyWlasciciele();
    ListyDostawcy dostawcy = new ListyDostawcy();


    public ArrayList<Elektrownia> elektrownie = new ArrayList<>() {
        {
            add(new ElektrowniaAtomowa("Żarnowiec", "Żarnowiec", 0, 1070, 10, 10, wlasciciele.getWlasciciele().get(0), false, 1, 10f, dystrybutorzy.getDystrybutorzyPradu().get(0), 2, 150, dostawcy.odbiocyOdpadow.get(0), 150000, 75000, 75000, 10));
            add(new ElektrowniaAtomowa("Dukovany", "Trebic", 0, 1106, 10, 10, wlasciciele.getWlasciciele().get(0), false, 1, 10f, dystrybutorzy.getDystrybutorzyPradu().get(1), 2, 150, dostawcy.odbiocyOdpadow.get(1), 281250, 140625, 93750, 10));
            add(new ElektrowniaAtomowa("Biełojarsk", "Jekateryburg", 0, 1162, 10, 10, wlasciciele.getWlasciciele().get(0), false, 1, 10f, dystrybutorzy.getDystrybutorzyPradu().get(2), 2, 150, dostawcy.odbiocyOdpadow.get(2), 450000, 225000, 112500, 10));
            add(new ElektrowniaAtomowa("Emsland", "Lingen", 0, 1249, 10, 10, wlasciciele.getWlasciciele().get(0), false, 1, 10f, dystrybutorzy.getDystrybutorzyPradu().get(3), 2, 150, dostawcy.odbiocyOdpadow.get(3), 656250, 328125, 131250, 10));
            add(new ElektrowniaAtomowa("Belleville", "Burgundia", 0, 1368, 10, 10, wlasciciele.getWlasciciele().get(0), false, 1, 10f, dystrybutorzy.getDystrybutorzyPradu().get(4), 2, 150, dostawcy.odbiocyOdpadow.get(4), 900000, 450000, 150000, 10));

            add(new ElektrowniaFotowoltaiczna("Esoleo", "Brudzew", 0, 550, 10, 10, wlasciciele.getWlasciciele().get(3), false, 0, dystrybutorzy.getDystrybutorzyPradu().get(0), 30000, 15000, 15000, 10));
            add(new ElektrowniaFotowoltaiczna("Cez", "Chwaletice", 0, 550, 10, 10, wlasciciele.getWlasciciele().get(3), false, 0, dystrybutorzy.getDystrybutorzyPradu().get(1), 56250, 25000, 18750, 10));
            add(new ElektrowniaFotowoltaiczna("OrskSolar", "Orsk", 0, 550, 10, 10, wlasciciele.getWlasciciele().get(3), false, 0, dystrybutorzy.getDystrybutorzyPradu().get(2), 90000, 45000, 22500,  10));
            add(new ElektrowniaFotowoltaiczna("ENBW", "Werneuchen", 0, 550, 10, 10, wlasciciele.getWlasciciele().get(3), false, 0, dystrybutorzy.getDystrybutorzyPradu().get(3), 131250, 65000, 26250, 10));
            add(new ElektrowniaFotowoltaiczna("FranceSolar", " Toul-Rosi", 0, 550, 10, 10, wlasciciele.getWlasciciele().get(3), false, 0, dystrybutorzy.getDystrybutorzyPradu().get(4), 180000, 90000, 30000, 10));

            add(new ElektrowniaWeglowa("Turów", "Bogatynia", 0, 750, 10, 10, wlasciciele.getWlasciciele().get(0), false, "roksana wegiel", 3f, dystrybutorzy.getDystrybutorzyPradu().get(0), 103, dostawcy.dostawcyWegla.get(0), 190, 50000, 25000, 25000, 10));
            add(new ElektrowniaWeglowa("Dziecmor", "Dziecmor", 0, 750, 10, 10, wlasciciele.getWlasciciele().get(0), false, "roksana wegiel", 3f, dystrybutorzy.getDystrybutorzyPradu().get(1), 103, dostawcy.dostawcyWegla.get(1), 190, 93750, 45500, 31250, 10));
            add(new ElektrowniaWeglowa("Berezowska", "Szarypowo", 0, 750, 10, 10, wlasciciele.getWlasciciele().get(0), false, "roksana wegiel", 3f, dystrybutorzy.getDystrybutorzyPradu().get(2), 103, dostawcy.dostawcyWegla.get(2), 190, 150000, 75000, 37500, 10));
            add(new ElektrowniaWeglowa("Niederaus", "Bergheim", 0, 750, 10, 10, wlasciciele.getWlasciciele().get(0), false, "roksana wegiel", 3f, dystrybutorzy.getDystrybutorzyPradu().get(3), 103, dostawcy.dostawcyWegla.get(3), 190, 218750, 109375, 43750, 10));
            add(new ElektrowniaWeglowa("Belchatow", "Belchatow", 0, 750, 10, 10, wlasciciele.getWlasciciele().get(0), false, "roksana wegiel", 3f, dystrybutorzy.getDystrybutorzyPradu().get(4), 103, dostawcy.dostawcyWegla.get(4), 190, 300000, 150000, 50000, 10));

            add(new ElektrowniaGazowa("Polgazprom", "Dolna Odra", 0, 800, 10, 10, wlasciciele.getWlasciciele().get(0), false, "gaz", 4.75f, dystrybutorzy.getDystrybutorzyPradu().get(0), 123, dostawcy.dostawcyGazu.get(0), 200, 60000, 30000, 30000, 10));
            add(new ElektrowniaGazowa("MelnikGaz", "Pepikovice", 0, 800, 10, 10, wlasciciele.getWlasciciele().get(0), false, "gaz", 4.75f, dystrybutorzy.getDystrybutorzyPradu().get(1), 123, dostawcy.dostawcyGazu.get(1), 200, 112500, 55000, 37500, 10));
            add(new ElektrowniaGazowa("Gazprom", "Kacapowo", 0, 800, 10, 10, wlasciciele.getWlasciciele().get(0), false, "gaz", 4.75f, dystrybutorzy.getDystrybutorzyPradu().get(2), 123, dostawcy.dostawcyGazu.get(2), 200, 180000, 90000, 45000, 10));
            add(new ElektrowniaGazowa("ENBW", "Helmutsdorf", 0, 800, 10, 10, wlasciciele.getWlasciciele().get(0), false, "gaz", 4.75f, dystrybutorzy.getDystrybutorzyPradu().get(3), 123, dostawcy.dostawcyGazu.get(3), 200, 225000, 112000, 52500, 10));
            add(new ElektrowniaGazowa("Centrale", "Reno-Pari", 0, 800, 10, 10, wlasciciele.getWlasciciele().get(0), false, "gaz", 4.75f, dystrybutorzy.getDystrybutorzyPradu().get(4), 123, dostawcy.dostawcyGazu.get(4), 200, 270000, 135000, 60000, 10));
        }
    };
}
