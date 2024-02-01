package br.com.erudio.mockito.staticwithparams;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mockStatic;

class MyUtilsTest {

    @Test
    void shouldMockStaticMethodsWithParams(){
        try(MockedStatic<MyUtils> mockedStatic = mockStatic(MyUtils.class)){
            mockedStatic.when(
                    () -> MyUtils.getWelcomeMessage(eq("Erudio"), anyBoolean())
            ).thenReturn("Howdy Erudio");

            String result = MyUtils.getWelcomeMessage("Erudio", false);

            assertEquals("Howdy Erudio", result);
        }
    }

}