package com.nadiajaay.pika_base.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long replyId;

    private String content;

    private LocalDateTime createdDate;

    private String authorName;

    @ManyToOne
    @JoinColumn(name = "discussion_id")
    private Discussion discussion;


    public Reply(String content, String authorName, Discussion discussion) {
        this.content = content;
        this.createdDate = LocalDateTime.now();
        this.authorName = authorName;
        this.discussion = discussion;
    }

    public Reply() {
    }


    public Long getReplyId() {
        return this.replyId;
    }

    public void setReplyId(Long replyId) {
        this.replyId = replyId;
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

    public Discussion getDiscussion() {
        return this.discussion;
    }

    public void setDiscussion(Discussion discussion) {
        this.discussion = discussion;
    }


}
