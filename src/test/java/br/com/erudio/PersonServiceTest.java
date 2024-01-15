package br.com.erudio;

import br.com.erudio.model.Person;
import br.com.erudio.service.IPersonService;
import br.com.erudio.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonServiceTest {

    Person person;

    IPersonService service;

    @BeforeEach
    void setup(){
        service = new PersonService();
        person = new Person(
                "Keith",
                "Moon",
                "kmoon@erudio.com.br",
                "Wembley - UK",
                "Male"
        );
    }

    @Test
    @DisplayName("When create a Person with success should return a Person Object")
    void testCreatePerson_WhenSuccess_ShouldReturnPersonObject() {
        // Given / Arrange

        // When / Act
        Person actual = service.createPerson(person);

        // Then / Assert
        assertNotNull(actual,
                () -> "The createPerson() should not have returned null");

    }

    @Test
    @DisplayName("When create a Person with success should contains valid fields in returned Person Object")
    void testCreatePerson_WhenSuccess_ShouldContainsValidFieldsInReturnedPersonObject() {
        // Given / Arrange

        // When / Act
        Person actual = service.createPerson(person);

        // Then / Assert
        assertNotNull(actual.getId(), () -> "Person ID is missing.");
        assertEquals(person.getFirstName(), actual.getFirstName(),
                () -> "The firstName is Incorrect!");
        assertEquals(person.getLastName(), actual.getLastName(),
                () -> "The lastName is Incorrect!");
        assertEquals(person.getEmail(), actual.getEmail(),
                () -> "The emailName is Incorrect!");
        assertEquals(person.getAddress(), actual.getAddress(),
                () -> "The address is Incorrect!");
        assertEquals(person.getGender(), actual.getGender(),
                () -> "The gender is Incorrect!");

    }

    // test[System Under Test]_[Condition or State Change]_[Expected Result]
    @Test
    @DisplayName("When create a Person with null email should throw exception")
    void testCreatePerson_WithNullEMail_ShouldThrowIllegalArgumentException() {
        // Given / Arrange
        person.setEmail(null);

        var expectedMessage = "The person email is null or empty.";

        // When / Act
        // Then / Assert
        IllegalArgumentException actual =
                assertThrows(IllegalArgumentException.class,
                () -> service.createPerson(person),
                () -> "Empty email should cause an IllegalArgumentException");
        assertEquals(expectedMessage, actual.getMessage(),
                () -> "Exception error message is incorrect!");

    }
}
