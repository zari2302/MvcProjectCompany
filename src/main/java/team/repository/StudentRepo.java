package team.repository;

import team.model.Student;

import java.util.List;

public interface StudentRepo {
    List<Student> findAll(Long id);

    Student findById(Long id);

    void save(Student student);

    void delete(Long id);

    void updateStudent(Long id, Student student);

    void clear();
}
