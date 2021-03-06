package com.company.Elektrownie;

import com.company.Head.Wlasciciel;
import com.company.uslugodawcy.DostawcaGazu;
import com.company.uslugodawcy.DostawcaWegla;
import com.company.uslugodawcy.OdbiorcaOdpadow;

import java.io.Serializable;
import java.util.ArrayList;

public class ListyDostawcy implements Serializable {

    public ArrayList <DostawcaWegla> dostawcyWegla = new ArrayList<>(){
        {
            add( new DostawcaWegla(1.21f,new Wlasciciel()));
            add( new DostawcaWegla(1.54f,new Wlasciciel()));
            add( new DostawcaWegla(1.91f,new Wlasciciel()));
            add( new DostawcaWegla(2.264f,new Wlasciciel()));
            add( new DostawcaWegla(2.59f,new Wlasciciel()));
        }
    };

    public ArrayList <DostawcaGazu> dostawcyGazu = new ArrayList<>(){
        {
            add( new DostawcaGazu(1,new Wlasciciel()));
            add( new DostawcaGazu(1.16105f,new Wlasciciel()));
            add( new DostawcaGazu(1.35747f,new Wlasciciel()));
            add( new DostawcaGazu(1.53368f,new Wlasciciel()));
            add( new DostawcaGazu(1.69473f,new Wlasciciel()));
        }
    };

    public ArrayList <OdbiorcaOdpadow> odbiocyOdpadow = new ArrayList<>(){
        {
            add( new OdbiorcaOdpadow(3.3f,new Wlasciciel()));
            add( new OdbiorcaOdpadow(3.47f,new Wlasciciel()));
            add( new OdbiorcaOdpadow(3.62f,new Wlasciciel()));
            add( new OdbiorcaOdpadow(3.73f,new Wlasciciel()));
            add( new OdbiorcaOdpadow(3.8f,new Wlasciciel()));
        }
    };

    public void setDostawcyWegla(ArrayList<DostawcaWegla> dostawcyWegla) {
        this.dostawcyWegla = dostawcyWegla;
    }

    public void setDostawcyGazu(ArrayList<DostawcaGazu> dostawcyGazu) {
        this.dostawcyGazu = dostawcyGazu;
    }

    public void setOdbiocyOdpadow(ArrayList<OdbiorcaOdpadow> odbiocyOdpadow) {
        this.odbiocyOdpadow = odbiocyOdpadow;
    }

    public ArrayList<DostawcaWegla> getDostawcyWegla() { return dostawcyWegla; }

    public ArrayList<DostawcaGazu> getDostawcyGazu() { return dostawcyGazu; }

    public ArrayList<OdbiorcaOdpadow> getOdbiocyOdpadow() { return odbiocyOdpadow; }
}
