package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.*;
public class Operatii {
    public static Polinom adunare(Polinom A, Polinom B) {
        A.setVizitate();
        B.setVizitate();
        ArrayList<Monome> lista = new ArrayList<>();
        Monome Mn = new Monome(0, 0);
        for (Monome e : A.getPoli()) {
            for (Monome e2 : B.getPoli()) {
                if (e.getPutere() == e2.getPutere()) {
                    e.setVizita(1);
                    e2.setVizita(1);
                    Mn.setCoeficeient(e.getCoeficeient() + e2.getCoeficeient());
                    Mn.setPutere(e.getPutere());
                    lista.add(Mn);
                    Mn = new Monome(0, 0);
                }
            }
        }
        for (Monome e : A.getPoli()) {
            if (e.getVizita() == 0)
                lista.add(e);
        }
        for (Monome e : B.getPoli()) {
            if (e.getVizita() == 0)
                lista.add(e);
        }
        Polinom C = new Polinom(lista);
        C.sortare();
        return C;
    }

    public static Polinom scadere(Polinom A, Polinom B) {
        A.setVizitate();
        B.setVizitate();
        ArrayList<Monome> lista = new ArrayList<>();
        Monome Mn = new Monome(0, 0);
        for (Monome e : A.getPoli()) {
            for (Monome e2 : B.getPoli()) {
                if (e.getPutere() == e2.getPutere()) {
                    e.setVizita(1);
                    e2.setVizita(1);
                    Mn.setCoeficeient(e.getCoeficeient() - e2.getCoeficeient());
                    Mn.setPutere(e.getPutere());
                    lista.add(Mn);
                    Mn = new Monome(0, 0);
                }
            }
        }
        for (Monome e : A.getPoli()) {
            if (e.getVizita() == 0) {
                e.setCoeficeient(-1 * e.getCoeficeient());
                lista.add(e);
            }
        }
        for (Monome e : B.getPoli()) {
            if (e.getVizita() == 0) {
                e.setCoeficeient(e.getCoeficeient());
                lista.add(e);
            }
        }
        Polinom C = new Polinom(lista);
        C.sortare();
        return C;
    }

    public static Polinom inmultire(Polinom A, Polinom B) {
        A.setVizitate();
        B.setVizitate();
        ArrayList<Monome> lista = new ArrayList<>();
        for (Monome e : A.getPoli()) {
            for (Monome e2 : B.getPoli()) {
                Monome Mn = new Monome(e2.getCoeficeient() * e.getCoeficeient(), e2.getPutere() + e.getPutere());
                lista.add(Mn);
            }
        }
        Polinom C = new Polinom(lista);
        C.duplicitate();
        C.sortare();
        return C;
    }

    public static Polinom derivare(Polinom A) {
        A.setVizitate();
        ArrayList<Monome> lista = new ArrayList<>();
        Monome Mn = new Monome(0, 0);
        for (Monome e : A.getPoli()) {
            Mn = new Monome(e.getCoeficeient() * e.getPutere(), e.getPutere() - 1);
            lista.add(Mn);
        }
        Polinom C = new Polinom(lista);
        C.sortare();
        return C;
    }

    public static Polinom integrare(Polinom A) {
        A.setVizitate();
        ArrayList<Monome> lista = new ArrayList<>();
        Monome Mn = new Monome(0, 0);
        for (Monome e : A.getPoli()) {
            Mn = new Monome(e.getCoeficeient() / (e.getPutere() + 1), e.getPutere() + 1);
            lista.add(Mn);
            Mn = new Monome(0, 0);
        }
        Polinom C = new Polinom(lista);
        C.sortare();
        return C;
    }

    public static void impartire(Polinom A, Polinom B) {
        A.sortare();
        B.sortare();
        Polinom p;
        Polinom q;
        Polinom z = new Polinom();
        if (A.getPoli().get(0).getPutere() >= B.getPoli().get(0).getPutere()) {
            p = A;
            q = B;
        } else {
            p = B;
            q = A; // p are grad mai mare decat q
        }
        Monome mn= new Monome(0,0);
        Monome mn2=new Monome(0,0);
        Monome mn3=new Monome (0,0);
        ArrayList<Monome> lista =  new ArrayList<>();
        mn=p.getPoli().get(0);
        mn2=q.getPoli().get(0);
        while(mn.getPutere()>mn2.getPutere() || (mn.getPutere()==mn2.getPutere() &&mn.getCoeficeient()>mn2.getCoeficeient()))
        {
            mn3.setCoeficeient(mn.getCoeficeient()/mn2.getCoeficeient());
            mn3.setPutere((mn.getPutere()-mn2.getPutere()));
            lista.add(mn3);
            A=new Polinom(lista);
            mn3=new Monome(0,0);
            B=inmultire(A,q);
            p=scadere(p,B);
        }
        A=new Polinom(lista);
        B=q;
    }
}

