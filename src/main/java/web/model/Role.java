package web.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Role_id;

    @Column(name = "role_name")
    private String Role_name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role(int role_id, String role_name) {
        Role_id = role_id;
        Role_name = role_name;
    }

    public Role() {
    }

    @Override
    public String getAuthority() {
        return "ROLE_" + getRole_name();
    }

    public int getRole_id() {
        return Role_id;
    }

    public void setRole_id(int role_id) {
        Role_id = role_id;
    }

    public String getRole_name() {
        return Role_name;
    }

    public void setRole_name(String role_name) {
        Role_name = role_name;
    }
}

