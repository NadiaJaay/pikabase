package com.nadiajaay.pika_base.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nadiajaay.pika_base.model.Game;

public interface GameRepository extends JpaRepository<Game, Long>{
    
}
