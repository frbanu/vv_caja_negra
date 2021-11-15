package com.practica.cajanegra;
import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class metodoAddNTimes {
    SingleLinkedListImpl<Character> listaElementos= new SingleLinkedListImpl<Character>('A','G');
    @DisplayName("Inicialización")
    @BeforeEach
    public void initAddNTimesTest(){
        listaElementos= new SingleLinkedListImpl<Character>('A','G');
    }
    @DisplayName("Caso de prueba 1: AddNTimes")
    @Test
    public void addNTimesCP1(){
        listaElementos.addNTimes('A', 2);
        assertEquals("[A, G, A, A]",listaElementos.toString());
    }
    @DisplayName("Caso de prueba 2: AddNTimes")
    @Test
    public void addNTimesCP2(){
        listaElementos.addNTimes('B', 2);
        assertEquals("[A, G, B, B]",listaElementos.toString());
    }
    @DisplayName("Caso de prueba 3: AddNTimes")
    @Test
    public void addNTimesCP3(){
        listaElementos.addNTimes('P', 0);
        assertEquals("[A, G]",listaElementos.toString());
    }
    @DisplayName("Caso de prueba 4: AddNTimes")
    @Test
    public void addNTimesCP4(){
        listaElementos.addNTimes('Y', 2);
        assertEquals("[A, G, Y, Y]",listaElementos.toString());
    }
    @DisplayName("Caso de prueba 5: AddNTimes")
    @Test
    public void addNTimesCP5(){
        listaElementos.addNTimes('Z', 2);
        assertEquals("[A, G, Z, Z]",listaElementos.toString());
    }
    @DisplayName("Caso de prueba 6: AddNTimes")
    @Test
    public void addNTimesCP6(){
        Exception thrown =
                assertThrows(Exception.class,
                        () ->listaElementos.addNTimes('A',-1),
                        "No lanza excepción con n=-1");
    }
    @DisplayName("Caso de prueba 7: AddNTimes")
    @Test
    public void addNTimesCP7(){
        Exception thrown =
                assertThrows(Exception.class,
                        () ->listaElementos.addNTimes('@',2),
                        "No lanza excepción con '@'");
    }
    @DisplayName("Caso de prueba 8: AddNTimes")
    @Test
    public void addNTimesCP8(){
        Exception thrown =
                assertThrows(Exception.class,
                        () ->listaElementos.addNTimes('[',2),
                        "No lanza excepción con '['");
    }
/*   @DisplayName("Caso de prueba 9: AddNTimes")
    @Test
    public void addNTimesCP9(){
        Exception thrown =
                assertThrows(Exception.class,
                        () ->listaElementos.addNTimes(9$,2));
    }*/
}
