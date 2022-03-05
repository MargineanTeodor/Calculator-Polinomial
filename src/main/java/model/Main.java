package model;
import java.util.ArrayList;

import static model.Operatii.*;
import static model.Polinom.regex;

public class Main {
    public static void main(String[] args)
    {
        ArrayList<Monome> pli= new ArrayList<>();
        Monome m1=new Monome(1,1);
        Monome m2= new Monome(1,2);//b
        pli.add(m1);
        pli.add(m2);
        Polinom polin= new Polinom(pli);
        System.out.println(polin.toString());
        ArrayList<Monome> pli2= new ArrayList<>();
        Monome m3=new Monome(1,1);
        Monome m4= new Monome(1,2); // a
        pli2.add(m3);
        pli2.add(m4);
        Polinom polin2= new Polinom(pli2);
        System.out.println(polin2.toString());
        polin2=adunare(polin2,polin);
        System.out.println(polin2.toString());
        polin2=regex("3x^2-2x^1");
        System.out.println(polin2.toString());
    }
}
