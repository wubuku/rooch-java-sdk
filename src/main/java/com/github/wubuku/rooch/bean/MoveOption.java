package com.github.wubuku.rooch.bean;

import java.util.Arrays;

public class MoveOption<T> {
    private T[] vec;

    public T[] getVec() {
        return vec;
    }

    public void setVec(T[] vec) {
        this.vec = vec;
    }

    @Override
    public String toString() {
        return "MoveOption{" +
                "vec=" + Arrays.toString(vec) +
                '}';
    }
}
