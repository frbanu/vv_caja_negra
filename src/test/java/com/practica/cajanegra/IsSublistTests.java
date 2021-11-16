package com.practica.cajanegra;
import com.cajanegra.SingleLinkedListImpl;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IsSublistTests {
    private static SingleLinkedListImpl<Character> emptyList;
    private static SingleLinkedListImpl<Character>  filledList;
    private static SingleLinkedListImpl<Character> equalFilledSublist;
    private static SingleLinkedListImpl<Character> differentFilledSublist;
    private static SingleLinkedListImpl<Character> shortSublist;
    private static SingleLinkedListImpl<Character> emptySublist;
    private static SingleLinkedListImpl<Character> biggerSublList;
    @BeforeAll
    public static void setUp() {
        emptyList = new SingleLinkedListImpl<Character>();
        filledList = new SingleLinkedListImpl<Character>('A', 'B', 'G', 'Z', 'I', 'K', 'R', 'V');
        equalFilledSublist = new SingleLinkedListImpl<Character>('A', 'B', 'G', 'Z', 'I', 'K', 'R', 'V');
        differentFilledSublist = new SingleLinkedListImpl<Character>('G', 'E', 'A', 'Z', 'R', 'P', 'V', 'N');
        biggerSublList = new SingleLinkedListImpl<Character>('H','I','S','T','R','G','G','S','H','E','V','S','R','N');
        shortSublist = new SingleLinkedListImpl<Character>('Z', 'I', 'K');
        emptySublist = new SingleLinkedListImpl<Character>();
    }
    @Test
    public void emptyList(){
        assertEquals(0, emptyList.isSubList(emptySublist));
        assertEquals(-1, emptyList.isSubList(equalFilledSublist));
    }
    @Test
    public void filledList(){
        assertEquals(0, filledList.isSubList(emptySublist));
        assertEquals(1, filledList.isSubList(equalFilledSublist));
        assertEquals(-1, filledList.isSubList(differentFilledSublist));
        assertEquals(4, filledList.isSubList(shortSublist));
        assertEquals(-1, filledList.isSubList(biggerSublList));
    }



}
