package com.nadiajaay.pika_base.controller;

import org.springframework.web.bind.annotation.RestController;

import com.nadiajaay.pika_base.model.Discussion;
import com.nadiajaay.pika_base.service.DiscussionService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class DiscussionController {
    private final DiscussionService discussionService;

    public DiscussionController(DiscussionService discussionService) {
        this.discussionService = discussionService;
    }
    
    @GetMapping("/discussions")
    public ResponseEntity<List<Discussion>> getAllDiscussions() {
        List<Discussion> discussions = discussionService.getAllDiscussions();
        return ResponseEntity.ok(discussions);
    }

    @GetMapping("/discussions/{discussionId}")
    public ResponseEntity<Discussion> getDiscussionById(@PathVariable("discussionId") Long discussionId) {
        Optional<Discussion> discussion = discussionService.getDiscussionById(discussionId);
        if (discussion.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(discussion.get()); 
    }

    @GetMapping("/games/{gameId}/discussions")
    public ResponseEntity<List<Discussion>> getDiscussionsByGameId(@PathVariable("gameId") Long gameId) {
        List<Discussion> discussions = discussionService.getDiscussionsByGameId(gameId); 
        return ResponseEntity.ok(discussions);
    }

    @PostMapping("/games/{gameId}/discussions")
    public ResponseEntity<Discussion> addDiscussion(@PathVariable ("gameId") Long gameId, @Valid @RequestBody Discussion discussion) {
        Optional<Discussion> discussionToAdd = discussionService.addDiscussion(gameId, discussion);
        if (discussionToAdd.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(discussionToAdd.get()); 
    }
    
    
    
    
}
