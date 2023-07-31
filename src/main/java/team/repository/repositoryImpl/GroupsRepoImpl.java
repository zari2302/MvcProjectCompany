package team.repository.repositoryImpl;

import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import team.model.Groups;
import team.repository.GroupsRepo;

import java.util.List;
@Repository
@Transactional
public class GroupsRepoImpl implements GroupsRepo {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Groups> findAll(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select c from Groups c where c.company.id="+id, Groups.class).getResultList();
    }

    @Override
    public Groups findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Groups.class, id);
    }


    @Override
    public void save(Groups groups) {
        Session session = sessionFactory.getCurrentSession();
        session.save(groups);
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Groups groups = findById(id);
        session.delete(groups);

    }

    @Override
    public void updateGroups(Long id, Groups groups) {
        Session session = sessionFactory.getCurrentSession();
        Groups groups1 = findById(id);
        groups1.setGroupName(groups.getGroupName());
        groups1.setDateStart(groups.getDateStart());
        groups1.setDateFinish(groups.getDateFinish());
        session.merge(groups1);
    }

    @Override
    public void clear() {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Groups ").executeUpdate();

    }
}
