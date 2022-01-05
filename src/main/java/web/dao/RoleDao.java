package web.dao;

import web.model.Role;

import java.util.List;

public interface RoleDao {

    public List<Role> allRoles();
    public void add(Role role);
    public void delete(long Role_id);
    public Role getById(long Role_id);
}
