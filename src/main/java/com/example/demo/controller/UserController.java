package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
    @GetMapping
    public ModelAndView list(Model model){
        model.addAttribute("userList",userRepository.listusers());
        model.addAttribute("title","usermanager");
        return new ModelAndView("users/list","userModel",model);
    }

    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Long id,Model model){
        User user=userRepository.getUserById(id);
        model.addAttribute("user",user);
        model.addAttribute("title","viewuser");
        return new ModelAndView("users/view","userModel",model);
    }

    @GetMapping("/form")
    public ModelAndView createForm(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("title","createUser");
        return new ModelAndView("users/form","userModel",model);
    }

    @PostMapping
    public ModelAndView saveOrUpdateUser(User user){
        user=userRepository.saveOrUpdateUser(user);
        return new ModelAndView("users/save","userModel",user);
    }
}
