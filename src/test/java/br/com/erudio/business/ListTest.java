package br.com.erudio.business;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {

    @Test
    void testMockingList_WhenSizeIsCalled_ShouldReturn10() {
        // Given / Arrange
        List<?> list = mock(List.class);
        when(list.size()).thenReturn(10);

        // When / Act
        // Then / Assert
        assertEquals(10, list.size());
        assertEquals(10, list.size());
        assertEquals(10, list.size());
    }

    @Test
    void testMockingList_WhenSizeIsCalled_ShouldReturnMultipleValues() {
        // Given / Arrange
        List<?> list = mock(List.class);
        when(list.size()).thenReturn(10).thenReturn(20);

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
        when((String) list.get(0)).thenReturn("Erudio");

        // When / Act
        // Then / Assert
        assertEquals("Erudio", list.get(0));
        assertNull(list.get(1));
    }

    @Test
    void testMockingList_WhenGetIsCalledWithArgumentMatcher_ShouldReturnErudio() {
        // Given / Arrange
        List<?> list = mock(List.class);
        when((String) list.get(anyInt())).thenReturn("Erudio");

        // When / Act
        // Then / Assert
        assertEquals("Erudio", list.get(0));
        assertEquals("Erudio", list.get(1));
        assertEquals("Erudio", list.get(anyInt()));
    }

    @Test
    void testMockingList_WhenThrowsAnException() {
        // Given / Arrange
        List<?> list = mock(List.class);
        when(list.get(anyInt())).thenThrow(new RuntimeException("Foo Bar!"));

        // When / Act
        // Then / Assert
        assertThrows(RuntimeException.class, () -> {
            list.get(anyInt());
        }, () -> "Should throw an RunTimeException");
    }

}
