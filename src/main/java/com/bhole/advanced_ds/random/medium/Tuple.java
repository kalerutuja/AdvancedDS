package com.bhole.advanced_ds.random.medium;

import java.util.Objects;

public class Tuple {
    int i,j;
    public Tuple(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple tuple = (Tuple) o;
        return i == tuple.i &&
                j == tuple.j;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j);
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)",this.i, this.j);
    }
}