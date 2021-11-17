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

    @BeforeAll
    public static void setUp(){
        miLista = new SingleLinkedListImpl<Character>('A','B','X','Z','L','L','A','H');
        listaVacia = new SingleLinkedListImpl<Character>();
        Character[] casosPruebaInvalidos = {'@','['};
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
            miLista.removeLast('C');
        });
    }

    @DisplayName("Caso de prueba 3, Eliminar el primer elemento de la lista")
    @Test
    public void removeLastCP3() throws EmptyCollectionException {
        SingleLinkedListImpl<Character> listaEsperada = new SingleLinkedListImpl<Character>('B','X','Z','L','L','A','H');
        miLista.removeLast('A');
        Assert.assertEquals(listaEsperada,miLista);
    }

    @DisplayName("Caso de prueba 4, Eliminar el segundo elemento de la lista")
    @Test
    public void removeLastCP4() throws EmptyCollectionException{
        SingleLinkedListImpl<Character> listaEsperada = new SingleLinkedListImpl<Character>('A','X','Z','L','L','A','H');
        miLista.removeLast('B');
        Assert.assertEquals(listaEsperada.toString(),miLista.toString());
    }

    @DisplayName("Caso de prueba 5, eliminar elemento medio de la lista")
    @Test
    public void removeLastCP5() throws EmptyCollectionException{
        SingleLinkedListImpl<Character> listaEsperada = new SingleLinkedListImpl<Character>('A','B','X','L','L','A','H');
        miLista.removeLast('Z');
        Assert.assertEquals(listaEsperada.toString(),miLista.toString());
    }

    @DisplayName("Caso de prueba 6, eliminamos el penúltimo elemento de la lista")
    @Test
    public void removeLastCP6() throws EmptyCollectionException{
        SingleLinkedListImpl<Character> listaEsperada = new SingleLinkedListImpl<Character>('A','B','X','Z','L','L','H');
        miLista.removeLast('A');
        Assert.assertEquals(listaEsperada.toString(),miLista.toString());
    }

    @DisplayName("Caso de prueba 7, eliminamos el último elemento de la lista")
    @Test
    public void removeLastCP7() throws EmptyCollectionException{
        SingleLinkedListImpl<Character> listaEsperada = new SingleLinkedListImpl<Character>('A','B','X','Z','L','L','A');
        miLista.removeLast('H');
        Assert.assertEquals(listaEsperada.toString(),miLista.toString());
    }

    @DisplayName("Caso de prueba 8, pasar como argumento un valor invalido")
    @Test
    public void removeLastCP8() throws EmptyCollectionException{
        SingleLinkedListImpl<Character> listaInvalida = new SingleLinkedListImpl<>('@','[');
        SingleLinkedListImpl<Character> listaEsperada = new SingleLinkedListImpl<>('[');
        listaInvalida.removeLast('@');
        Assert.assertEquals(listaEsperada,listaInvalida);
    }





}
