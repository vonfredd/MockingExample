package com.classes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {
    Game game = new Game();

    @Test
    @DisplayName("Score should return 5 if 5 pins are knocked down")
    void scoreShouldReturn5If5PinsAreKnockedDown(){
        game.roll(5);
        int score = game.score();
        assertThat(score).isEqualTo(5);
    }
    
    @Test
    @DisplayName("Should return sum of both rolls if two rolls have been played")
    void shouldReturnSumIfTwoRollsHaveBeenPlayed(){
        game.roll(2);
        game.roll(5);
        assertThat(game.score()).isEqualTo(7);
    }

}