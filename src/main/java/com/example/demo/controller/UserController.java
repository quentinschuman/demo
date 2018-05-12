package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
    private List<User> getUserlist() {
        return userRepository.listUser();
    }
    @GetMapping
    public ModelAndView list(Model model){
        model.addAttribute("userList",userRepository.listUser());
        model.addAttribute("title","用户管理");
        return new ModelAndView("users/list","userModel",model);
    }

    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Long id,Model model){
        User user=userRepository.getUserById(id);
        model.addAttribute("user",user);
        model.addAttribute("title","查看用户");
        return new ModelAndView("users/view","userModel",model);
    }

    @GetMapping("/form")
    public ModelAndView createForm(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("title","创建用户");
        return new ModelAndView("users/form","userModel",model);
    }

    @PostMapping
    public ModelAndView create(User user) {
        user = userRepository.saveOrUpdateUser(user);
        return new ModelAndView("redirect:/users");
    }

    @GetMapping(value = "delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id, Model model) {
        userRepository.deleteUser(id);

        model.addAttribute("userList", getUserlist());
        model.addAttribute("title", "删除用户");
        return new ModelAndView("users/list", "userModel", model);
    }

    @GetMapping(value = "modify/{id}")
    public ModelAndView modifyForm(@PathVariable("id") Long id, Model model) {
        User user = userRepository.getUserById(id);

        model.addAttribute("user", user);
        model.addAttribute("title", "修改用户");
        return new ModelAndView("users/form", "userModel", model);
    }
}
