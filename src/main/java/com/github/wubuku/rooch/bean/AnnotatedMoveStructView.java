package com.github.wubuku.rooch.bean;

import java.util.Map;

public class AnnotatedMoveStructView<T> implements AnnotatedMoveValueView {

    private Integer abilities;
    private String type;
    private T value;

    public AnnotatedMoveStructView(){
    }

    public AnnotatedMoveStructView(Integer abilities, String type, T value) {
        this.abilities = abilities;
        this.type = type;
        this.value = value;
    }

    public Integer getAbilities() {
        return abilities;
    }

    public void setAbilities(Integer abilities) {
        this.abilities = abilities;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "AnnotatedMoveStructView{" +
                "abilities=" + abilities +
                ", type='" + type + '\'' +
                ", value=" + value +
                '}';
    }
}
