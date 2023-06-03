package com.github.wubuku.rooch.bean;

import java.util.Map;

public class MoveValue {
    private Integer abilities;
    private String type;
    private Map<String, Object> value;//todo

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

    public Map<String, Object> getValue() {
        return value;
    }

    public void setValue(Map<String, Object> value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "MoveValue{" +
                "abilities=" + abilities +
                ", type='" + type + '\'' +
                ", value=" + value +
                '}';
    }
}
