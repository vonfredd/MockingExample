package com.classes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Game game = new Game();

    @Test
    @DisplayName("Score should return 5 if 5 pins are knocked down")
    void scoreShouldReturn5If5PinsAreKnockedDown() {
        game.roll(5);
        assertEquals(5,game.score());
    }

    @Test
    @DisplayName("Should return sum of both rolls if two rolls have been played")
    void shouldReturnSumIfTwoRollsHaveBeenPlayed() {
        game.roll(2);
        game.roll(5);
        assertEquals(7,game.score());
    }

    @Test
    @DisplayName("Should return 17 if spare is calculated correctly")
    void shouldReturn17IfSpareIsCalculatedCorrectly() {
        game.roll(5);
        game.roll(5);
        game.roll(1);
        game.roll(5);
        assertEquals(17,game.score());
    }

    @Test
    @DisplayName("Returns 1 if player has rolled one time")
    void returns1IfPlayerHasRolledOneTime() {
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
        assertEquals(35,game.score());
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
        assertEquals(300,game.score());
    }

    @Test
    @DisplayName("Should return 18 to the strike field")
    void shouldReturn18ToTheStrikeField(){
        game.roll(10);
        game.roll(5);
        game.roll(3);
        assertEquals(18,game.bonus("Strike",0));
    }
    
    @Test
    @DisplayName("Should return 11 to the spare field")
    void shouldReturn11ToTheSpareField(){
        game.roll(5);
        game.roll(5);
        game.roll(1);
        assertEquals(11,game.bonus("Spare",0));
    }
}