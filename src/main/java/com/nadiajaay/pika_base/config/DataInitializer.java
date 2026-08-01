package com.nadiajaay.pika_base.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nadiajaay.pika_base.enums.Generation;
import com.nadiajaay.pika_base.model.Game;
import com.nadiajaay.pika_base.repository.GameRepository;

@Configuration
public class DataInitializer {
    
    @Bean
    public CommandLineRunner loadGames(GameRepository gameRepository) {
        return args -> {
            if (gameRepository.count() == 0) {
                gameRepository.save(new Game("Pokemon Yellow", Generation.GENERATION_I));
                gameRepository.save(new Game("Pokemon Red", Generation.GENERATION_I));
                gameRepository.save(new Game("Pokemon Blue", Generation.GENERATION_I));

                gameRepository.save(new Game("Pokemon Gold", Generation.GENERATION_II));
                gameRepository.save(new Game("Pokemon Silver", Generation.GENERATION_II));
                gameRepository.save(new Game("Pokemon Crystal", Generation.GENERATION_II));

                gameRepository.save(new Game("Pokemon Ruby", Generation.GENERATION_III));
                gameRepository.save(new Game("Pokemon Sapphire", Generation.GENERATION_III));
                gameRepository.save(new Game("Pokemon FireRed", Generation.GENERATION_III));
                gameRepository.save(new Game("Pokemon LeafGreen", Generation.GENERATION_III));
                gameRepository.save(new Game("Pokemon Emerald", Generation.GENERATION_III));

                gameRepository.save(new Game("Pokemon Diamond", Generation.GENERATION_IV));
                gameRepository.save(new Game("Pokemon Pearl", Generation.GENERATION_IV));
                gameRepository.save(new Game("Pokemon Platinum", Generation.GENERATION_IV));
                gameRepository.save(new Game("Pokemon HeartGold", Generation.GENERATION_IV));
                gameRepository.save(new Game("Pokemon SoulSilver", Generation.GENERATION_IV));

            }
        };
    }
}
