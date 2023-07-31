package team.repository;

import team.model.Course;

import java.util.List;

public interface CourseRepo {
    List<Course> findAll(Long id);
    List<Course> findAll();

    Course findById(Long id);

    void save(Course course);

    void delete(Long id);

    void updateCourse(Long id,Course course);

    void clear();
}
