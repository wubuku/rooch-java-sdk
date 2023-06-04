package com.github.wubuku.rooch.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Item of `rooch_getAnnotatedStates` result.
 *
 * @param <VT> AnnotatedMoveValueView Type
 */
public abstract class AbstractGetAnnotatedStatesResponseItem<VT extends AnnotatedMoveValueView> {

    private GetStatesResponseItem state;
    @JsonProperty("move_value")
    private VT moveValue;

    public GetStatesResponseItem getState() {
        return state;
    }

    public void setState(GetStatesResponseItem state) {
        this.state = state;
    }

    public VT getMoveValue() {
        return moveValue;
    }

    public void setMoveValue(VT moveValue) {
        this.moveValue = moveValue;
    }

}
