package com.infoservices.user_activity.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "bookmarks")
public class Bookmark {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int bookmarkId;

    @ManyToOne
    @Column(name = "user_id")
    public int userId;

    @Column(name = "article_id" , nullable = false)
    public int articleId;

    @CreationTimestamp
    @Column(name = "created_at")
    public Date createdAt;

    public Bookmark() {}

    public Bookmark(int bookmarkId, int userId, int articleId, Date createdAt) {
        this.bookmarkId = bookmarkId;
        this.userId = userId;
        this.articleId = articleId;
        this.createdAt = createdAt;
    }

    public int getBookmarkId() {
        return bookmarkId;
    }

    public void setBookmarkId(int bookmarkId) {
        this.bookmarkId = bookmarkId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
