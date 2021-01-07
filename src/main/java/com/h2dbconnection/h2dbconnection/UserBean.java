package com.h2dbconnection.h2dbconnection;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="user_table")
public class UserBean {

    @Id
    @GeneratedValue // auto generate value
    private int id;
    private String name;
    private String password;



    @OneToMany(mappedBy = "user") // hook to user using foreign key, user_id auto generate using repo
    private List<PostBean> post;

    public List<PostBean> getPost() {
        return post;
    }

    public void setPost(List<PostBean> post) {
        this.post = post;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
