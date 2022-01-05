package web.service;


import web.dao.UserDaoImpl;
import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier(value = "userDaoImpl")
    private UserDaoImpl userDao;

    @Override
    public List<User> allUsers() {
        return userDao.allUsers();
    }

    @Override
    public User getById(long id) {
        return userDao.getById(id);
    }

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional
    @Override
    public void edit(User user) {
        userDao.edit(user);
    }

    @Transactional
    @Override
    public void delete(long id) {
        userDao.delete(id);
    }

    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

}
