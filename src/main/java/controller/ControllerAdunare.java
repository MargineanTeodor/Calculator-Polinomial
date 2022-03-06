package controller;

import model.Polinom;
import view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static model.Operatii.adunare;
import static model.Polinom.regex;

public class ControllerAdunare implements ActionListener {
    private View view;

    public ControllerAdunare(View v){
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
        A=adunare(A,B);
        S=A.toString();
        view.setRezultat(S);
        view.setRezultatCat("");
    }
}
