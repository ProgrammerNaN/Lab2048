package ru.sber.school.lab2048;

import java.util.Objects;

public class Key implements Comparable<Key> {

    private int i;
    private int j;

    public Key(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public Integer getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public Integer getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Key key = (Key) o;
        return i == key.i &&
                j == key.j;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j);
    }

    @Override
    public String toString() {
        return "Key{" +
                "i=" + i +
                ", j=" + j +
                '}';
    }

    @Override
    public int compareTo(Key o) {
        int result = this.getI().compareTo(o.getI());
        if (result == 0) {
            result = this.getJ().compareTo(o.getJ());
        }
        return result;
    }
}
