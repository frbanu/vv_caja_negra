package com.practica.cajanegra;

import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestAddAtPos {
    private static SingleLinkedListImpl<Character> listaElementos=null;
    private static SingleLinkedListImpl<Character> listaVacia= new SingleLinkedListImpl<>();
    @BeforeEach
    void setUp(){
        listaElementos = new SingleLinkedListImpl<Character>('A','B','C','D','E');
    }
    @ParameterizedTest
    @ValueSource(chars={'@','A','B','G','Y','Z','['/*,'43'*/})//Casos de prueba 1-8 en orden.
    void testAddAtPos0(Character t){
        assertThrows(IllegalArgumentException.class,()->{listaElementos.addAtPos(t,0);});
    }
    @ParameterizedTest
    @ValueSource(chars={'@','A','B','G','Y','Z','['/*,'43'*/})//Casos de prueba 9-16 en orden.
    void testAddAtPos1(Character t){
        listaElementos.addAtPos(t,1);
        assertEquals("["+t+", A, B, C, D, E]",listaElementos.toString());
    }
    @ParameterizedTest
    @ValueSource(chars={'@','A','B','G','Y','Z','['/*,'43'*/})//Casos de prueba 17-24 en orden.
    void testAddAtPos2(Character t){
        listaElementos.addAtPos(t,2);
        assertEquals("[A, "+t+", B, C, D, E]",listaElementos.toString());
    }
    @ParameterizedTest
    @ValueSource(chars={'@','A','B','G','Y','Z','['/*',43'*/})//Casos de prueba 25-32 en orden.
    void testAddAtPos3(Character t){
        listaElementos.addAtPos(t,3);
        assertEquals("[A, B, "+t+", C, D, E]",listaElementos.toString());
    }
    @ParameterizedTest
    @ValueSource(chars={'@','A','B','G','Y','Z','['/*',43'*/})//Casos de prueba 33-40 en orden.
    void testAddAtPos4(Character t){
        listaElementos.addAtPos(t,4);
        assertEquals("[A, B, C, "+t+", D, E]",listaElementos.toString());
    }
    @ParameterizedTest
    @ValueSource(chars={'@','A','B','G','Y','Z','['/*',43'*/})//Casos de prueba 41-48 en orden.
    void testAddAtPos5(Character t){
        listaElementos.addAtPos(t,5);
        assertEquals("[A, B, C, D, "+t+", E]",listaElementos.toString());
    }
    @ParameterizedTest
    @ValueSource(chars={'@','A','B','G','Y','Z','['/*',43'*/})//Casos de prueba 49-56 en orden.
    void testAddAtPos8(Character t){
        listaElementos.addAtPos(t,8);
        assertEquals("[A, B, C, D, E, "+t+"]",listaElementos.toString());
    }
    @Test
    void testAddAtPosVacia(){ //Caso de prueba 57 con lista vacía
        listaVacia.addAtPos('B',3);
        assertEquals("[B]",listaVacia.toString());
    }



}
