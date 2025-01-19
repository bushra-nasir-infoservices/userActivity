package com.infoservices.user_activity.service;

import com.infoservices.user_activity.entity.Bookmark;
import com.infoservices.user_activity.repository.BookmarksRepository;
import com.infoservices.user_activity.service.interfaces.BookmarksService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookmarksServiceImpl implements BookmarksService {

    private final BookmarksRepository bookmarksRepository;

    public BookmarksServiceImpl(BookmarksRepository bookmarksRepository) {
        this.bookmarksRepository = bookmarksRepository;
    }

    @Override
    public List<Bookmark> getAllBookmarks() {
        return bookmarksRepository.findAll();
    }

}
