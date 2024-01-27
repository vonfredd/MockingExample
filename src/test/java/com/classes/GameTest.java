package com.classes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

    @Test
    @DisplayName("Should return true if result is 17")
    void shouldReturnTrueIfResultIs17(){
        game.roll(5);
        game.roll(5);
        game.roll(1);
        game.roll(5);
        game.roll(0);
        assertThat(game.score()).isEqualTo(17);
    }
    
    @Test
    @DisplayName("Returns 1 if player has rolled")
    void returns1IfCurrentRollIsFirstroll(){
        game.roll(5);
        assertEquals(game.rollSquares.size(),1);
    }


}