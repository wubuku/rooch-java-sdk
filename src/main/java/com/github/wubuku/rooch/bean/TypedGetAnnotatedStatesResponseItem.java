package com.github.wubuku.rooch.bean;

public class TypedGetAnnotatedStatesResponseItem<T> extends AbstractGetAnnotatedStatesResponseItem<T> {

    @Override
    public String toString() {
        return "TypedGetAnnotatedStatesResponseItem{" +
                "state=" + getState() +
                ", moveValue=" + getMoveValue() +
                '}';
    }
}
