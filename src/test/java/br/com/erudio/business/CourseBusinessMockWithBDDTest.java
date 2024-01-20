package br.com.erudio.business;

import br.com.erudio.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

class CourseBusinessMockWithBDDTest {

    CourseService mockService;
    CourseBusiness business;
    List<String> courses;

    @BeforeEach
    void setUp() {
        // Given / Arrange
        mockService = mock(CourseService.class);
        business = new CourseBusiness(mockService);
        courses = Arrays.asList(
                "REST API's RESTFul do 0 à Azure com ASP.NET Core 5 e Docker",
                "Agile Desmistificado com Scrum, XP, Kanban e Trello",
                "Spotify Engineering Culture Desmistificado",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker",
                "Docker do Zero à Maestria - Contêinerização Desmistificada",
                "Docker para Amazon AWS Implante Apps Java e .NET com Travis CI",
                "Microsserviços do 0 com Spring Cloud, Spring Boot e Docker",
                "Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Kotlin e Docker",
                "Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android",
                "Microsserviços do 0 com Spring Cloud, Kotlin e Docker"
        );
    }

    @Test
    void testCoursesRelatedToSpring_When_UsingAStub() {

        // When / Act
        given(mockService.retrieveCourses("Leandro"))
                .willReturn(courses);

        var filteredCourses =
                business.retrieveCoursesRelatedToSpring("Leandro");

        // Then / Assert
        assertThat(filteredCourses.size(), is(4));

    }

    // test[System Under Test]_[Condition or State Change]_[Expected Result]
    @Test
    @DisplayName("Delete courses not related to Spring using mockito should call method deleteCourse")
    void testDeleteCoursesNotRelatedToSpring_UsingMockitoVerify_ShouldCallMethodDeleteCourse() {
        // Given / Arrange
        given(mockService.retrieveCourses("Leandro"))
                .willReturn(courses);
        // When / Act
        business.deleteCoursesNotRelatedToSpring("Leandro");

        // Then / Assert
        verify(mockService).deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");
//        verify(mockService).deleteCourse("Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#");

//        verify(mockService, times(1)).deleteCourse("Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#");
//        verify(mockService, atLeast(1)).deleteCourse("Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#");
        verify(mockService, atLeastOnce()).deleteCourse("Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#");

        verify(mockService, never()).deleteCourse("REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker");
    }
    // test[System Under Test]_[Condition or State Change]_[Expected Result]
    @Test
    @DisplayName("Delete courses not related to Spring using mockito should call method deleteCourseV2")
    void testDeleteCoursesNotRelatedToSpring_UsingMockitoVerify_ShouldCallMethodDeleteCourseV2() {
        // Given / Arrange
        given(mockService.retrieveCourses("Leandro"))
                .willReturn(courses);
        // When / Act
        business.deleteCoursesNotRelatedToSpring("Leandro");

        // Then / Assert
        then(mockService)
                .should()
                .deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");
        then(mockService)
                .should()
                .deleteCourse("Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#");

        then(mockService)
                .should(never())
                .deleteCourse("REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker");
    }
}