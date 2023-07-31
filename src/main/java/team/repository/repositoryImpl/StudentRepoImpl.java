package team.repository.repositoryImpl;

import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import team.model.Student;
import team.repository.StudentRepo;

import java.util.List;

@Repository
@Transactional
public class StudentRepoImpl implements StudentRepo {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Student> findAll(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select s from Student s where s.groups.id="+id, Student.class).getResultList();

    }

    @Override
    public Student findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Student.class, id);

    }

    @Override
    public void save(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.save(student);
    }
    @Override
    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Student where id=" + id).executeUpdate();
    }
    @Override
    public void updateStudent(Long id, Student student) {
        Session session = sessionFactory.getCurrentSession();
        Student student1 = findById(id);
        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setEmail(student.getEmail());
        student1.setStudentFormat(student.getStudentFormat());
        session.merge(student1);
    }
    @Override
    public void clear() {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Student ").executeUpdate();

    }
}
