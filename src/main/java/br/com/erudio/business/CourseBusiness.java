package br.com.erudio.business;

import br.com.erudio.service.CourseService;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
// CourseBusiness = SUT - System (Method) Under Test
public class CourseBusiness {

    //CourseService is a Dependency
    private CourseService service;

    public List<String> retrieveCoursesRelatedToSpring(String student){

        var filteredCources = new ArrayList<String>();
        if("Foo Bar".equals(student)) return filteredCources;

        var allCourses = service.retrieveCourses(student);

        for (String course : allCourses) {
            if(course.contains("Spring")) {
                filteredCources.add(course);
            }
        }

        return filteredCources;
    }
}
