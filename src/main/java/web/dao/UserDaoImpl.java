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
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(long id){
        entityManager.remove(getById(id));
    }

    @Override
    public void edit(User user) {
        entityManager.createQuery("update User user set user.name=:sName, user.lastName=:slastName where user.id = :id")
                .setParameter("id", user.getId())
                .setParameter("sName", user.getName())
                .setParameter("slastName", user.getLastName())
                .executeUpdate();
    }

    @Override
    public User getById(long id) {
        return entityManager.createQuery("select user from User user where user.id = :id", User.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public User getUserByUsername(String name) {
        return entityManager.createQuery(" select user from User user WHERE user.username = :username", User.class)
                .setParameter("username", name)
                .getSingleResult();
    }
}
