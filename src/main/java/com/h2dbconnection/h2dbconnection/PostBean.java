package com.h2dbconnection.h2dbconnection;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "post_table")
public class PostBean {
    @Id
    @GeneratedValue
    private int id;
    private String description;

    // auto fetch the data using user info, don'' need any filter
    @ManyToOne(fetch = FetchType.LAZY) // to stop recursive, it's fetch user and user fetch post so on
    @JsonIgnore // to stop recursive
    private UserBean user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "PostBean{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", user=" + user +
                '}';
    }
}
