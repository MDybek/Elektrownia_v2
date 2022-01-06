package com.company.Head;

import com.company.Elektrownie.*;
import com.company.GUI.Kafelek;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Gracz implements Serializable {
    public static float balans;
    private ArrayList <Kafelek> listaElektrowni;
    private static final long serialVersionUID = 1L;
    ListyElektrowni listyElektrowni = new ListyElektrowni();

    public Gracz() {
        balans = 1000000f;
        listaElektrowni = new ArrayList<>();
        for (Elektrownia e : listyElektrowni.elektrownie){
            listaElektrowni.add(new Kafelek(e));
        }
    }


    public void sprzedazElektrowni(int nrEle,int indeks,Elektrownia e) {
        listaElektrowni.set(nrEle*5+indeks, null);
    }

    public float getBalans() {
        return balans;
    }

    public void setBalans(float balans) {
        this.balans = balans;
    }

    public ArrayList<Kafelek> getListaPrzyciskow() {
        return listaElektrowni;
    }

    public void setListaPrzyciskow(ArrayList<Kafelek> listaElektrowni) {
        this.listaElektrowni = listaElektrowni;
    }

    public void odejmijBalans(float x) {this.balans -= x;}

    public void dodajBalans(float x) {this.balans += x;}
}