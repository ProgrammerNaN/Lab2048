package ru.sber.school.lab2048;

import java.util.ArrayList;
import java.util.List;

public class SquareBoard<V> extends Board<Key, V> {

    public SquareBoard(int size) {
        super(size, size);
    }

    public void fillBoard(List<V> list) {
        if (list.size() == width * height) {
            for (int i = 0; i < this.height; i++) {
                for (int j = 0; j < this.width; j++) {
                    this.board.put(new Key(i, j), list.get(i * width + j));
                }
            }
        } else {
            throw new RuntimeException("Ошибка инициализации приложения!");
        }
    }

    public List<Key> availableSpace() {
        List<Key> keys = new ArrayList<>();

        for (Key key: this.board.keySet()) {
            if (board.get(key) == null) {
                keys.add(key);
            }
        }

        return keys;
    }

    public void addItem(Key key, V value) {
        this.board.put(key, value);
    }

    public Key getKey(int i, int j) {
        for (Key key : this.board.keySet()) {
            if (key.getI() == i && key.getJ() == j) {
                return key;
            }
        }

        return null;
    }

    public V getValue(Key key) {
        return board.get(key);
    }

    public List<Key> getColumn(int j) {
        List<Key> keys = new ArrayList<>();
        for (Key key : this.board.keySet()) {
            if (key.getJ() == j) {
                keys.add(key);
            }
        }
        keys.sort(null);
        return keys;
    }

    public List<Key> getRow(int i) {
        List<Key> keys = new ArrayList<>();
        for (Key key : this.board.keySet()) {
            if (key.getI() == i) {
                keys.add(key);
            }
        }
        keys.sort(null);
        return keys;
    }

    public boolean hasValue(V value) {
        return this.board.containsValue(value);
    }

    public List<V> getValues(List<Key> keys) {
        List<V> values = new ArrayList<>();
        for (Key key : keys) {
            values.add(this.board.get(key));
        }
        return values;
    }
}
