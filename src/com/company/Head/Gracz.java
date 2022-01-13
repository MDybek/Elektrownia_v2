package com.company.Head;

import com.company.Elektrownie.*;
import com.company.GUI.Kafelek;

import java.io.Serializable;
import java.util.ArrayList;


public class Gracz implements Serializable {
    public static float balans;
    private ArrayList <Kafelek> listaPrzyciskow;
    private static final long serialVersionUID = 1L;
    ListyElektrowni listyElektrowni = new ListyElektrowni();

    public Gracz() {
        balans = 100000000f;
        listaPrzyciskow = new ArrayList<>();
        for (Elektrownia e : listyElektrowni.elektrownie){
            listaPrzyciskow.add(new Kafelek(e));
        }
    }
    public Gracz(ArrayList<Kafelek> lista,float Balans){
        balans = Balans;
        listaPrzyciskow = new ArrayList<>();
        setListaPrzyciskow(lista);
    }


    public void sprzedazElektrowni(int nrEle,int indeks,Elektrownia e) {
        listaPrzyciskow.set(nrEle*5+indeks, null);
    }

    public float getBalans() {
        return balans;
    }

    public void setBalans(float balans) {
        this.balans = balans;
    }

    public ArrayList<Kafelek> getListaPrzyciskow() {
        return listaPrzyciskow;
    }

    public void setListaPrzyciskow(ArrayList<Kafelek> listaElektrowni) {
        this.listaPrzyciskow = listaElektrowni;
    }

    public void odejmijBalans(float x) {this.balans -= x;}

    public void dodajBalans(float x) {this.balans += x;}
}