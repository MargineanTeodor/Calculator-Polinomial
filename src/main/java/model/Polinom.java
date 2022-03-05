package model;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.regex.*;
public class Polinom {
    private ArrayList<Monome> poli;
    public ArrayList<Monome> getPoli() {
        return poli;
    }
    public void setPoli(ArrayList<Monome> poli) {
        this.poli = poli;
    }
    @Override
    public String toString() {
        String s = "";
        for(Monome e: poli)
        {
           if(e.getCoeficeient()>0)
               s=e.toString() + "+"+s;
           if(e.getCoeficeient()<0)
               s=s + e.toString();
        };
        return s;
    }
    public Polinom() {
        this.poli = new ArrayList<Monome>();
    }
    public Polinom(ArrayList<Monome> lista) {
        this.poli = lista;
    }
    public void setVizitate() {
        for (Monome e:this.poli) {
            e.setVizita(0);
        }
    }
    public void sortare() {
        for(Monome e:this.getPoli())
        {
            for(Monome e2: this.getPoli())
                if(e.getPutere()<e2.getPutere()) {
                    Monome mn = new Monome(e.getCoeficeient(), e.getPutere());
                    e.setCoeficeient(e2.getCoeficeient());
                    e.setPutere(e2.getPutere());
                    e2.setCoeficeient(mn.getCoeficeient());
                    e2.setPutere(mn.getPutere());
                }
        }
    }
    public void duplicitate() {
        this.setVizitate();
        for (Monome e: this.getPoli()) {
            for(Monome e2:this.getPoli()){
                if(e.getPutere()==e2.getPutere() && e.getVizita()==0 && this.getPoli().indexOf(e)!=this.getPoli().indexOf(e2)) {
                    e.setVizita(1);
                    e2.setVizita(1);
                    e.setCoeficeient(e.getCoeficeient() + e2.getCoeficeient());
                    e2.setCoeficeient(0);
                }
            }
        }
    }
    private static int coeficeientInt(@NotNull String s){
        String[] var = s.split("x");
        int coef = Integer.parseInt(var[0]);
        return coef;
    }
    private static int putereInt(@NotNull String s){
        String[] var = s.split("\\^");
        int putere = Integer.parseInt(var[1]);
        return putere;
    }
    public static @NotNull Polinom regex(String exp){
        Polinom A = new Polinom();
        Pattern pattern= Pattern.compile("([+-]?(?:(?:\\d+x\\^\\d+)|(?:\\d+x)|(?:\\d+)|(?:x)))");
        Matcher matcher = pattern.matcher(exp);
        ArrayList<Monome> polinomu=new ArrayList<>();
        while (matcher.find()) {
            Monome mn = new Monome(coeficeientInt(matcher.group(1)), putereInt(matcher.group(1)));
            polinomu.add(mn);
            mn=new Monome(0,0);
        }
        A.setPoli(polinomu);
        return A;

    }
}
