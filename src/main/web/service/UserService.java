package main.web.service;

import main.web.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void add(User user);

}
