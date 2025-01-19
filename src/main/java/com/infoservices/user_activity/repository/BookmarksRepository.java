package com.infoservices.user_activity.repository;

import com.infoservices.user_activity.entity.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookmarksRepository extends JpaRepository<Bookmark,Integer> {
}
