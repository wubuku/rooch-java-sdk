package com.github.wubuku.rooch.bean;

public class AnnotatedStringView implements AnnotatedMoveValueView {
    private String value;

    public AnnotatedStringView() {
    }

    public AnnotatedStringView(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "AnnotatedStringView{" +
                "value='" + value + '\'' +
                '}';
    }
}
