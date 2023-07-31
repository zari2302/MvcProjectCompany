package team.repository.repositoryImpl;

import jakarta.transaction.Transactional;
import team.model.Company;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import team.repository.CompanyRepo;

import java.util.List;
@Repository
@Transactional
public class CompanyRepoImpl implements CompanyRepo {

    private final SessionFactory sessionFactory;

    @Autowired
    public CompanyRepoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Company> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select c from Company c", Company.class).getResultList();
    }

    @Override
    public Company findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Company.class, id);
    }

    @Override
    public void save(Company company) {
        Session session = sessionFactory.getCurrentSession();
        session.save(company);

    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Company company = findById(id);
        session.delete(company);
    }

    @Override
    public void updateCompany(Long id, Company company) {
        Session session = sessionFactory.getCurrentSession();
        Company company1 = findById(id);
        company1.setCompanyName(company.getCompanyName());
        company1.setLocatedCountry(company.getLocatedCountry());
        session.merge(company1);
    }

    @Override
    public void clear() {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Company ").executeUpdate();
    }
}