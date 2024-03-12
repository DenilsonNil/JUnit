package br.com.kualit.course;

import br.com.kualit.stubs.CourseServiceStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CourseBusinessMockTest {

    CourseService mockService;
    CourseBusiness business;

    List<String> courses;

    @BeforeEach
    void setUp() {

        //Given
        //Getting a mock dependency service.
        mockService =  mock(CourseService.class);

        //Injecting the mockService into the System under test
        business =  new CourseBusiness(mockService);

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
                "Microsserviços do 0 com Spring Cloud, Kotlin e Docker");
    }

    @Test
    void retriveCoursesRelatedToSpring_UsingAMock() {
        when(mockService.retrieveCourses("Valdivia"))
                .thenReturn(courses);

        var filteredCourses =
                business.retriveCoursesRelatedToSpring("Valdivia");

        assertEquals(4, filteredCourses.size());
    }
}