package com.github.wubuku.rooch.bean;

public class GetAnnotatedStatesResponseMoveStructItem<T> extends AbstractGetAnnotatedStatesResponseItem<AnnotatedMoveStructView<T>> {
    @Override
    public String toString() {
        return "GetAnnotatedStatesResponseMoveStructItem{" +
                "state=" + getState() +
                ", moveValue=" + getMoveValue() +
                '}';
    }
}
