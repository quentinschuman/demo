package com.example.demo.repository;

import com.example.demo.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * ProjectName: demo
 * User: quent
 * Date: 2018/5/11
 * Time: 21:16
 */
public interface UserRepository extends CrudRepository<User,Long>{
//    User saveOrUpdateUser(User user);
//    void deleteUser(Long id);
//    User getUserById(Long id);
//    List<User> listUser();
}
