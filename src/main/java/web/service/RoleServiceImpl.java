package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import web.dao.RoleDaoImpl;
import web.model.Role;

import java.util.List;
import java.util.Set;


@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    @Qualifier(value = "roleDaoImpl")
    private RoleDaoImpl roleDao;

    @Override
    public List<Role> allRoles() {
        return roleDao.allRoles();
    }

    @Override
    public Set<Role> add(Role role) {
        roleDao.add(role);
        return null;
    }

    @Override
    public void delete(long Role_id) {
        roleDao.delete(Role_id);
    }

    @Override
    public Role getById(long Role_id) {
        return roleDao.getById(Role_id);
    }
}
