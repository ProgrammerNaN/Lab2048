package ru.sber.school.lab2048;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Component
public class Game2048 implements Game {

    public static final int GAME_SIZE = 4;
    private static final Random RANDOM = new Random();

    private final GameHelper helper;
    private final Board<Key, Integer> board;

    @Autowired
    public Game2048(GameHelper gameHelper, Board<Key, Integer> board) {
        this.helper = gameHelper;
        this.board = board;
    }

    public void init() {
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < GAME_SIZE * GAME_SIZE; i++) {
            values.add(null);
        }
        this.board.fillBoard(values);
        try {
            addItem();
            addItem();
        } catch (GameOverException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean canMove() {
        if (this.board.availableSpace().isEmpty()) {
            return canMergeInDirection(Direction.DOWN) ||
                    canMergeInDirection(Direction.LEFT) ||
                    canMergeInDirection(Direction.RIGHT) ||
                    canMergeInDirection(Direction.UP);
        } else {
            return true;
        }
    }

    public void move(Direction direction) throws GameOverException {

        if (canMove()) {
            switch (direction) {
                case DOWN:
                    for (int i = 0; i < GAME_SIZE; i++) {
                        List<Key> column = this.board.getColumn(i);
                        List<Integer> columnValues = this.board.getValues(column);
                        Collections.reverse(columnValues);
                        List<Integer> mergedValues = helper.moveAndMergeEqual(columnValues);
                        Collections.reverse(mergedValues);
                        setValuesToBoard(column, mergedValues);
                    }
                    addItem();
                    break;

                case LEFT:
                    for (int i = 0; i < GAME_SIZE; i++) {
                        List<Key> row = this.board.getRow(i);
                        List<Integer> rowValues = this.board.getValues(row);
                        List<Integer> mergedValues = helper.moveAndMergeEqual(rowValues);
                        setValuesToBoard(row, mergedValues);
                    }
                    addItem();
                    break;

                case UP:
                    for (int i = 0; i < GAME_SIZE; i++) {
                        List<Key> column = this.board.getColumn(i);
                        List<Integer> columnValues = this.board.getValues(column);
                        List<Integer> mergedValues = helper.moveAndMergeEqual(columnValues);
                        setValuesToBoard(column, mergedValues);
                    }
                    addItem();
                    break;

                case RIGHT:
                    for (int i = 0; i < GAME_SIZE; i++) {
                        List<Key> row = this.board.getRow(i);
                        List<Integer> rowValues = this.board.getValues(row);
                        Collections.reverse(rowValues);
                        List<Integer> mergedValues = helper.moveAndMergeEqual(rowValues);
                        Collections.reverse(mergedValues);
                        setValuesToBoard(row, mergedValues);
                    }
                    addItem();
                    break;
            }
        } else {
            throw new GameOverException();
        }

    }

    public void addItem() throws GameOverException {
        if (!this.board.availableSpace().isEmpty()) {
            List<Key> availableSpace = this.board.availableSpace();
            Key randomSpace = availableSpace.get(RANDOM.nextInt(availableSpace.size()));
            this.board.addItem(randomSpace, getRandomNumber());
        } else {
            throw new GameOverException();
        }
    }

    public Board getGameBoard() {
        return this.board;
    }

    public boolean hasWin() {
        return this.board.hasValue(2048);
    }

    private int getRandomNumber() {
        return RANDOM.nextInt(3) >= 1 ? 2 : 4;
    }

    private void setValuesToBoard(List<Key> keys, List<Integer> values) {
        for (int i = 0; i < GAME_SIZE; i++) {
            this.board.addItem(keys.get(i), values.get(i));
        }
    }

    private boolean canMergeInDirection(Direction direction) {
        switch (direction) {
            case DOWN:
                for (int i = 0; i < GAME_SIZE; i++) {
                    List<Key> column = this.board.getColumn(i);
                    List<Integer> columnValues = this.board.getValues(column);
                    Collections.reverse(columnValues);
                    if (helper.canMerge(columnValues)) return true;
                }
                break;

            case LEFT:
                for (int i = 0; i < GAME_SIZE; i++) {
                    List<Key> row = this.board.getRow(i);
                    List<Integer> rowValues = this.board.getValues(row);
                    if (helper.canMerge(rowValues)) return true;
                }
                break;

            case UP:
                for (int i = 0; i < GAME_SIZE; i++) {
                    List<Key> column = this.board.getColumn(i);
                    List<Integer> columnValues = this.board.getValues(column);
                    if (helper.canMerge(columnValues)) return true;
                }
                break;

            case RIGHT:
                for (int i = 0; i < GAME_SIZE; i++) {
                    List<Key> row = this.board.getRow(i);
                    List<Integer> rowValues = this.board.getValues(row);
                    Collections.reverse(rowValues);
                    if (helper.canMerge(rowValues)) return true;
                }
                break;
        }
        return false;
    }
}
