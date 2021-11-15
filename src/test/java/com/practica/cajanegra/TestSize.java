package com.practica.cajanegra;

import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSize {
    @Test
    void TestSizeCP1(){
    SingleLinkedListImpl listaVacia = new SingleLinkedListImpl();
    assertEquals(0,listaVacia.size());
    }
    @Test
    void TestsizeCP2(){
        SingleLinkedListImpl lista1Elemento = new SingleLinkedListImpl('A');
        assertEquals(1,lista1Elemento.size());
    }
    @Test
    void TestSizeCP3(){
        SingleLinkedListImpl listaElementos = new SingleLinkedListImpl('A','B','C');
        assertEquals(3,listaElementos.size());
    }
}
