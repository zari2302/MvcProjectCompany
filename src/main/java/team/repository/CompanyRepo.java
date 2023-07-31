package team.repository;

import team.model.Company;

import java.util.List;

public interface CompanyRepo {
    List<Company> findAll();

    Company findById(Long id);

    void save(Company company);

    void delete(Long id);

    void updateCompany(Long id, Company company);

    void clear();


}
