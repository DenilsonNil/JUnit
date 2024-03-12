package br.com.kualit.course;

import br.com.kualit.stubs.CourseServiceStub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CourseBusinessStubTest {


    @Test
    void retriveCoursesRelatedToSpring_UsingAStub() {

        CourseService stubService = new CourseServiceStub();
        CourseBusiness business = new CourseBusiness(stubService);

        var filteredCourses =
                business.retriveCoursesRelatedToSpring("Valdivia");

        assertEquals(4, filteredCourses.size());
    }

    @Test
    void retriveCoursesRelatedToSpring_UsingFooBarStudent() {

        CourseService stubService = new CourseServiceStub();
        CourseBusiness business = new CourseBusiness(stubService);

        var filteredCourses =
                business.retriveCoursesRelatedToSpring("FooBar");

        assertEquals(0, filteredCourses.size());
    }
}