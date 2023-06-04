package com.github.wubuku.rooch.bean;

public class AnnotatedMoveStructView<ValueT> implements AnnotatedMoveValueView {

    private Integer abilities;
    private String type;
    private ValueT value;

    public AnnotatedMoveStructView(){
    }

    public AnnotatedMoveStructView(Integer abilities, String type, ValueT value) {
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

    public ValueT getValue() {
        return value;
    }

    public void setValue(ValueT value) {
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
