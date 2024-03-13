package br.com.kualit.course;

import java.util.ArrayList;
import java.util.List;


// CourseBusiness = SUT - System (Method) Under Test
public class CourseBusiness {

    public static final String MAIN_COURSE = "Spring";
    // CourseService is a Dependency
    private CourseService service;

    public CourseBusiness(CourseService service) {
        this.service = service;
    }
    
    public List<String> retriveCoursesRelatedToSpring(String student) {
        
        var filteredCourses = new ArrayList<String>();
        var allStudentCourses = service.retrieveCourses(student);
        
        for (String course : allStudentCourses) {
            if (course.contains(MAIN_COURSE))
                filteredCourses.add(course);
        }
        
        return filteredCourses;
    }

    public void deleteCoursesNotRelatedToSpring(String student) {
        var allStudentCourses = service.retrieveCourses(student);

        for (String course : allStudentCourses) {
            if (!course.contains(MAIN_COURSE))
                service.deleteCourse(course);
        }
    }
    
}
