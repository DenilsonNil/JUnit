package br.com.kualit.course;

import java.util.List;

public interface CourseService {

    List<String> retrieveCourses(String student);
    void deleteCourse(String courseName);
}
