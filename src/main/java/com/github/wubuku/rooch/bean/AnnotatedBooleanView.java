package com.github.wubuku.rooch.bean;

public class AnnotatedBooleanView implements AnnotatedMoveValueView {
    private Boolean value;

    public AnnotatedBooleanView() {
    }

    public AnnotatedBooleanView(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "AnnotatedBooleanView{" +
                "value=" + value +
                '}';
    }
}
