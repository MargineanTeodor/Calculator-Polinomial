package controller;

import model.Polinom;
import view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static model.Operatii.integrare;
import static model.Polinom.regex;

public class ControllerIntegrare implements ActionListener {
    private View view;

    public ControllerIntegrare(View v){
        this.view = v;
    }
    public void actionPerformed(ActionEvent e) {
        String S;
        S=view.getPoli1();
        Polinom A=new Polinom();
        A=regex(S);
        S=view.getPoli2();
        Polinom B=new Polinom();
        B=regex(S);
        A=integrare(A);
        B=integrare(B);
        S=A.toString();
        view.setRezultat(S);
        S=B.toString();
        view.setRezultatCat(S);
    }
}
