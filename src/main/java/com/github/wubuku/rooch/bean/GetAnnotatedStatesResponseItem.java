package com.github.wubuku.rooch.bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class GetAnnotatedStatesResponseItem extends AbstractGetAnnotatedStatesResponseItem<AnnotatedMoveValueView> {

    @Override
    @JsonDeserialize(using = AnnotatedMoveValueViewDeserializer.class)
    public AnnotatedMoveValueView getMoveValue() {
        return super.getMoveValue();
    }

    @Override
    public String toString() {
        return "GetAnnotatedStatesResponseItem{" +
                "state=" + getState() +
                ", moveValue=" + getMoveValue() +
                '}';
    }
}
