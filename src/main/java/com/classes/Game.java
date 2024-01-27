package com.classes;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int score;
    List<Integer> rollSquares = new ArrayList<>(21);

    public void roll(int i) {
        rollSquares.add(i);
        checkForSpares(i);
    }

    private void checkForSpares(int i) {
        if (rollSquares.size() > 2) {
            int first = rollSquares.get(rollSquares.size() - 3);
            int second = rollSquares.get(rollSquares.size() - 2);
            if (first + second == 10) {
                score = first + second + i;
            }
        }
        score += i;
    }

    public int score() {
        return score;
    }
}
