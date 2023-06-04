package com.github.wubuku.rooch.bean;

public abstract class GetAnnotatedStatesResponseMoveStructItem<ValueT> extends AbstractGetAnnotatedStatesResponseItem<AnnotatedMoveStructView<ValueT>> {
    @Override
    public String toString() {
        return "GetAnnotatedStatesResponseMoveStructItem{" +
                "state=" + getState() +
                ", moveValue=" + getMoveValue() +
                '}';
    }
}
