package com.practica.cajanegra;

import com.cajanegra.SingleLinkedListImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Extras {
    private static SingleLinkedListImpl<String> miLista=null;
    private static SingleLinkedListImpl<String> listaVacia;
    private static SingleLinkedListImpl<String> unElemento;
    @BeforeAll
    public static void setUp() {
        miLista = new SingleLinkedListImpl<String>("A","B","X","Z","L","A","H");
        unElemento = new SingleLinkedListImpl<String>("G");
        listaVacia = new SingleLinkedListImpl<String>();
    }

    @Test
    public void testToString(){
        assertEquals("[]",listaVacia.toString());
        assertEquals("[G]",unElemento.toString());
        assertEquals("[A, B, X, Z, L, A, H]",miLista.toString());
    }

    @Test
    public void testSize(){
        assertEquals(0,listaVacia.size());
        assertEquals(1,unElemento.size());
        assertEquals(7,miLista.size());
    }
    @Test
    public void testReverse(){
        SingleLinkedListImpl pares = new SingleLinkedListImpl<String>("A","B","X","L","A","H");
        assertEquals("[]",listaVacia.reverse().toString());
        assertEquals("[G]",unElemento.reverse().toString());
        assertEquals("[H, A, L, Z, X, B, A]",miLista.reverse().toString());
        assertEquals("[H, A, L, X, B, A]",pares.reverse().toString());
    }
    @Test
    public void testIsSublist(){
        SingleLinkedListImpl sublista = new SingleLinkedListImpl<String>("L","A","H");
        assertEquals(0,miLista.isSubList(listaVacia));
        assertEquals(5,miLista.isSubList(sublista));
        assertEquals(1,miLista.isSubList(miLista));
        assertEquals(-1,sublista.isSubList(miLista));
    }
    @Test
    public void testIsSublistVacia(){
        assertEquals(0,listaVacia.isSubList(listaVacia));
        assertEquals(-1,listaVacia.isSubList(miLista));
    }
    @Test
    public void testgetAtPos(){
        assertThrows(IllegalArgumentException.class,()->{listaVacia.getAtPos(0);});
        assertThrows(IllegalArgumentException.class,()->{listaVacia.getAtPos(1);});
        assertThrows(IllegalArgumentException.class,()->{listaVacia.getAtPos(2);});
        assertThrows(IllegalArgumentException.class,()->{listaVacia.getAtPos(4);});
        assertThrows(IllegalArgumentException.class,()->{listaVacia.getAtPos(6);});
        assertThrows(IllegalArgumentException.class,()->{listaVacia.getAtPos(7);});
        assertThrows(IllegalArgumentException.class,()->{listaVacia.getAtPos(8);});
        assertThrows(IllegalArgumentException.class,()->{miLista.getAtPos(0);});
        assertEquals('A',miLista.getAtPos(1));
        assertEquals('B',miLista.getAtPos(2));
        assertEquals('Z',miLista.getAtPos(4));
        assertEquals('A',miLista.getAtPos(6));
        assertEquals('H',miLista.getAtPos(7));
        assertThrows(IllegalArgumentException.class,()->{miLista.getAtPos(8);});

    }

}
