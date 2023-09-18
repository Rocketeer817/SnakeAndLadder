package Strategy;

import Models.Board;

public interface GameWinningStrategy {

    boolean isGameWon(Board board);
}
