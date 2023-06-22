package main.web.dao;

import main.web.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> users = entityManager.createQuery("SELECT u FROM User u", User.class);
        return users.getResultList();
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }
}
