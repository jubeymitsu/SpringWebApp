package main.web.dao;

import main.web.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    void save(User user);

    User getUser(int id);

    void deleteById(int id);
}
