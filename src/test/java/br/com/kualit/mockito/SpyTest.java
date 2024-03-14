package br.com.kualit.mockito;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class SpyTest {

    @Test
    void testSpyArrayList_V1() {
        //List<String> list = mock(ArrayList.class);
        List<String> list = spy(ArrayList.class);

        assertEquals(0, list.size());

        when(list.size()).thenReturn(5);

        list.add("Foo-bar");
        assertEquals(5, list.size());
    }

    @Test
    void testSpyArrayList_V2() {
        //List<String> list = mock(ArrayList.class);
        List<String> list = spy(ArrayList.class);

        assertEquals(0, list.size());

        list.add("Foo-bar");
        assertEquals(1, list.size());

        list.remove("Foo-bar");
        assertEquals(0, list.size());
    }

    @Test
    void testSpyArrayList_V3() {
        //List<String> list = mock(ArrayList.class);
        List<String> list = spy(ArrayList.class);

        list.add("Foo-bar");

        verify(list).add("Foo-bar");
        verify(list, never()).remove("Foo-bar");
        verify(list, never()).remove(anyString());
        verify(list, never()).clear();
    }



}
