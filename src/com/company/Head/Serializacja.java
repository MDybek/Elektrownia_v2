package com.company.Head;

import com.company.GUI.Kafelek;

import java.io.*;
import java.util.ArrayList;

public class Serializacja {

    public void zapis(ArrayList<Kafelek> listaPrzyciskow) {
        try(ObjectOutputStream so = new ObjectOutputStream(new FileOutputStream("ElektrownieGracza.ser"))) {

            so.writeObject(listaPrzyciskow);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Kafelek> odczyt() {


        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("ElektrownieGracza.ser"))) {

            Object obj1 = is.readObject();
            is.close();
            return (ArrayList<Kafelek>) obj1;

        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }

    public void zapisStanuKonta(float stan) {
        try(ObjectOutputStream so = new ObjectOutputStream(new FileOutputStream("StanKontaGracza.ser"))) {
            so.writeObject(stan);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public float odczytStanuKonta() {
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("StanKontaGracza.ser"))) {

            Object obj1 = is.readObject();
            is.close();
            return (float) obj1;

        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }
    public void zapisDni(int dni){
        try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("dni.ser"))){
            os.writeObject(dni);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int odczytDni(){
        try(ObjectInputStream is = new ObjectInputStream(new FileInputStream("dni.ser"))){
            Object obt = is.readObject();
            is.close();
            return (int)obt;

        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
            return 0;
        }
    }
}

