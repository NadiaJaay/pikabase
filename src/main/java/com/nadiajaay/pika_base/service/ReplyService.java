package com.nadiajaay.pika_base.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nadiajaay.pika_base.model.Discussion;
import com.nadiajaay.pika_base.model.Reply;
import com.nadiajaay.pika_base.repository.DiscussionRepository;
import com.nadiajaay.pika_base.repository.ReplyRepository;

@Service
public class ReplyService {
    private final ReplyRepository replyRepository;
    private final DiscussionRepository discussionRepository;

    public ReplyService(ReplyRepository replyRepository, DiscussionRepository discussionRepository) {
        this.replyRepository = replyRepository;
        this.discussionRepository = discussionRepository;
    }

    public List<Reply> getRepliesByDiscussionId(Long discussionId) {
        return replyRepository.findByDiscussionDiscussionId(discussionId);
    }

    public Optional<Reply> addReply(Long discussionId, Reply reply) {
        Optional<Discussion> discussion = discussionRepository.findById(discussionId);
        if (discussion.isEmpty()) {
            return Optional.empty();
        }

        reply.setDiscussion(discussion.get());
        return Optional.of(replyRepository.save(reply));
    }

}
