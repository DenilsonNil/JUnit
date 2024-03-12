package br.com.kualit.course;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;


public class ListTestBDD {

    @Test
    void TestMockingList_WhenSizeIsCalled_ShouldReturn_MultipleValues (){
        List<?> list = mock(List.class);
        given(list.size())
                .willReturn(10)
                .willReturn(20)
                .willReturn(30);

        assertThat(list.size(), is(10));
        assertThat(list.size(), is(20));
        assertThat(list.size(), is(30));
    }

    @Test
    void TestMockingList_WhenGetIsCalled_ShouldReturn_Denilson (){
        List<String> list = mock(List.class);
        given(list.get(0))
                .willReturn("Denilson");

        assertThat(list.get(0), is("Denilson"));
        assertThat(list.get(1), nullValue());
    }

    @Test
    void TestMockingList_WhenGetIsCalledWithArgumentMatcher_ShouldReturn_Denilson (){
        List<String> list = mock(List.class);
        //anyInt() -> ArgumentMatcher.
        given(list.get(anyInt()))
                .willReturn("Denilson");

        assertThat(list.get(0), is("Denilson"));
    }

    @Test
    void TestMockingList_WhenThrowsAnException (){
        List<String> list = mock(List.class);
        //anyInt() -> ArgumentMatcher.
        String expectedMessage = "Foo Bar!";

        given(list.get(anyInt()))
                .willThrow(new RuntimeException("Foo Bar!"));

        var exception = assertThrows(
                RuntimeException.class,
                () -> list.get(0),
                () -> "It should have throw an Runtime Exception");

        assertEquals(expectedMessage, exception.getMessage());
    }
}
