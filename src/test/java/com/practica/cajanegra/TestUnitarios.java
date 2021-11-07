package com.practica.cajanegra;

import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestUnitarios {
    private static SingleLinkedListImpl<String> miLista=null;
    private static SingleLinkedListImpl<String> listaVacia;
    @BeforeAll
    public static void setUp() {
        miLista = new SingleLinkedListImpl<String>("A","B","X","Z","L","A","H");
        listaVacia = new SingleLinkedListImpl<String>();
    }
   /* @Test
    public void testIndexOfPrueba() {
        assertEquals(1,miLista.indexOf("A"));
        assertThrows(NoSuchElementException.class,() -> {listaVacia.indexOf("A");});
    }*/
    @ParameterizedTest
    @CsvSource({"A,1", "B,2","L,5","X,3","Z,4"})
    public void testIndexOfContenido(String input, int expected){
        assertEquals(expected, miLista.indexOf(input));
    }
    @ParameterizedTest
    @CsvSource({"@","[","15"})
    public void testIndexOfException(String input){
        assertThrows(NoSuchElementException.class,() -> {miLista.indexOf(input);});
    }
    @ParameterizedTest
    @CsvSource({"@","A","B","L","X","Z","[","15"})
    public void testIndexOfVacia(String input){
        assertThrows(NoSuchElementException.class,() -> {listaVacia.indexOf(input);});
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,4,6,7,8})
    public void testGetAtPosVacio(int pos){
        assertThrows(IllegalArgumentException.class,()->{listaVacia.getAtPos(pos);});
    }

    @ParameterizedTest
    @CsvSource({"1,A","2,B","4,Z","6,A","7,H"})
    public void testGetAtValido(int pos,String elem){
        assertEquals(elem,miLista.getAtPos(pos));
    }
    @Test
    public void testGetAtInvalido(){
        assertThrows(IllegalArgumentException.class,()->{miLista.getAtPos(0);});
        assertThrows(IllegalArgumentException.class,()->{miLista.getAtPos(8);});
    }

}
