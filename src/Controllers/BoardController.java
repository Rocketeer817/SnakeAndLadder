package Controllers;

import Models.*;

import java.util.List;

public class BoardController {

    public Board createBoard(List<Player> players,List<Ladder> ladders, List<Snake> snakes){
        return Board.getBuilder().setPlayers(players).setLadders(ladders).setSnakes(snakes).build();
    }

    public void executeNextMove(Board board){
        board.makeNextMove();
    }

    public boolean isGameOver(Board board){
        return board.boardStatus==BoardStatus.FINISHED;
    }

    public Player getWinner(Board board){
        return board.winningPlayer;
    }
}
