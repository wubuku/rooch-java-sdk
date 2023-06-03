package com.github.wubuku.rooch.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetStatesResponseItem {
    @JsonProperty("value_type")
    private String valueType;
    private String value;

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "GetStatesResponseItem{" +
                "valueType='" + valueType + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
