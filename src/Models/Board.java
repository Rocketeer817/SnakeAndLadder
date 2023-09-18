package Models;

import Strategy.GameWinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Board {
    List<Cell> cells;
    List<Player> players;
    List<Ladder> ladders;
    List<Snake> snakes;

    public BoardStatus boardStatus;

    public Player winningPlayer;
    int nextPlayer;

    GameWinningStrategy gameWinningStrategy;

    public static BoardBuilder getBuilder(){
        return new BoardBuilder();
    }

    public void makeNextMove() {
        //1. Get the player details to play
        //2. Let the player make next move
        //3. validate if the player won
        //4. if the game is over, update the winner in the board
        //5. update the nextPlayer
    }



    public static class BoardBuilder{
        private List<Player> players;
        private List<Cell> cells;
        private List<Snake> snakes;
        private List<Ladder> ladders;


        public List<Player> getPlayers() {
            return players;
        }

        public BoardBuilder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public List<Cell> getCells() {
            return cells;
        }

        public BoardBuilder setCells(List<Cell> cells) {
            this.cells = cells;
            return this;
        }

        public List<Snake> getSnakes() {
            return snakes;
        }

        public BoardBuilder setSnakes(List<Snake> snakes) {
            this.snakes = snakes;
            return this;
        }

        public List<Ladder> getLadders() {
            return ladders;
        }

        public BoardBuilder setLadders(List<Ladder> ladders) {
            this.ladders = ladders;
            return this;
        }

        //Board board = Board.getBuilder().setPlayers(---).setCells().setLadders().setSnakes().build();

        public Board build(){
            Board board = new Board();
            board.cells = new ArrayList<>();

            for(int i=0;i<=100;i++){
                board.cells.add(new Cell(i));
            }


            //validate the no of players
            if(players==null || ladders==null || cells==null || snakes==null ||  players.size()<2){
                throw new IllegalArgumentException("No of players should be >= 2");
            }


            board.players = players;

            for(Ladder ladder : ladders){
                if(ladder.fromCellNo>=ladder.toCellNo){
                    throw new IllegalArgumentException();
                }
            }

            for(Snake snake : snakes){
                if(snake.fromCellNo<=snake.toCellNo){
                    throw new IllegalArgumentException();
                }
            }

            board.ladders = ladders;
            board.snakes = snakes;

            return board;
        }
    }
}
