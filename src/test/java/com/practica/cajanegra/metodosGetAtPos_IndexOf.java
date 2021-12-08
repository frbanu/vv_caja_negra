package com.practica.cajanegra;

import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class metodosGetAtPos_IndexOf {
    private static SingleLinkedListImpl<Character> miLista=null;
    private static SingleLinkedListImpl<Character> listaVacia;
    @BeforeAll
    public static void setUp() {
        miLista = new SingleLinkedListImpl<Character>('A','B','Y','Z','L','A','H');
        listaVacia = new SingleLinkedListImpl<Character>();
    }
    @Test
    public void testGetAtPos(){
        assertThrows(IllegalArgumentException.class,()->{listaVacia.getAtPos(0);}); //Caso de prueba getAtPos 1
        assertThrows(IllegalArgumentException.class,()->{listaVacia.getAtPos(1);}); //Caso de prueba getAtPos 2
        assertThrows(IllegalArgumentException.class,()->{listaVacia.getAtPos(2);}); //Caso de prueba getAtPos 3
        assertThrows(IllegalArgumentException.class,()->{listaVacia.getAtPos(4);}); //Caso de prueba getAtPos 4
        assertThrows(IllegalArgumentException.class,()->{listaVacia.getAtPos(6);}); //Caso de prueba getAtPos 5
        assertThrows(IllegalArgumentException.class,()->{listaVacia.getAtPos(7);}); //Caso de prueba getAtPos 6
        assertThrows(IllegalArgumentException.class,()->{listaVacia.getAtPos(8);}); //Caso de prueba getAtPos 7
        assertThrows(IllegalArgumentException.class,()->{miLista.getAtPos(0);});    //Caso de prueba getAtPos 8
        assertEquals('A',miLista.getAtPos(1));                              //Caso de prueba getAtPos 9
        assertEquals('B',miLista.getAtPos(2));                              //Caso de prueba getAtPos 10
        assertEquals('Z',miLista.getAtPos(4));                              //Caso de prueba getAtPos 11
        assertEquals('A',miLista.getAtPos(6));                              //Caso de prueba getAtPos 12
        assertEquals('H',miLista.getAtPos(7));                              //Caso de prueba getAtPos 13
        assertThrows(IllegalArgumentException.class,()->{miLista.getAtPos(8);});    //Caso de prueba getAtPos 14
    }
    @Test
    public void  testIndexOf(){
        assertThrows(NoSuchElementException.class,()->{listaVacia.indexOf('@');}); //Caso de prueba indexOf 1
        assertThrows(NoSuchElementException.class,()->{listaVacia.indexOf('A');}); //Caso de prueba indexOf 2
        assertThrows(NoSuchElementException.class,()->{listaVacia.indexOf('B');}); //Caso de prueba indexOf 3
        assertThrows(NoSuchElementException.class,()->{listaVacia.indexOf('L');}); //Caso de prueba indexOf 4
        assertThrows(NoSuchElementException.class,()->{listaVacia.indexOf('Y');}); //Caso de prueba indexOf 5
        assertThrows(NoSuchElementException.class,()->{listaVacia.indexOf('Z');}); //Caso de prueba indexOf 5
        assertThrows(NoSuchElementException.class,()->{listaVacia.indexOf('[');}); //Caso de prueba indexOf 7
        assertThrows(NoSuchElementException.class,()->{miLista.indexOf('@');});    //Caso de prueba indexOf 8
        assertEquals(1,miLista.indexOf('A'));                              //Caso de prueba indexOf 9
        assertEquals(2,miLista.indexOf('B'));                              //Caso de prueba indexOf 10
        assertEquals(5,miLista.indexOf('L'));                              //Caso de prueba indexOf 11
        assertEquals(3,miLista.indexOf('Y'));                              //Caso de prueba indexOf 12
        assertEquals(4,miLista.indexOf('Z'));                              //Caso de prueba indexOf 13
        assertThrows(NoSuchElementException.class,()->{miLista.indexOf('[');});    //Caso de prueba indexOf 14
    }


}
