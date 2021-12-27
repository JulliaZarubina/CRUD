package web.dao;

import web.model.User;

import org.springframework.stereotype.Component;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;


@Component

public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> allUsers() {
        return entityManager.createQuery("select user from User user").getResultList();
    }
    public void add(User user) {
        entityManager.persist(user);
    }
    public void delete(User user){
        entityManager.createQuery("delete from User user where user.id = :id")
                .setParameter("id", user.getId())
                .executeUpdate();
    }

    public void edit(User user) {
        entityManager.createQuery("update User user set user.name=:sName, user.lastName=:slastName where user.id = :id")
                .setParameter("id", user.getId())
                .setParameter("sName", user.getName())
                .setParameter("slastName", user.getLastName())
                .executeUpdate();
    }
    public User getById(int id) {
        return entityManager.createQuery("select user from User user where user.id = :id", User.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
