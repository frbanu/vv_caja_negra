package com.practica.cajanegra;

import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestToString {
    @Test
    void testToStringCP1(){
        SingleLinkedListImpl listaVacia = new SingleLinkedListImpl();
        assertEquals("[]",listaVacia.toString());
    }
    @Test
    void TestToStringCP2(){
        SingleLinkedListImpl lista1Elemento = new SingleLinkedListImpl('A');
        assertEquals("[A]",lista1Elemento.toString());
    }
    @Test
    void TestToStringCP3(){
        SingleLinkedListImpl listaElementos = new SingleLinkedListImpl('A','B','C');
        assertEquals("[A, B, C]",listaElementos.toString());
    }
}
