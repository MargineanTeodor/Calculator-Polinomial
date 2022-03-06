package controller;

import model.Polinom;
import view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static model.Operatii.impartire;
import static model.Polinom.regex;

public class ControllerImpartire implements ActionListener {
    private View view;

    public ControllerImpartire(View v){
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
        view.setRezultat(impartire(A,B));
        view.setRezultatCat("");
    }
}
