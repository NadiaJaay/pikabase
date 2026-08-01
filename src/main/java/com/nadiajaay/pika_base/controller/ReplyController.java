package com.nadiajaay.pika_base.controller;

import org.springframework.web.bind.annotation.RestController;

import com.nadiajaay.pika_base.model.Reply;
import com.nadiajaay.pika_base.service.ReplyService;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ReplyController {
    private final ReplyService replyService;

    public ReplyController(ReplyService replyService) {
        this.replyService = replyService;
    }

    @GetMapping("/discussions/{discussionId}/replies")
    public ResponseEntity<List<Reply>> getRepliesByDiscussionId(@PathVariable ("discussionId") Long discussionId) {
        List<Reply> replies = replyService.getRepliesByDiscussionId(discussionId);
        return ResponseEntity.ok(replies);
    }

    @PostMapping("/discussions/{discussionId}/replies")
    public ResponseEntity<Reply> addReply(@PathVariable ("discussionId") Long discussionId, @RequestBody Reply reply) {
        Optional<Reply> replyToAdd = replyService.addReply(discussionId, reply);
        if (replyToAdd.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(replyToAdd.get());
    }

}
