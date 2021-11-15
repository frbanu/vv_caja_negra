package com.practica.cajanegra;

import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class metodoReverseTest {
    SingleLinkedListImpl<Character> listaVacia = null;
    SingleLinkedListImpl<Character> listaElemento = null;
    SingleLinkedListImpl<Character> listaElementosPares = null;
    SingleLinkedListImpl<Character> listaElementosImpares = null;

    @DisplayName("Inicialización")
    @BeforeEach
    void initReverseTest() {
        listaVacia = new SingleLinkedListImpl<Character>();
        listaElemento = new SingleLinkedListImpl<Character>('A');
        listaElementosPares = new SingleLinkedListImpl<Character>('A', 'G');
        listaElementosImpares = new SingleLinkedListImpl<Character>('A', 'G','F');
    }
    @DisplayName("Caso de prueba 1: Reverse")
    @Test
    public void reverseCP1(){
        SingleLinkedListImpl<Character> listaVaciaP = new SingleLinkedListImpl<Character>();
        assertEquals(listaVaciaP.toString() ,listaVacia.reverse().toString());
    }
    @DisplayName("Caso de prueba 2: Reverse")
    @Test
    public void reverseCP2(){
        SingleLinkedListImpl<Character> listaElementoP = new SingleLinkedListImpl<Character>('A');
        assertEquals(listaElementoP.toString(),listaElemento.reverse().toString());
    }
    @DisplayName("Caso de prueba 3: Reverse")
    @Test
    public void reverseCP3(){
        SingleLinkedListImpl<Character> listaElementosParesP = new SingleLinkedListImpl<Character>('G','A');
        assertEquals(listaElementosParesP.toString(),listaElementosPares.reverse().toString());
    }
    @DisplayName("Caso de prueba 4: Reverse")
    @Test
    public void reverseCP4(){
        SingleLinkedListImpl<Character> listaElementosImparesP = new SingleLinkedListImpl<Character>('F','G','A');
        assertEquals(listaElementosImparesP.toString(),listaElementosImpares.reverse().toString());
    }
}
