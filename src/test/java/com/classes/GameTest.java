package com.classes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Game game = new Game();

    @Test
    @DisplayName("Score should return 5 if 5 pins are knocked down")
    void scoreShouldReturn5If5PinsAreKnockedDown() {
        game.roll(5);
        int score = game.score();
        assertThat(score).isEqualTo(5);
    }

    @Test
    @DisplayName("Should return sum of both rolls if two rolls have been played")
    void shouldReturnSumIfTwoRollsHaveBeenPlayed() {
        game.roll(2);
        game.roll(5);
        assertThat(game.score()).isEqualTo(7);
    }

    @Test
    @DisplayName("Should return true if result is 17")
    void shouldReturnTrueIfResultIs17() {
        game.roll(5);
        game.roll(5);
        game.roll(1);
        game.roll(5);
        assertThat(game.score()).isEqualTo(17);
    }

    @Test
    @DisplayName("Returns 1 if player has rolled")
    void returns1IfCurrentRollIsFirstroll() {
        game.roll(5);
        assertEquals(1, game.rollSquares.size());
    }

    @Test
    @DisplayName("Given a set of rounds, strike should be added accordingly")
    void givenASetOfRoundsStrikeShouldBeAddedAccordingly() {
        game.roll(4);
        game.roll(3);
        game.roll(10);
        game.roll(4);
        game.roll(5);

        assertThat(game.score()).isEqualTo(35);
    }


    @Test
    @DisplayName("Given 13 strikes, score() should only calculate 12 of them since that is max fields")
    void given13StrikesScoreShouldOnlyCalculate12OfThemSinceThatIsMaxFields(){
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);

        assertThat(game.score()).isEqualTo(300);
    }
}