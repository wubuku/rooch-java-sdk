package com.github.wubuku.rooch.bean;

public class GetAnnotatedStatesResponseItem extends AbstractGetAnnotatedStatesResponseItem<AnnotatedMoveValueView> {
    @Override
    public String toString() {
        return "GetAnnotatedStatesResponseItem{" +
                "state=" + getState() +
                ", moveValue=" + getMoveValue() +
                '}';
    }
}
