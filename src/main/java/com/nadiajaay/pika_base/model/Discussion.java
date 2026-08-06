package com.nadiajaay.pika_base.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Discussion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long discussionId;

    @NotBlank(message = "Title cannot be blank.")
    private String title;

    @NotBlank(message = "Content cannot be blank.")
    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createdDate;

    @NotBlank(message = "Author name cannot be blank.")
    private String authorName;
    
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    public Discussion(String title, String content, String authorName, Game game) {
        this.title = title;
        this.content = content;
        this.createdDate = LocalDateTime.now();
        this.authorName = authorName;
        this.game = game;
    }


    public Discussion() {
    }


    public Long getDiscussionId() {
        return this.discussionId;
    }

    public void setDiscussionId(Long discussionId) {
        this.discussionId = discussionId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Game getGame() {
        return this.game;
    }

    public void setGame(Game game) {
        this.game = game;
    }


}
