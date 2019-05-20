package com.hsfy.experiment01.experiment.repository;

import com.hsfy.experiment01.experiment.entity.Address;
import com.hsfy.experiment01.experiment.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserRepository {
    // 实体管理器
    @PersistenceContext
    private EntityManager em;

    public void addUserAddress() {
        User user = new User("BoBo");
        em.persist(user);
        Address address1 = new Address("956");
        address1.setUser(user);
        em.persist(address1);

        Address address2 = new Address("925");
        address2.setUser(user);
        em.persist(address2);
    }
}