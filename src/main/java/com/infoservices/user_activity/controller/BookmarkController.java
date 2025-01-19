package com.infoservices.user_activity.controller;

import com.infoservices.user_activity.dto.BookmarkDTO;
import com.infoservices.user_activity.entity.Bookmark;
import com.infoservices.user_activity.service.interfaces.BookmarksService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/v1/bookmark")
@RestController
public class BookmarkController {

    private BookmarksService bookmarksService;

    private final ModelMapper modelMapper;

    public BookmarkController(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public ResponseEntity<List<BookmarkDTO>> getAllBookmarks() {
        List<Bookmark> allBookmarks = bookmarksService.getAllBookmarks();
        List<BookmarkDTO> allBookmarksResponse = allBookmarks.stream()
        .map(bookmark -> modelMapper.map(bookmark, BookmarkDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(allBookmarksResponse);
    }
}
