package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> allUsers();
    User getById(int id);
    void add(User user);
    void edit(User user);
    void delete(User user);
}
