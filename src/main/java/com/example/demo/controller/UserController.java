package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * ProjectName: demo
 * User: quent
 * Date: 2018/5/11
 * Time: 21:30
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;
//    private List<User> getUserlist() {
//        return userRepository.listUser();
//    }
    @GetMapping
    public ModelAndView list(Model model){
        model.addAttribute("userList",userRepository.findAll());
        model.addAttribute("title","用户管理");
        return new ModelAndView("users/list","userModel",model);
    }

    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Long id,Model model){
        Optional<User> user=userRepository.findById(id);
        model.addAttribute("user",user);
        model.addAttribute("title","查看用户");
        return new ModelAndView("users/view","userModel",model);
    }

    @GetMapping("/form")
    public ModelAndView createForm(Model model){
        model.addAttribute("user",new User(null,null,null));
        model.addAttribute("title","创建用户");
        return new ModelAndView("users/form","userModel",model);
    }

    @PostMapping
    public ModelAndView saveOrUpdateUser(User user){
        userRepository.save(user);
        return new ModelAndView("redirect:/users");
    }

    @GetMapping(value = "delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        userRepository.deleteById(id);
        return new ModelAndView("redirect:/users");
    }

    @GetMapping(value = "modify/{id}")
    public ModelAndView modifyForm(@PathVariable("id") Long id, Model model) {
        Optional<User> user = userRepository.findById(id);
        model.addAttribute("user", user);
        model.addAttribute("title", "修改用户");
        return new ModelAndView("users/form", "userModel", model);
    }
}
