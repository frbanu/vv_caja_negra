package com.practica.cajanegra;

import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestIsEmpty {
   @Test
    void isEmptyCP1(){
       SingleLinkedListImpl listaVacia = new SingleLinkedListImpl();
       assertEquals(true,listaVacia.isEmpty());
   }
   @Test
    void isEmptyCP2(){
       SingleLinkedListImpl lista1Elemento = new SingleLinkedListImpl('A');
       assertEquals(false,lista1Elemento.isEmpty());
   }
   @Test
    void isEmptyCP3(){
       SingleLinkedListImpl listaElementos = new SingleLinkedListImpl('A','B','C');
       assertEquals(false,listaElementos.isEmpty());
   }
}
