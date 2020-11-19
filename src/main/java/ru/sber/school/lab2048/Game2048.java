package ru.sber.school.lab2048;

import java.util.Random;

public class Game2048 implements Game {

    private GameHelper helper = new GameHelper();
    private Board board;
    private Random random = new Random();

    public Game2048(Board board) {
        this.board = board;
    }

    public void init() {

    }

    public boolean canMove() {
        return false;
    }

    public void move(Direction direction) {

    }

    public void addItem() {

    }

    public Board getGameBoard() {
        return null;
    }

    public boolean hasWin() {
        return false;
    }
}
