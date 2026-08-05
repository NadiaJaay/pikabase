package com.nadiajaay.pika_base.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nadiajaay.pika_base.model.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    List<Reply> findByDiscussionDiscussionId(Long discussionId);
    void deleteByDiscussionDiscussionId(Long discussionId);
}
