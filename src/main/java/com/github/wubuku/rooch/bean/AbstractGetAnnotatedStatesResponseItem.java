package com.github.wubuku.rooch.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class AbstractGetAnnotatedStatesResponseItem<T extends AnnotatedMoveValueView> {

    private GetStatesResponseItem state;
    @JsonProperty("move_value")
    private T moveValue;

    public GetStatesResponseItem getState() {
        return state;
    }

    public void setState(GetStatesResponseItem state) {
        this.state = state;
    }

    public T getMoveValue() {
        return moveValue;
    }

    public void setMoveValue(T moveValue) {
        this.moveValue = moveValue;
    }

}
