package com.classes;

public class Game {
    private int score;

    public void roll(int i) {
         score += i;
    }

    public int score() {
        return score;
    }
}
