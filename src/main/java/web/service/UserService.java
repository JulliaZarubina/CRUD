package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> allUsers();
    User getById(long id);
    void add(User user);
    void edit(User user);
    void delete(long id);
}
