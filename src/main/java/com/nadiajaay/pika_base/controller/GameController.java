package com.nadiajaay.pika_base.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nadiajaay.pika_base.model.Game;
import com.nadiajaay.pika_base.service.GameService;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/games")
public class GameController {
    private final GameService gameService; 

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public ResponseEntity<List<Game>> getAllGames() {
        List<Game> games = gameService.getAllGames();
        return ResponseEntity.ok(games);
    }

    @GetMapping("/{gameId}")
    public ResponseEntity<Game> getGameById(@PathVariable("gameId") Long gameId) {
        Optional<Game> game = gameService.getGameById(gameId);

        if (game.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(game.get());
    }
    
}
