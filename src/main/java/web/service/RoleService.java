package web.service;

import web.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    public List<Role> allRoles();
    public Set<Role> add(Role role);
    public void delete(long Role_id);
    public Role getById(long Role_id);
}
