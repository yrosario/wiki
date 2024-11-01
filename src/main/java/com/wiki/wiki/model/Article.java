package com.wiki.wiki.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty
    private Long id;

    private String title;
    private String content;


    @ManyToMany
    @JoinTable(
            name = "article_edits",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    @JsonProperty
    private Set<User> createdBy = new HashSet<>();

    public Article() {
    }

    public Article(String title, String content, Long id) {
        this.title = title;
        this.content = content;
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setCreatedBy(User user) {
        this.createdBy.add(user);
    }

    public Set<User> getCreatedBy() {
        return createdBy;
    }

}
