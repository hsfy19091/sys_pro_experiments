package com.hsfy.experiment02.experiments.repository;

import com.hsfy.experiment02.experiments.entity.Address;
import com.hsfy.experiment02.experiments.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class UserRepository {
    @PersistenceContext
    private EntityManager em;

    // 添加用户，并返回包括数据库时间戳的用户对象
    public User addUser(User user) {
        em.persist(user);
        //此时user对象为受管状态,已经包含id等信息
        return user;
    }

    // 添加地址，并指定地址对应的用户
    public Address addAddress(Address address, int uid) {
        //根据uid查找用户
        User user = em.find(User.class, uid);
        address.setUser(user);
        em.persist(address);
        return address;
    }

    // 更新指定ID用户的姓名
    public User updateUser(int uid, String newName) {
        User user = em.find(User.class, uid);
        user.setName(newName);
        return user;
    }

    // 更新指定地址为指定用户 尝试使用merge()，以及find()2种方法分别实现
    public Address updateAddress(int aid, int uid) {
        User user = em.find(User.class, uid);
        Address address = em.find(Address.class, aid);
        address.setUser(user);
        return address;
    }

    // 返回指定用户的全部地址，没有返回空集合，而非null

    public List<Address> listAddresses(int uid) {
        User user = em.find(User.class, uid);
        //size为0代表为空,返回空的list
        return user.getAddresses().size() != 0 ? user.getAddresses() : new ArrayList<Address>();
    }

    public void removeAddress(int aid) {
        Address address = em.find(Address.class, aid);
        em.remove(address);
        em.flush();
    }

    // 删除用户，设置级联操作或手动删除相关地址
    public void removeUser(int uid) {
        User user = em.find(User.class, uid);
        em.remove(user);
    }
}