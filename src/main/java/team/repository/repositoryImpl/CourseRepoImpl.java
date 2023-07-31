package team.repository.repositoryImpl;

import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import team.model.Course;
import team.repository.CourseRepo;

import java.util.List;
@Repository
@Transactional
public class CourseRepoImpl implements CourseRepo {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Course> findAll(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select c from Course c where c.company.id ="+id, Course.class).getResultList();
    }

    @Override
    public List<Course> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select c from Course c", Course.class).getResultList();
    }

    @Override
    public Course findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Course.class, id);
    }


    @Override
    public void save(Course course) {
        Session session = sessionFactory.getCurrentSession();
        session.save(course);
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Course course = findById(id);
        session.delete(course);

    }

    @Override
    public void updateCourse(Long id, Course course) {
        Session session = sessionFactory.getCurrentSession();
        Course course1 = findById(id);
        course1.setCourseName(course.getCourseName());
        course1.setDuration(course.getDuration());
        session.merge(course1);
    }

    @Override
    public void clear() {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Course ").executeUpdate();

    }
}
