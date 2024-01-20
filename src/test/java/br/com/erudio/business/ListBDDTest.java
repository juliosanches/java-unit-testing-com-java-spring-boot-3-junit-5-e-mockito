package br.com.erudio.business;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class ListBDDTest {

    @Test
    void testMockingList_WhenSizeIsCalled_ShouldReturn10() {
        // Given / Arrange
        List<?> list = mock(List.class);
        given(list.size()).willReturn(10);

        // When / Act
        // Then / Assert
        assertThat(list.size(), is(10));
        assertThat(list.size(), is(10));
        assertThat(list.size(), is(10));
    }

    @Test
    void testMockingList_WhenSizeIsCalled_ShouldReturnMultipleValues() {
        // Given / Arrange
        List<?> list = mock(List.class);
        given(list.size()).willReturn(10).willReturn(20);

        // When / Act
        // Then / Assert
        assertEquals(10, list.size());
        assertEquals(20, list.size());
        assertEquals(20, list.size());
    }

    @Test
    void testMockingList_WhenGetIsCalled_ShouldReturnErudio() {
        // Given / Arrange
        List<?> list = mock(List.class);
        given((String) list.get(0)).willReturn("Erudio");

        // When / Act
        // Then / Assert
        assertThat(list.get(0), is("Erudio"));
        assertNull(list.get(1));
    }

    @Test
    void testMockingList_WhenGetIsCalledWithArgumentMatcher_ShouldReturnErudio() {
        // Given / Arrange
        List<?> list = mock(List.class);
        given((String) list.get(anyInt())).willReturn("Erudio");

        // When / Act
        // Then / Assert
        assertThat(list.get(0), is("Erudio"));
        assertEquals("Erudio", list.get(1));
        assertEquals("Erudio", list.get(anyInt()));
    }

    @Test
    void testMockingList_WhenThrowsAnException() {
        // Given / Arrange
        List<?> list = mock(List.class);
        given(list.get(anyInt())).willThrow(new RuntimeException("Foo Bar!"));

        // When / Act
        // Then / Assert
        assertThrows(RuntimeException.class, () -> {
            list.get(anyInt());
        }, () -> "Should throw an RunTimeException");
    }

}
