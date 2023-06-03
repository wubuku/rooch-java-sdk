package com.github.wubuku.rooch.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetAnnotatedStatesResponseItem {
    private GetStatesResponseItem state;
    @JsonProperty("move_value")
    private MoveValue moveValue;

    public GetStatesResponseItem getState() {
        return state;
    }

    public void setState(GetStatesResponseItem state) {
        this.state = state;
    }

    public MoveValue getMoveValue() {
        return moveValue;
    }

    public void setMoveValue(MoveValue moveValue) {
        this.moveValue = moveValue;
    }

    @Override
    public String toString() {
        return "GetAnnotatedStatesResponseItem{" +
                "state=" + state +
                ", moveValue=" + moveValue +
                '}';
    }
}
