package team.repository;

import team.model.Groups;

import java.util.List;

public interface GroupsRepo {
    List<Groups> findAll(Long id);

    Groups findById(Long id);

    void save(Groups groups);

    void delete(Long id);

    void updateGroups(Long id, Groups groups);

    void clear();
}
