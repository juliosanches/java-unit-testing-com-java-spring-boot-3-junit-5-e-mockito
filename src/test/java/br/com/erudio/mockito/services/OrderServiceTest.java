package br.com.erudio.mockito.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;

class OrderServiceTest {

    private final OrderService service = new OrderService();
    private final UUID defaultUuid = UUID.fromString("df39b0be-d002-485a-bfc6-616be887da62");
    private final LocalDateTime defaultLocalDateTime = LocalDateTime.of(2024, 2,1,17,20);

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

    @Test
    @DisplayName("Should Include CreateTime When Create A New Order")
    void testShouldIncludeCreateTime_When_CreateANewOrder() {
        // Given / Arrange
        try (MockedStatic<LocalDateTime> mockedLocalDateTime = mockStatic(LocalDateTime.class)) {
            mockedLocalDateTime.when(LocalDateTime::now).thenReturn(defaultLocalDateTime);
            // When / Act
            Order result = service.createOrder("Positivo Vaio", 2L, null);
            // Then / Assert
            assertEquals(defaultLocalDateTime, result.getCreationDate());

        }
    }
}