package com.practica.cajanegra;

import com.cajanegra.EmptyCollectionException;
import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.*;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;


import java.util.NoSuchElementException;

public class removeLastTest {
    private static SingleLinkedListImpl<Character> miLista=null;
    private static SingleLinkedListImpl<Character> listaVacia;

    @BeforeEach
    public void setUp(){
        miLista = new SingleLinkedListImpl<Character>('A','B','C','F','L','L','Y','Z');
        listaVacia = new SingleLinkedListImpl<Character>();
    }

    @DisplayName("Caso de prueba con lista vacía")
    @Test
    public void removeLastCP1(){
        Assertions.assertThrows(EmptyCollectionException.class, () ->{
            listaVacia.removeLast('A');
        });
    }

    @DisplayName("Caso de prueba 2. El elemento no se encuentra en la lista")
    @Test
    public void removeLastCP2(){
        Assertions.assertThrows(NoSuchElementException.class, () ->{
            miLista.removeLast('G');
        });
    }

    @DisplayName("Caso de prueba 3, Eliminar el primer elemento de la lista")
    @Test
    public void removeLastCP3() throws EmptyCollectionException {
        SingleLinkedListImpl<Character> listaEsperada = new SingleLinkedListImpl<Character>('B','C','F','L','L','Y','Z');
        Character elem =miLista.removeLast('A');
        Assert.assertTrue(elem.equals('A'));
        Assert.assertEquals(listaEsperada.toString(),miLista.toString());
    }

    @DisplayName("Caso de prueba 4, Eliminar el segundo elemento de la lista")
    @Test
    public void removeLastCP4() throws EmptyCollectionException{
        SingleLinkedListImpl<Character> listaEsperada = new SingleLinkedListImpl<Character>('A','C','F','L','L','Y',
                'Z');
        Character elem =miLista.removeLast('B');
        Assert.assertTrue(elem.equals('B'));
        Assert.assertEquals(listaEsperada.toString(),miLista.toString());
    }

    @DisplayName("Caso de prueba 5, eliminar elemento medio de la lista")
    @Test
    public void removeLastCP5() throws EmptyCollectionException{
        SingleLinkedListImpl<Character> listaEsperada = new SingleLinkedListImpl<Character>('A','B','C','L','L','Y',
                'Z');
        Character elem =miLista.removeLast('F');
        Assert.assertTrue(elem.equals('F'));
        Assert.assertEquals(listaEsperada.toString(),miLista.toString());
    }

    @DisplayName("Caso de prueba 6, eliminamos el penúltimo elemento de la lista")
    @Test
    public void removeLastCP6() throws EmptyCollectionException{
        SingleLinkedListImpl<Character> listaEsperada = new SingleLinkedListImpl<Character>('A','B','C','F','L','L',
                'Z');
        Character elem =miLista.removeLast('Y');
        Assert.assertTrue(elem.equals('Y'));
        Assert.assertEquals(listaEsperada.toString(),miLista.toString());
    }

    @DisplayName("Caso de prueba 7, eliminamos el último elemento de la lista")
    @Test
    public void removeLastCP7() throws EmptyCollectionException{
        SingleLinkedListImpl<Character> listaEsperada = new SingleLinkedListImpl<Character>('A','B','C','F','L','L','Y');
        Character elem =miLista.removeLast('Z');
        Assert.assertTrue(elem.equals('Z'));
        Assert.assertEquals(listaEsperada.toString(),miLista.toString());
    }

    @DisplayName("Caso de prueba 8, pasar como argumento un valor invalido")
    @Test
    public void removeLastCP8(){
        Assertions.assertThrows(Exception.class, () ->{
            miLista.removeLast('@');
        });
    }
    @DisplayName("Caso de prueba 9, pasar como argumento un valor invalido")
    @Test
    public void removeLastCP9(){
        Assertions.assertThrows(Exception.class, () ->{
            miLista.removeLast('[');
        });
    }


   /*@DisplayName("Caso de prueba 10, pasar como argumento un valor entero")
    @Test
    public void removeLastCP10() {
        Assertions.assertThrows(Exception.class, () ->{
            miLista.removeLast(10);
        });
    }*/





}
