package com.practica.cajanegra;
import com.cajanegra.AbstractSingleLinkedListImpl;
import com.cajanegra.EmptyCollectionException;
import com.cajanegra.SingleLinkedList;
import com.cajanegra.SingleLinkedListImpl;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.omg.CORBA.portable.ApplicationException;
import org.junit.jupiter.api.Assertions;
import java.util.Iterator;

import static org.junit.Assert.*;

public class removeLastNoParameter {
    private static SingleLinkedListImpl<Character> miLista=null;
    private static SingleLinkedListImpl<Character> listaVacia;
    private static SingleLinkedListImpl<Character> unElemento;
    @BeforeAll
    public static void setUp() {
        miLista = new SingleLinkedListImpl<Character>('A','B','X','Z','L','A','H');
        unElemento = new SingleLinkedListImpl<Character>('G');
        listaVacia = new SingleLinkedListImpl<Character>();
    }

    @Test   // caso prueba con lista vacía
    public void removeLastCP1(){
        Assertions.assertThrows(EmptyCollectionException.class, () ->{
            listaVacia.removeLast();
        });
    }
    @Test   // caso prueba lista con un solo elemento
    public void removeLastCP2(){
        Assertions.assertThrows(EmptyCollectionException.class, () ->{
            unElemento.removeLast();
        });
    }
    @Test   // caso prueba lista con más de un elemento
    public void removeLastCP3(){
        Assertions.assertThrows(EmptyCollectionException.class, () ->{
            miLista.removeLast();
        });
    }

}
