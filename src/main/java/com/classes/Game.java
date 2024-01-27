package com.classes;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int score;
    List<Integer> rollSquares = new ArrayList<>(21);

    public void roll(int i) {
        rollSquares.add(i);
    }

    private void addScore() {
        score = 0;
        int gameFields = 0;
        int rollIndex = 0;
        if (rollSquares.size() == 1) {
            score = rollSquares.getFirst();
            return;
        }
        while (gameFields < 10 && rollIndex < rollSquares.size()) {
            if (rollSquares.get(rollIndex) == 10) {
                score += 10 + (rollSquares.get(rollIndex + 1) + rollSquares.get(rollIndex + 2));
                rollIndex++;
            } else if (rollSquares.get(rollIndex) + rollSquares.get(rollIndex + 1) == 10) {
                score += 10 + rollSquares.get(rollIndex+2);
                rollIndex += 2;
            } else {
                score += rollSquares.get(rollIndex) + rollSquares.get(rollIndex + 1);
                rollIndex += 2;
            }
                gameFields++;
        }
    }

    public int score() {
        addScore();
        return score;
    }
}
