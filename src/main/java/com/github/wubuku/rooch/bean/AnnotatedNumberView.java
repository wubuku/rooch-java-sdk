package com.github.wubuku.rooch.bean;

public class AnnotatedNumberView implements AnnotatedMoveValueView {
    private Number value;

    public AnnotatedNumberView() {
    }

    public AnnotatedNumberView(Number value) {
        this.value = value;
    }

    public Number getValue() {
        return value;
    }

    public void setValue(Number value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "AnnotatedNumberView{" +
                "value=" + value +
                '}';
    }
}
