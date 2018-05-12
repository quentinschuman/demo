package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * ProjectName: demo
 * User: quent
 * Date: 2018/5/11
 * Time: 21:10
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增策略
    private Long id;
    private String name;
    private String email;
    protected User(){

    }
    public User(Long id,String name,String email){
        this.id=id;
        this.name=name;
        this.email=email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString(){
        return String.format("User[id=%d,name='%s',email='%s']",id,name,email);
    }
}
