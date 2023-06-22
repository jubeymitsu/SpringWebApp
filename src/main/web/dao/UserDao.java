package main.web.dao;

import main.web.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    void save(User user);
}
