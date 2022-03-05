package testing;

import model.Polinom;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;

import static model.Operatii.*;
import static org.testng.AssertJUnit.assertEquals;

public class Testare {
     Polinom A= new Polinom();
     Polinom B= new Polinom();
     Polinom C= new Polinom();
    /* @BeforeAll
   * public void declarari()
     {
         this.A=Polinom.regex("3x^2+2x^1+1x^0");
         this.B=Polinom.regex("2x^1");
     }*/
    @Test
    public void adunareTest()
    {
        this.A=Polinom.regex("3x^2+2x^1+1x^0");
        this.B=Polinom.regex("2x^1");
        C=adunare(A,B);
        assertEquals("3x^2+4x^1+1x^0+", C.toString());
    }
    @Test
    public void scadereTest()
    {
        this.A=Polinom.regex("3x^2+2x^1+1x^0");
        this.B=Polinom.regex("2x^1");
        C=scadere(B,A);
        assertEquals("3x^2+1x^0+", C.toString());
    }
    @Test
    public void inmultireTest()
    {
        this.A=Polinom.regex("3x^2+2x^1+1x^0");
        this.B=Polinom.regex("2x^1");
        C=inmultire(B,A);
        assertEquals("6x^3+4x^2+2x^1+", C.toString());
    }
    @Test
    public void derivareTest()
    {
        this.A=Polinom.regex("3x^2+2x^1+1x^0");
        C=derivare(A);
        assertEquals("6x^1+2x^0+", C.toString());
    }
    @Test
    public void integrareTest()
    {
        this.A=Polinom.regex("3x^2+2x^1+1x^0");
        C=derivare(A);
        assertEquals("6x^1+2x^0+", C.toString());
    }
}
