package br.com.erudio.mockito.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;

class OrderServiceTest {

    private final OrderService service = new OrderService();
    private final UUID defaultUuid = UUID.fromString("df39b0be-d002-485a-bfc6-616be887da62");

    // test[System Under Test]_[Condition or State Change]_[Expected Result]
    @Test
    @DisplayName("Should Include Random Order Id When No Order Id Exists")
    void testShouldIncludeRandomOrderId_When_NoOrderIdExists() {
        // Given / Arrange
        try (MockedStatic<UUID> mockedUuid = mockStatic(UUID.class)) {
            mockedUuid.when(UUID::randomUUID).thenReturn(defaultUuid);
            // When / Act
            Order result = service.createOrder("Positivo Vaio", 2L, null);
            // Then / Assert
            assertEquals(defaultUuid.toString(), result.getId());

        }





    }
}