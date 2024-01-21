package br.com.erudio.mockito;

import br.com.erudio.business.CourseBusiness;
import br.com.erudio.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CourseBusinessMockitoInjectMocksTest {

    @Mock
    CourseService mockService;

    @InjectMocks
    CourseBusiness business; // business = new CourseBusiness(mockService);

    @Captor
    ArgumentCaptor<String> argumentCaptor;
    List<String> courses;

    @BeforeEach
    void setUp() {
        // Given / Arrange

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
        given(mockService.retrieveCourses("Leandro")).willReturn(courses);

        var filteredCourses = business.retrieveCoursesRelatedToSpring("Leandro");

        // Then / Assert
        assertThat(filteredCourses.size(), is(4));

    }

    // test[System Under Test]_[Condition or State Change]_[Expected Result]
    @Test
    @DisplayName("Delete courses not related to Spring using mockito should call method deleteCourse")
    void testDeleteCoursesNotRelatedToSpring_UsingMockitoVerify_ShouldCallMethodDeleteCourse() {
        // Given / Arrange
        given(mockService.retrieveCourses("Leandro")).willReturn(courses);
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
        given(mockService.retrieveCourses("Leandro")).willReturn(courses);
        String agileCourse = "Agile Desmistificado com Scrum, XP, Kanban e Trello";
        String archetureCoure = "Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#";
        String resrSpringcourse = "REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker";

        // When / Act
        business.deleteCoursesNotRelatedToSpring("Leandro");

        // Then / Assert
        then(mockService).should().deleteCourse(agileCourse);

        then(mockService).should().deleteCourse(archetureCoure);


        then(mockService).should(never()).deleteCourse(resrSpringcourse);
    }


    // test[System Under Test]_[Condition or State Change]_[Expected Result]
    @Test
    @DisplayName("Delete courses not related to Spring using mockito CapturingArguments should call method deleteCourse")
    void testDeleteCoursesNotRelatedToSpring_CapturingArguments_ShouldCallMethodDeleteCourse() {
        // Given / Arrange
/*        courses =Arrays.asList(
                "Agile Desmistificado com Scrum, XP, Kanban e Trello",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker"
        );*/

        given(mockService.retrieveCourses("Leandro")).willReturn(courses);

//        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

        String agileCourse = "Agile Desmistificado com Scrum, XP, Kanban e Trello";

        // When / Act
        business.deleteCoursesNotRelatedToSpring("Leandro");

        // Then / Assert
        then(mockService).should(times(7)).deleteCourse(argumentCaptor.capture());
        assertThat(argumentCaptor.getAllValues().size(), is(7));
    }
}