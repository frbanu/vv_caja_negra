package com.practica.cajanegra;
import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class metodoAddFirstTest {
    SingleLinkedListImpl<Character> listaVacia=null;
    SingleLinkedListImpl<Character> listaElementos= null;
    @DisplayName("Inicialización")
    @BeforeEach
    void initAddFirstTest(){
        listaVacia=new SingleLinkedListImpl<Character>();
        listaElementos= new SingleLinkedListImpl<Character>('A','G');
    }
    @DisplayName("Caso de prueba 1: AddFirst")
    @Test
    public void addFirstCP1(){
        listaVacia.addFirst('A');
        assertEquals("[A]",listaVacia.toString());

    }
    @DisplayName("Caso de prueba 2: AddFirst")
    @Test
    public void addFirstCP2(){
        listaElementos.addFirst('B');
        assertEquals("[A, G, B]",listaElementos.toString());//CP2
    }
    @DisplayName("Caso de prueba 3: AddFirst")
    @Test
    public void addFirstCP3(){
        listaElementos.addFirst('F');
        assertEquals("[A, G, F]",listaElementos.toString());//CP3
    }
    @DisplayName("Caso de prueba 4: AddFirst")
    @Test
    public void addFirstCP4(){
        listaElementos.addFirst('X');
        assertEquals("[A, G, X]",listaElementos.toString());//CP4
    }
    @DisplayName("Caso de prueba 5: AddFirst")
    @Test
    public void addFirstCP5(){
        listaElementos.addFirst('Z');
        assertEquals("[A, G, Z]",listaElementos.toString());//CP5
    }
    @DisplayName("Caso de prueba 6: AddFirst")
    @Test
    public  void addFirstCP6(){
        Exception thrown =
                assertThrows(Exception.class,
                        () ->listaElementos.addFirst('@'),
                        "No lanza excepción con '@'"); //CP6
    }
    @DisplayName("Caso de prueba 7: AddFirst")
    @Test
    public  void addFirstCP7(){
        Exception thrown =
                assertThrows(Exception.class,
                        () ->listaElementos.addFirst('['),
                        "No lanza excepción con '['"); //CP7
    }

}
