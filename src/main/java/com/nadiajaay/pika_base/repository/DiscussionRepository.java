package com.nadiajaay.pika_base.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nadiajaay.pika_base.model.Discussion;

public interface DiscussionRepository extends JpaRepository<Discussion, Long> {
    List<Discussion> findByGameGameId(Long gameId);
}
