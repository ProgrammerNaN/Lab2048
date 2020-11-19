package ru.sber.school.lab2048;

public interface Game {

    void init();
    boolean canMove();
    void move(Direction direction);
    void addItem();
    Board getGameBoard();
    boolean hasWin();

}
