package com.springapp.dao.daoImpl;

import com.springapp.dao.UserDao;
import com.springapp.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by oleg on 29.11.15.
 */
@Service("userJpaService")
@Repository
//@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public UserDaoImpl() {
    }

    //    @Transactional(readOnly = true)
    @Override
    public User selectById(int ID) {
        return entityManager.find(User.class, ID);
    }

    @Override
    public User save(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public void delete(User user) {
        entityManager.remove(user);
    }


    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
}