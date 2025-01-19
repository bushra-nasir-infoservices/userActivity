package com.infoservices.user_activity.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "bookmarks")
public class Bookmark {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int bookmarkId;

    @Column
    public boolean isBookmarked;
}
