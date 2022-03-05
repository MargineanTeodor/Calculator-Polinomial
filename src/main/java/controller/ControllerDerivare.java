package controller;

import model.Polinom;
import view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static model.Operatii.derivare;
import static model.Polinom.regex;

public class ControllerDerivare implements ActionListener {
    private View view;

    public ControllerDerivare(View v){
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
        A=derivare(A);
        B=derivare(B);
        S=A.toString();
        view.setRezultat(S);
        S=B.toString();
        view.setRezultatCat(S);
    }
}
