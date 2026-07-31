package com.nadiajaay.pika_base.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nadiajaay.pika_base.model.Discussion;

public interface DiscussionRepository extends JpaRepository<Discussion, Long> {
    
}
