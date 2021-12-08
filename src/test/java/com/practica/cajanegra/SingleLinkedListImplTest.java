package com.practica.cajanegra;

import com.cajanegra.EmptyCollectionException;
import com.cajanegra.SingleLinkedListImpl;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SingleLinkedListImplTest {

    @Nested
    @DisplayName("Add tests")
    public  class AddTests{

        @Nested
        @DisplayName("Test addAtPos()")
        public class TestAddAtPos {
            private SingleLinkedListImpl<Character> listaElementos=null;
            private SingleLinkedListImpl<Character> listaVacia= new SingleLinkedListImpl<>();
            @BeforeEach
            void setUp(){
                listaElementos = new SingleLinkedListImpl<Character>('A','B','C','D','E');
            }
            @DisplayName("Pos:0")
            @ParameterizedTest
            @ValueSource(chars={'@','A','B','G','Y','Z','['/*,'43'*/})//Casos de prueba 1-8 en orden.
            void testAddAtPos0(Character t){
                assertThrows(IllegalArgumentException.class,()->{listaElementos.addAtPos(t,0);});
            }
            @DisplayName("Pos:1")
            @ParameterizedTest
            @ValueSource(chars={'@','A','B','G','Y','Z','['/*,'43'*/})//Casos de prueba 9-16 en orden.
            void testAddAtPos1(Character t){
                listaElementos.addAtPos(t,1);
                assertEquals("["+t+", A, B, C, D, E]",listaElementos.toString());
            }
            @DisplayName("Pos:2")
            @ParameterizedTest
            @ValueSource(chars={'@','A','B','G','Y','Z','['/*,'43'*/})//Casos de prueba 17-24 en orden.
            void testAddAtPos2(Character t){
                listaElementos.addAtPos(t,2);
                assertEquals("[A, "+t+", B, C, D, E]",listaElementos.toString());
            }
            @DisplayName("Pos:3")
            @ParameterizedTest
            @ValueSource(chars={'@','A','B','G','Y','Z','['/*',43'*/})//Casos de prueba 25-32 en orden.
            void testAddAtPos3(Character t){
                listaElementos.addAtPos(t,3);
                assertEquals("[A, B, "+t+", C, D, E]",listaElementos.toString());
            }
            @DisplayName("Pos:4")
            @ParameterizedTest
            @ValueSource(chars={'@','A','B','G','Y','Z','['/*',43'*/})//Casos de prueba 33-40 en orden.
            void testAddAtPos4(Character t){
                listaElementos.addAtPos(t,4);
                assertEquals("[A, B, C, "+t+", D, E]",listaElementos.toString());
            }
            @DisplayName("Pos:5")
            @ParameterizedTest
            @ValueSource(chars={'@','A','B','G','Y','Z','['/*',43'*/})//Casos de prueba 41-48 en orden.
            void testAddAtPos5(Character t){
                listaElementos.addAtPos(t,5);
                assertEquals("[A, B, C, D, "+t+", E]",listaElementos.toString());
            }
            @DisplayName("Pos:8")
            @ParameterizedTest
            @ValueSource(chars={'@','A','B','G','Y','Z','['/*',43'*/})//Casos de prueba 49-56 en orden.
            void testAddAtPos8(Character t){
                listaElementos.addAtPos(t,8);
                assertEquals("[A, B, C, D, E, "+t+"]",listaElementos.toString());
            }
            @Test
            @DisplayName("Empty list test")
            void testAddAtPosVacia(){ //Caso de prueba 57 con lista vacía
                listaVacia.addAtPos('B',3);
                assertEquals("[B]",listaVacia.toString());
            }
        }

        @Nested
        @DisplayName("Test addFirst()")
        public class TestAddFirst{
            private SingleLinkedListImpl<Character> listaVacia=null;
            private SingleLinkedListImpl<Character> listaElementos= null;

            @DisplayName("Inicialización")
            @BeforeEach
            void initAddFirstTest(){
                listaVacia=new SingleLinkedListImpl<Character>();
                listaElementos= new SingleLinkedListImpl<Character>('A','G');
            }

            @DisplayName("Caso de prueba 1: AddFirst")
            @Test
            public void addFirstCP1(){
                listaVacia.addFirst('A');
                assertEquals("[A]",listaVacia.toString());

            }
            @DisplayName("Caso de prueba 2: AddFirst")
            @Test
            public void addFirstCP2(){
                listaElementos.addFirst('B');
                assertEquals("[B, A, G]",listaElementos.toString());//CP2
            }
            @DisplayName("Caso de prueba 3: AddFirst")
            @Test
            public void addFirstCP3(){
                listaElementos.addFirst('F');
                assertEquals("[F, A, G]",listaElementos.toString());//CP3
            }
            @DisplayName("Caso de prueba 4: AddFirst")
            @Test
            public void addFirstCP4(){
                listaElementos.addFirst('Y');
                assertEquals("[Y, A, G]",listaElementos.toString());//CP4
            }
            @DisplayName("Caso de prueba 5: AddFirst")
            @Test
            public void addFirstCP5(){
                listaElementos.addFirst('Z');
                assertEquals("[Z, A, G]",listaElementos.toString());//CP5
            }
            @DisplayName("Caso de prueba 6: AddFirst")
            @Test
            public  void addFirstCP6(){
                Exception thrown =
                        assertThrows(Exception.class,
                                () ->listaElementos.addFirst('@'),
                                "No lanza excepción con '@'"); //CP6
            }
            @DisplayName("Caso de prueba 7: AddFirst")
            @Test
            public  void addFirstCP7(){
                Exception thrown =
                        assertThrows(Exception.class,
                                () ->listaElementos.addFirst('['),
                                "No lanza excepción con '['"); //CP7
            }
        }

        @Nested
        @DisplayName("Test addLast()")
        public class TestAddLast{
            SingleLinkedListImpl<Character> listaVacia=new SingleLinkedListImpl<Character>();
            SingleLinkedListImpl<Character> listaElementos= new SingleLinkedListImpl<Character>('A','G');
            @DisplayName("Inicialización")
            @BeforeEach
            public void initAddLastTest(){
                SingleLinkedListImpl<Character> listaVacia=new SingleLinkedListImpl<Character>();
                SingleLinkedListImpl<Character> listaElementos= new SingleLinkedListImpl<Character>('A','G');
            }
            @DisplayName("Caso de prueba 1: AddLast")
            @Test
            public void addLastCP1(){
                listaVacia.addLast('A');
                assertEquals("[A]",listaVacia.toString());

            }
            @DisplayName("Caso de prueba 2: AddLast")
            @Test
            public void addLastCP2(){
                listaElementos.addLast('B');
                assertEquals("[A, G, B]",listaElementos.toString());//CP2
            }
            @DisplayName("Caso de prueba 3: AddLast")
            @Test
            public void addLastCP3(){
                listaElementos.addLast('F');
                assertEquals("[A, G, F]",listaElementos.toString());//CP3
            }
            @DisplayName("Caso de prueba 4: AddLast")
            @Test
            public void addLastCP4(){
                listaElementos.addLast('Y');
                assertEquals("[A, G, Y]",listaElementos.toString());//CP4
            }
            @DisplayName("Caso de prueba 5: AddLast")
            @Test
            public void addLastCP5(){
                listaElementos.addLast('Z');
                assertEquals("[A, G, Z]",listaElementos.toString());//CP5
            }
            @DisplayName("Caso de prueba 6: AddLast")
            @Test
            public  void addLastCP6(){
                Exception thrown =
                        assertThrows(Exception.class,
                                () ->listaElementos.addLast('@'),
                                "No lanza excepción con '@'"); //CP6
            }
            @DisplayName("Caso de prueba 7: AddLast")
            @Test
            public  void addLastCP7(){
                Exception thrown =
                        assertThrows(Exception.class,
                                () ->listaElementos.addLast('['),
                                "No lanza excepción con '['"); //CP7
            }

        }

        @Nested
        @DisplayName("Test addNTimes()")
        public class TestAddNTimes{
            SingleLinkedListImpl<Character> listaElementos= new SingleLinkedListImpl<Character>('A','G');
            @DisplayName("Inicialización")
            @BeforeEach
            public void initAddNTimesTest(){
                listaElementos= new SingleLinkedListImpl<Character>('A','G');
            }
            @DisplayName("Caso de prueba 1: AddNTimes")
            @Test
            public void addNTimesCP1(){
                listaElementos.addNTimes('A', 2);
                assertEquals("[A, G, A, A]",listaElementos.toString());
            }
            @DisplayName("Caso de prueba 2: AddNTimes")
            @Test
            public void addNTimesCP2(){
                listaElementos.addNTimes('B', 2);
                assertEquals("[A, G, B, B]",listaElementos.toString());
            }
            @DisplayName("Caso de prueba 3: AddNTimes")
            @Test
            public void addNTimesCP3(){
                listaElementos.addNTimes('P', 0);
                assertEquals("[A, G]",listaElementos.toString());
            }
            @DisplayName("Caso de prueba 4: AddNTimes")
            @Test
            public void addNTimesCP4(){
                listaElementos.addNTimes('Y', 2);
                assertEquals("[A, G, Y, Y]",listaElementos.toString());
            }
            @DisplayName("Caso de prueba 5: AddNTimes")
            @Test
            public void addNTimesCP5(){
                listaElementos.addNTimes('Z', 2);
                assertEquals("[A, G, Z, Z]",listaElementos.toString());
            }
            @DisplayName("Caso de prueba 6: AddNTimes")
            @Test
            public void addNTimesCP6(){
                Exception thrown =
                        assertThrows(Exception.class,
                                () ->listaElementos.addNTimes('A',-1),
                                "No lanza excepción con n=-1");
            }
            @DisplayName("Caso de prueba 7: AddNTimes")
            @Test
            public void addNTimesCP7(){
                Exception thrown =
                        assertThrows(Exception.class,
                                () ->listaElementos.addNTimes('@',2),
                                "No lanza excepción con '@'");
            }
            @DisplayName("Caso de prueba 8: AddNTimes")
            @Test
            public void addNTimesCP8(){
                Exception thrown =
                        assertThrows(Exception.class,
                                () ->listaElementos.addNTimes('[',2),
                                "No lanza excepción con '['");
            }
          /*@DisplayName("Caso de prueba 9: AddNTimes")
            @Test
            public void addNTimesCP9(){
                Exception thrown =
                        assertThrows(Exception.class,
                                () ->listaElementos.addNTimes(9$,2));
            }*/
        }
    }

    @Nested
    @DisplayName("Remove tests")
    public class RemoveTests{

        @Nested
        @DisplayName("Test removeLastParameter()")
        public class TestRemoveLastParameter{
            private SingleLinkedListImpl<Character> miLista=null;
            private SingleLinkedListImpl<Character> listaVacia=null;

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

        @Nested
        @DisplayName("Test removeLast()")
        public class TestRemoveLast{
            private SingleLinkedListImpl<Character> miLista=null;
            private SingleLinkedListImpl<Character> listaVacia;
            private SingleLinkedListImpl<Character> unElemento;
            @BeforeEach
            public void setUp() {
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
                try{
                    Character elem= unElemento.removeLast();
                    assertTrue(elem.equals('G'));
                    Assert.assertEquals(listaVacia.toString(),unElemento.toString());}
                catch (EmptyCollectionException e){};
            }
            @Test   // caso prueba lista con más de un elemento
            public void removeLastCP3(){
                SingleLinkedListImpl listaDeseada = new SingleLinkedListImpl<Character>('A','B','X','Z','L','A');
                try{
                    Character elem= miLista.removeLast();
                    assertTrue(elem.equals('H'));
                    Assert.assertEquals(listaDeseada.toString(),miLista.toString());}
                catch (EmptyCollectionException e){};
            }
        }
    }

    @Nested
    @DisplayName("Test miscellaneous")
    public class TestMiscellaneous{

        @Nested
        @DisplayName("Test isEmpty()")
        public class TestIsEmpty{
            @Test
            @DisplayName("Empty List")
            void testIsEmptyCP1(){
                SingleLinkedListImpl listaVacia = new SingleLinkedListImpl();
                assertEquals(true,listaVacia.isEmpty());
            }
            @Test
            @DisplayName("One element List")
            void TestIsEmptyCP2(){
                SingleLinkedListImpl lista1Elemento = new SingleLinkedListImpl('A');
                assertEquals(false,lista1Elemento.isEmpty());
            }
            @Test
            @DisplayName("Multiple elements")
            void TestIsEmptyCP3(){
                SingleLinkedListImpl listaElementos = new SingleLinkedListImpl('A','B','C');
                assertEquals(false,listaElementos.isEmpty());
            }
        }

        @Nested
        @DisplayName("Test size()")
        public class TestSize{
            @Test
            @DisplayName("Empty List")
            void TestSizeCP1(){
                SingleLinkedListImpl listaVacia = new SingleLinkedListImpl();
                assertEquals(0,listaVacia.size());
            }
            @Test
            @DisplayName("One element List")
            void TestsizeCP2(){
                SingleLinkedListImpl lista1Elemento = new SingleLinkedListImpl('A');
                assertEquals(1,lista1Elemento.size());
            }
            @Test
            @DisplayName("Multiple elements")
            void TestSizeCP3(){
                SingleLinkedListImpl listaElementos = new SingleLinkedListImpl('A','B','C');
                assertEquals(3,listaElementos.size());
            }
        }

        @Nested
        @DisplayName("Test toString()")
        public class TestToString{
            @Test
            @DisplayName("Empty List")
            void testToStringCP1(){
                SingleLinkedListImpl listaVacia = new SingleLinkedListImpl();
                assertEquals("[]",listaVacia.toString());
            }
            @Test
            @DisplayName("One element List")
            void TestToStringCP2(){
                SingleLinkedListImpl lista1Elemento = new SingleLinkedListImpl('A');
                assertEquals("[A]",lista1Elemento.toString());
            }
            @Test
            @DisplayName("Multiple elements")
            void TestToStringCP3(){
                SingleLinkedListImpl listaElementos = new SingleLinkedListImpl('A','B','C');
                assertEquals("[A, B, C]",listaElementos.toString());
            }
        }

        @Nested
        @DisplayName("Test reverse()")
        public class TestReverse{
            SingleLinkedListImpl<Character> listaVacia = null;
            SingleLinkedListImpl<Character> listaElemento = null;
            SingleLinkedListImpl<Character> listaElementosPares = null;
            SingleLinkedListImpl<Character> listaElementosImpares = null;

            @DisplayName("Inicialización")
            @BeforeEach
            void initReverseTest() {
                listaVacia = new SingleLinkedListImpl<Character>();
                listaElemento = new SingleLinkedListImpl<Character>('A');
                listaElementosPares = new SingleLinkedListImpl<Character>('A', 'G');
                listaElementosImpares = new SingleLinkedListImpl<Character>('A', 'G','F');
            }
            @DisplayName("Caso de prueba 1: Reverse")
            @Test
            public void reverseCP1(){
                SingleLinkedListImpl<Character> listaVaciaP = new SingleLinkedListImpl<Character>();
                assertEquals(listaVaciaP.toString() ,listaVacia.reverse().toString());
            }
            @DisplayName("Caso de prueba 2: Reverse")
            @Test
            public void reverseCP2(){
                SingleLinkedListImpl<Character> listaElementoP = new SingleLinkedListImpl<Character>('A');
                assertEquals(listaElementoP.toString(),listaElemento.reverse().toString());
            }
            @DisplayName("Caso de prueba 3: Reverse")
            @Test
            public void reverseCP3(){
                SingleLinkedListImpl<Character> listaElementosParesP = new SingleLinkedListImpl<Character>('G','A');
                assertEquals(listaElementosParesP.toString(),listaElementosPares.reverse().toString());
            }
            @DisplayName("Caso de prueba 4: Reverse")
            @Test
            public void reverseCP4(){
                SingleLinkedListImpl<Character> listaElementosImparesP = new SingleLinkedListImpl<Character>('F','G','A');
                assertEquals(listaElementosImparesP.toString(),listaElementosImpares.reverse().toString());
            }
        }

        @Nested
        @DisplayName("Test getAtPos()")
        public class TestGetAtPos{
            private SingleLinkedListImpl<Character> miLista=null;
            private SingleLinkedListImpl<Character> listaVacia;
            @BeforeEach
            public void setUp() {
                miLista = new SingleLinkedListImpl<Character>('A','B','Y','Z','L','A','H');
                listaVacia = new SingleLinkedListImpl<Character>();
            }
            @Test
            @DisplayName("Empty list and pos:0")
            public void testGetAtPos0(){
                assertThrows(IllegalArgumentException.class,()->{listaVacia.getAtPos(0);}); //Caso de prueba getAtPos 1
            }
            @Test
            @DisplayName("Empty list and pos: 1")
            public void testEmptyGetAtPos1(){
                assertThrows(IllegalArgumentException.class,()->{listaVacia.getAtPos(1);}); //Caso de prueba getAtPos 2
            }
            @Test
            @DisplayName("Empty list and pos: 2")
            public void testEmptyGetAtPos2(){
                assertThrows(IllegalArgumentException.class,()->{listaVacia.getAtPos(2);}); //Caso de prueba getAtPos 3
            }
            @Test
            @DisplayName("Empty list and pos: 4")
            public void testEmptyGetAtPos4(){
                assertThrows(IllegalArgumentException.class,()->{listaVacia.getAtPos(4);}); //Caso de prueba getAtPos 4
            }
            @Test
            @DisplayName("Empty list and pos: 6")
            public void testEmptyGetAtPos6(){
                assertThrows(IllegalArgumentException.class,()->{listaVacia.getAtPos(6);}); //Caso de prueba getAtPos 5
            }
            @Test
            @DisplayName("Empty list and pos: 7")
            public void testEmptyGetAtPos7(){
                assertThrows(IllegalArgumentException.class,()->{listaVacia.getAtPos(7);}); //Caso de prueba getAtPos 6
            }
            @Test
            @DisplayName("Empty list and pos: 8")
            public void testEmptyGetAtPos8(){
                assertThrows(IllegalArgumentException.class,()->{listaVacia.getAtPos(8);}); //Caso de prueba getAtPos 7
            }
            @Test
            @DisplayName("Filled list and pos:0")
            public void testFilledGetAtPos0(){
                assertThrows(IllegalArgumentException.class,()->{miLista.getAtPos(0);});    //Caso de prueba getAtPos 8
            }
            @Test
            @DisplayName("Filled list and pos:1")
            public void testFilledGetAtPos1(){
                assertEquals('A',miLista.getAtPos(1));                              //Caso de prueba getAtPos 9
            }
            @Test
            @DisplayName("Filled list and pos:2")
            public void testFilledGetAtPos2(){
                assertEquals('B',miLista.getAtPos(2));                              //Caso de prueba getAtPos 10
            }
            @Test
            @DisplayName("Filled list and pos:4")
            public void testFilledGetAtPos4(){
                assertEquals('Z',miLista.getAtPos(4));                              //Caso de prueba getAtPos 11
            }
            @Test
            @DisplayName("Filled list and pos:6")
            public void testFilledGetAtPos6(){
                assertEquals('A',miLista.getAtPos(6));                              //Caso de prueba getAtPos 12
            }
            @Test
            @DisplayName("Filled list and pos:7")
            public void testFilledGetAtPos7(){
                assertEquals('H',miLista.getAtPos(7));                              //Caso de prueba getAtPos 13
            }
            @Test
            @DisplayName("Filled list and pos:8")
            public void testFilledGetAtPos8(){
                assertThrows(IllegalArgumentException.class,()->{miLista.getAtPos(8);});    //Caso de prueba getAtPos 14
            }
        }

        @Nested
        @DisplayName("Test indexOf()")
        public class TestIndexOf{
            private SingleLinkedListImpl<Character> miLista=null;
            private SingleLinkedListImpl<Character> listaVacia;
            @BeforeEach
            public void setUp() {
                miLista = new SingleLinkedListImpl<Character>('A','B','Y','Z','L','A','H');
                listaVacia = new SingleLinkedListImpl<Character>();
            }
            @Test
            @DisplayName("Empty list and index of:@")
            public void testEmptyListIndexOf1(){
                assertThrows(NoSuchElementException.class,()->{listaVacia.indexOf('@');}); //Caso de prueba indexOf 1
            }
            @Test
            @DisplayName("Empty list and index of:A")
            public void testEmptyListIndexOf2(){
                assertThrows(NoSuchElementException.class,()->{listaVacia.indexOf('A');}); //Caso de prueba indexOf 2
            }
            @Test
            @DisplayName("Empty list and index of:B")
            public void testEmptyListIndexOf3(){
                assertThrows(NoSuchElementException.class,()->{listaVacia.indexOf('B');}); //Caso de prueba indexOf 3
            }
            @Test
            @DisplayName("Empty list and index of:L")
            public void testEmptyListIndexOf4(){
                assertThrows(NoSuchElementException.class,()->{listaVacia.indexOf('L');}); //Caso de prueba indexOf 4
            }
            @Test
            @DisplayName("Empty list and index of:Y")
            public void testEmptyListIndexOf5(){
                assertThrows(NoSuchElementException.class,()->{listaVacia.indexOf('Y');}); //Caso de prueba indexOf 5

            }
            @Test
            @DisplayName("Empty list and index of:Z")
            public void testEmptyListIndexOf6(){
                assertThrows(NoSuchElementException.class,()->{listaVacia.indexOf('Z');}); //Caso de prueba indexOf 5

            }
            @Test
            @DisplayName("Empty list and index of:[")
            public void testEmptyListIndexOf7(){
                assertThrows(NoSuchElementException.class,()->{listaVacia.indexOf('[');}); //Caso de prueba indexOf 7
            }
            @Test
            @DisplayName("Filled list and index of:@")
            public void testFilledListIndexOf1(){
                assertThrows(NoSuchElementException.class,()->{miLista.indexOf('@');});    //Caso de prueba indexOf 8
            }
            @Test
            @DisplayName("Filled list and index of:A")
            public void testFilledListIndexOf2(){
                assertEquals(1,miLista.indexOf('A'));                              //Caso de prueba indexOf 9
            }
            @Test
            @DisplayName("Filled list and index of:B")
            public void testFilledListIndexOf3(){
                assertEquals(2,miLista.indexOf('B'));                              //Caso de prueba indexOf 10
            }
            @Test
            @DisplayName("Filled list and index of:L")
            public void testFilledListIndexOf4(){
                assertEquals(5,miLista.indexOf('L'));                              //Caso de prueba indexOf 11
            }
            @Test
            @DisplayName("Filled list and index of:Y")
            public void testFilledListIndexOf5(){
                assertEquals(3,miLista.indexOf('Y'));                              //Caso de prueba indexOf 12
            }
            @Test
            @DisplayName("Filled list and index of:Z")
            public void testFilledListIndexOf6(){
                assertEquals(4,miLista.indexOf('Z'));                              //Caso de prueba indexOf 13
            }
            @Test
            @DisplayName("Filled list and index of:[")
            public void testFilledListIndexOf7(){
                assertThrows(NoSuchElementException.class,()->{miLista.indexOf('[');});    //Caso de prueba indexOf 14
            }

        }

        @Nested
        @DisplayName("Test isSubList()")
        public class TestIsSubList{
            private SingleLinkedListImpl<Character> emptyList;
            private SingleLinkedListImpl<Character>  filledList;
            private SingleLinkedListImpl<Character> equalFilledSublist;
            private SingleLinkedListImpl<Character> differentFilledSublist;
            private SingleLinkedListImpl<Character> shortSublist;
            private SingleLinkedListImpl<Character> emptySublist;
            private SingleLinkedListImpl<Character> biggerSublList;
            @BeforeEach
            public void setUp() {
                emptyList = new SingleLinkedListImpl<Character>();
                filledList = new SingleLinkedListImpl<Character>('A', 'B', 'G', 'Z', 'I', 'K', 'R', 'V');
                equalFilledSublist = new SingleLinkedListImpl<Character>('A', 'B', 'G', 'Z', 'I', 'K', 'R', 'V');
                differentFilledSublist = new SingleLinkedListImpl<Character>('G', 'E', 'A', 'Z', 'R', 'P', 'V', 'N');
                biggerSublList = new SingleLinkedListImpl<Character>('H','I','S','T','R','G','G','S','H','E','V','S','R','N');
                shortSublist = new SingleLinkedListImpl<Character>('Z', 'I', 'K');
                emptySublist = new SingleLinkedListImpl<Character>();
            }
            @Test
            @DisplayName("Empty list and empty sublist")
            public void isSubListCP1(){
                assertEquals(0, emptyList.isSubList(emptySublist));

            }
            @Test
            @DisplayName("Empty list and filled sublist")
            public void isSubListCP2(){
                assertEquals(-1, emptyList.isSubList(equalFilledSublist));
            }
            @Test
            @DisplayName("Filled list and empty sublist")
            public void isSubListCP3(){
                assertEquals(0, filledList.isSubList(emptySublist));
            }
            @Test
            @DisplayName("Filled list and equally filled sublist")
            public void isSubListCP4(){
                assertEquals(1, filledList.isSubList(equalFilledSublist));
            }
            @Test
            @DisplayName("Filled list and different filled sublist")
            public void isSubListCP5(){
                assertEquals(-1, filledList.isSubList(differentFilledSublist));
            }
            @Test
            @DisplayName("Filled list and smaller filled sublist")
            public void isSubListCP6(){
                assertEquals(4, filledList.isSubList(shortSublist));
            }
            @Test
            @DisplayName("Filled list and bigger filled sublist")
            public void isSubListCP7(){
                assertEquals(-1, filledList.isSubList(biggerSublList));
            }
        }
    }

}
