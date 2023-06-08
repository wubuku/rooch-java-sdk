package com.github.wubuku.rooch.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AnnotatedFunctionReturnValueView<T> {
    private FunctionReturnValueView value;
    @JsonProperty("move_value")
    private T moveValue;

    public FunctionReturnValueView getValue() {
        return value;
    }

    public void setValue(FunctionReturnValueView value) {
        this.value = value;
    }

    public T getMoveValue() {
        return moveValue;
    }

    public void setMoveValue(T moveValue) {
        this.moveValue = moveValue;
    }

    @Override
    public String toString() {
        return "AnnotatedFunctionReturnValueView{" +
                "value=" + value +
                ", moveValue=" + moveValue +
                '}';
    }
}
