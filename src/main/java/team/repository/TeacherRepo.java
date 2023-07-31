package team.repository;

import team.model.Teacher;

import java.util.List;

public interface TeacherRepo {
    List<Teacher> findAll(Long id);

    Teacher findById(Long id);

    void save(Teacher teacher) throws Exception;

    void delete(Long id);

    void updateTeacher(Long id, Teacher teacher);

    void clear();
}
