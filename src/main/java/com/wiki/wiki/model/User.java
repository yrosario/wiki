package com.wiki.wiki.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty
    private Long id;

    @ManyToMany(mappedBy = "createdBy")
    private Set<Article> articles = new HashSet<>();

    private String username;
    private String password;

    public User() {
    }

    public User(String username, String password, Long id) {
        this.username = username;
        this.password = password;
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public Set<Article> getArticles() {
        return articles;
    }


    public void setArticles(Article article) {
        this.articles.add(article);
    }
}
