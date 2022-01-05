package web.dao;

import org.springframework.stereotype.Component;
import web.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> allRoles() {
        return entityManager.createQuery("select r from Role r", Role.class).getResultList();
    }

    @Override
    public void add(Role role) {
        entityManager.persist(role);
    }

    @Override
    public void delete(long Role_id) {
        entityManager.remove(getById(Role_id));
    }

    @Override
    public Role getById(long Role_id) {
        return entityManager.find(Role.class, Role_id);
    }

}
