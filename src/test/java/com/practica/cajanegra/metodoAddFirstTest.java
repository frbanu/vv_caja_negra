package com.practica.cajanegra;
import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class metodoAddFirstTest {
    SingleLinkedListImpl<Character> listaVacia=new SingleLinkedListImpl<Character>();
    SingleLinkedListImpl<Character> listaElementos= new SingleLinkedListImpl<Character>('A','G');
    @DisplayName("Inicialización")
    @BeforeEach
    public void initAddLastTest(){
        SingleLinkedListImpl<Character> listaVacia=new SingleLinkedListImpl<Character>();
        SingleLinkedListImpl<Character> listaElementos= new SingleLinkedListImpl<Character>('A','G');
    }
    @DisplayName("Caso de prueba 1: AddFirst")
    @Test
    public void addLastCP1(){
        listaVacia.addFirst('A');
        assertEquals("[A]",listaVacia.toString());

    }
    @DisplayName("Caso de prueba 2: AddFirst")
    @Test
    public void addLastCP2(){
        listaElementos.addFirst('B');
        assertEquals("[A, G, B]",listaElementos.toString());//CP2
    }
    @DisplayName("Caso de prueba 3: AddFirst")
    @Test
    public void addLastCP3(){
        listaElementos.addFirst('F');
        assertEquals("[A, G, F]",listaElementos.toString());//CP3
    }
    @DisplayName("Caso de prueba 4: AddFirst")
    @Test
    public void addLastCP4(){
        listaElementos.addFirst('X');
        assertEquals("[A, G, X]",listaElementos.toString());//CP4
    }
    @DisplayName("Caso de prueba 5: AddFirst")
    @Test
    public void addLastCP5(){
        listaElementos.addFirst('Z');
        assertEquals("[A, G, Z]",listaElementos.toString());//CP5
    }
    @DisplayName("Caso de prueba 6: AddFirst")
    @Test
    public  void addLastCP6(){
        Exception thrown =
                assertThrows(Exception.class,
                        () ->listaElementos.addFirst('@'),
                        "No lanza excepción con '@'"); //CP6
    }
    @DisplayName("Caso de prueba 7: AddFirst")
    @Test
    public  void addLastCP7(){
        Exception thrown =
                assertThrows(Exception.class,
                        () ->listaElementos.addFirst('['),
                        "No lanza excepción con '['"); //CP7
    }

}
