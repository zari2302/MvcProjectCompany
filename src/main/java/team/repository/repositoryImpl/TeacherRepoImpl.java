package team.repository.repositoryImpl;

import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import team.model.Teacher;
import team.repository.TeacherRepo;

import java.util.List;

@Repository
@Transactional
public class TeacherRepoImpl implements TeacherRepo {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Teacher> findAll(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select t from Teacher t where t.groups.id=" + id, Teacher.class).getResultList();

    }

    @Override
    public Teacher findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Teacher.class, id);

    }

    @Override
    public void save(Teacher teacher) throws Exception {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.save(teacher);
        } catch (Exception e) {
            throw new Exception("учитель уже есть!!!");
        }
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Teacher where id=" + id).executeUpdate();
    }

    @Override
    public void updateTeacher(Long id, Teacher teacher) {
        Session session = sessionFactory.getCurrentSession();
        Teacher teacher1 = findById(id);
        teacher1.setFirstName(teacher.getFirstName());
        teacher1.setLastName(teacher.getLastName());
        teacher1.setEmail(teacher.getEmail());
        session.merge(teacher1);
    }

    @Override
    public void clear() {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Teacher ").executeUpdate();

    }
}


