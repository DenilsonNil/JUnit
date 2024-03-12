package br.com.kualit.course;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ListTest {

    @Test
    void TestMockingList_WhenSizeIsCalled_ShouldReturn_MultipleValues (){
        List<?> list = mock(List.class);
        when(list.size())
                .thenReturn(10)
                .thenReturn(20)
                .thenReturn(30);

        assertEquals(10, list.size());
        assertEquals(20, list.size());
        assertEquals(30, list.size());
    }

    @Test
    void TestMockingList_WhenGetIsCalled_ShouldReturn_Denilson (){
        List<String> list = mock(List.class);
        when(list.get(0))
                .thenReturn("Denilson");

        assertEquals("Denilson", list.get(0));
        assertNull(list.get(1));
    }

    @Test
    void TestMockingList_WhenGetIsCalledWithArgumentMatcher_ShouldReturn_Denilson (){
        List<String> list = mock(List.class);
        //anyInt() -> ArgumentMatcher.
        when(list.get(anyInt()))
                .thenReturn("Denilson");

        assertEquals("Denilson", list.get(0));
    }
}
