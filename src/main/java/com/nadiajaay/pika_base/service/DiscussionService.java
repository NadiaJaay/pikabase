package com.nadiajaay.pika_base.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nadiajaay.pika_base.model.Discussion;
import com.nadiajaay.pika_base.model.Game;
import com.nadiajaay.pika_base.repository.DiscussionRepository;
import com.nadiajaay.pika_base.repository.GameRepository;
import com.nadiajaay.pika_base.repository.ReplyRepository;
import org.springframework.transaction.annotation.Transactional;
@Service
public class DiscussionService {
    private final DiscussionRepository discussionRepository;
    private final GameRepository gameRepository;
    private final ReplyRepository replyRepository;


    public DiscussionService(DiscussionRepository discussionRepository, GameRepository gameRepository, ReplyRepository replyRepository) {
        this.discussionRepository = discussionRepository;
        this.gameRepository = gameRepository;
        this.replyRepository = replyRepository;
    }
    
    public List<Discussion> getAllDiscussions() {
        return discussionRepository.findAll();
    }

    public Optional<Discussion> getDiscussionById(Long discussionId) {
        return discussionRepository.findById(discussionId);
    }

    public List<Discussion> getDiscussionsByGameId(Long gameId) {
        return discussionRepository.findByGameGameId(gameId);
    }

    public Optional<Discussion> addDiscussion(Long gameId, Discussion discussion) {
        Optional<Game> game = gameRepository.findById(gameId);

        if (game.isEmpty()) {
            return Optional.empty();
        }

        discussion.setGame(game.get());
        return Optional.of(discussionRepository.save(discussion));
        
    }

    @Transactional
    public boolean deleteDiscussion(Long discussionId) {
        if (!discussionRepository.existsById(discussionId)) {
            return false;
        }

        replyRepository.deleteByDiscussionDiscussionId(discussionId);
        discussionRepository.deleteById(discussionId);

        return true;
    }
}
