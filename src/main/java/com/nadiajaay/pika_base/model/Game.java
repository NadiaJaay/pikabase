package com.nadiajaay.pika_base.model;

import com.nadiajaay.pika_base.enums.Generation;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gameId;

    @NotBlank(message = "Name cannot be blank.")
    private String name;
    
    @NotNull(message = "Generation cannot be null.")
    @Enumerated(EnumType.STRING)
    private Generation generation; 


    public Game(String name, Generation generation) {
        this.name = name;
        this.generation = generation;
    }

    public Game() {
    }

    public Long getGameId() {
        return this.gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Generation getGeneration() {
        return this.generation;
    }

    public void setGeneration(Generation generation) {
        this.generation = generation;
    }

}
