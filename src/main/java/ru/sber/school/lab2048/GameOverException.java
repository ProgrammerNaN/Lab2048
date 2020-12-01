package ru.sber.school.lab2048;

public class GameOverException extends Exception {

    private static final String MESSAGE = "Game Over!";

    public GameOverException() {
        super(MESSAGE);
    }

}
