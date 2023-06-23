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
        TypedQuery<User> users = entityManager.createQuery("select u from User u", User.class);
        return users.getResultList();
    }

    @Override
    public void save(User user) {
        if (user.getId() == 0) {
            entityManager.persist(user);
        } else {
            entityManager.merge(user);
        }
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteById(int id) {
        entityManager.createQuery("delete from User u where u.id=:userId")
                .setParameter("userId", id).executeUpdate();
    }
}
