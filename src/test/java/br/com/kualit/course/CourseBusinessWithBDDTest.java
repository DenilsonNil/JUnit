package br.com.kualit.course;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

class CourseBusinessWithBDDTest {

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
    void retriveCoursesRelatedToSpring_UsingAMock_WithBDD() {
        //Instead to use when use given from the package org.mockito.BDDMockito.given
        given(mockService.retrieveCourses("Valdivia"))
                .willReturn(courses);

        var filteredCourses =
                business.retriveCoursesRelatedToSpring("Valdivia");
        //Instead to use assertEquals use assertThat from Hamcrest that is most friendly
        assertThat(filteredCourses.size(), is(4));
    }


    @Test
    void testDeleteCoursesNotRelatedToSpring() {
        given(mockService.retrieveCourses("Valdivia"))
                .willReturn(courses);

        business.deleteCoursesNotRelatedToSpring("Valdivia");

        //Verifying if the deleteCourse method is called
        verify(mockService)
                .deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");

        //once
        verify(mockService, times(1))
                .deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");
        //At least once
        verify(mockService, atLeast(1))
                .deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");

        verify(mockService, atLeastOnce())
                .deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");

        //Never called
        verify(mockService, never())
                .deleteCourse("Microsserviços do 0 com Spring Cloud, Kotlin e Docker");

    }

    @Test
    void testDeleteCoursesNotRelatedToSpringV2() {
        //Using then and should to apply verify
        given(mockService.retrieveCourses("Valdivia"))
                .willReturn(courses);

        String agileCourse = "Agile Desmistificado com Scrum, XP, Kanban e Trello";
        String kotlinCourse = "Microsserviços do 0 com Spring Cloud, Kotlin e Docker";

        business.deleteCoursesNotRelatedToSpring("Valdivia");

        //Verifying if the deleteCourse method is called
        then(mockService).should().deleteCourse(agileCourse);

        then(mockService).should(never()).deleteCourse(kotlinCourse);
    }

    @Test
    void testDeleteCoursesNotRelatedToSpringCapturingArguments() {
        courses = Arrays.asList(
                "Agile Desmistificado com Scrum, XP, Kanban e Trello",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker"
        );

        //Using then and should to apply verify
        given(mockService.retrieveCourses("Valdivia"))
                .willReturn(courses);

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

        String agileCourse = "Agile Desmistificado com Scrum, XP, Kanban e Trello";

        business.deleteCoursesNotRelatedToSpring("Valdivia");

        then(mockService).should().deleteCourse(argumentCaptor.capture());
        assertThat(argumentCaptor.getValue(), is(agileCourse));
    }

}