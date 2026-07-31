package com.nadiajaay.pika_base.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nadiajaay.pika_base.model.Game;
import com.nadiajaay.pika_base.repository.GameRepository;

@Service
public class GameService {
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Optional<Game> getGameById(Long gameId) {
        return gameRepository.findById(gameId);
    }

}

