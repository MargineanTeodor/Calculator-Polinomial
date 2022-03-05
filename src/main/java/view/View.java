package view;
import controller.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class View {
    private JLabel label;
    private JTextField textField;
    private JTextField textField2;
    private JLabel label2;
    private JButton adunare;
    private JButton scadere;
    private JButton inmultire;
    private JButton impartire;
    private JButton derivare;
    private JButton integrare;
    private JTextArea textArea;
    private JTextArea textArea2;
    private JLabel Label1;
    private JLabel Label2;

    public View() {
        JFrame frame = new JFrame ();
        label= new JLabel ();
        textField = new JTextField ();
        textField2 = new JTextField ();
        label2 = new JLabel ();
        adunare = new JButton ();
        impartire = new JButton ();
        scadere= new JButton ();
        inmultire = new JButton ();
        derivare = new JButton ();
        integrare = new JButton ();
        textArea = new JTextArea ();
        textArea2 = new JTextArea ();
        Label1 = new JLabel ();
        Label2 = new JLabel ();
        inmultire.setText("x");
        ControllerInmultire controllerInmultire= new ControllerInmultire(this);
        inmultire.addActionListener(controllerInmultire);
        adunare.setText("+");
        ControllerAdunare controllerAdunare=new ControllerAdunare(this);
        adunare.addActionListener(controllerAdunare);
        scadere.setText("-");
        ControllerScadere controllerScadere=new ControllerScadere(this);
        scadere.addActionListener(controllerScadere);
        impartire.setText("/");
        ControllerImpartire controllerImpartire= new ControllerImpartire(this );
        impartire.addActionListener(controllerImpartire);
        derivare.setText("drv");
        ControllerDerivare controllerDerivare= new ControllerDerivare(this);
        derivare.addActionListener(controllerDerivare);
        integrare.setText("intg");
        ControllerIntegrare controllerIntegrare= new ControllerIntegrare(this);
        integrare.addActionListener(controllerIntegrare);
        frame.setPreferredSize (new Dimension (378, 470));
        frame.setLayout (null);
        frame.add (label);
        frame.add (textField);
        frame.add (textField2);
        frame.add (label2);
        frame.add (adunare);
        frame.add (scadere);
        frame.add (inmultire);
        frame.add (impartire);
        frame.add (derivare);
        frame.add (integrare);
        frame.add (textArea);
        frame.add (textArea2);
        frame.add (Label1);
        frame.add (Label2);
        label.setText("Rezultat:");
        label2.setText("auxiliar:");
        Label1.setText("polinom1:");
        Label2.setText("polinom2:");
        label.setBounds (15, 40, 100, 25);
        textField.setBounds (100, 40, 225, 25);
        textField2.setBounds (100, 85, 225, 25);
        label2.setBounds (15, 85, 100, 25);
        scadere.setBounds (80, 150, 100, 25);
        adunare.setBounds (80, 185, 100, 25);
        impartire.setBounds (210, 185, 100, 25);
        derivare.setBounds (210, 150, 100, 25);
        integrare.setBounds (80, 225, 100, 25);
        inmultire.setBounds (210, 225, 100, 25);
        textArea.setBounds (100, 275, 225, 25);
        textArea2.setBounds (100, 320, 225, 25);
        Label1.setBounds (15, 275, 100, 25);
        Label2.setBounds (15, 320, 100, 25);
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible (true);
    }
    public String getPoli1(){
        return textArea.getText();
    }
    public String getPoli2(){
        return textArea2.getText();
    }
    public void setRezultat(String s)
    {
        textField.setText(s);
    }
    public void setRezultatCat(String s)
    {
        textField2.setText(s);
    }

    public static void main (String[] args) {
       View viz= new View();
    }
}
