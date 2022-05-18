package com.nhnacademy.edu.jdbc1.service.course;

import com.nhnacademy.edu.jdbc1.domain.Course;
import org.springframework.stereotype.Service;

@Service
public class DefaultCourseCreationService implements CourseCreationService {

    @Override
    public int insert(Course course) {
        return 0;
    }
}
