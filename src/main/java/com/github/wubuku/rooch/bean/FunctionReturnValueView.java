package com.github.wubuku.rooch.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * From Rust definition:
 * <pre>
 * #[derive(Debug, Clone, Serialize, Deserialize)]
 * pub struct FunctionReturnValueView {
 *     pub type_tag: TypeTagView,
 *     pub value: StrView<Vec<u8>>,
 * }
 * </pre>
 */
public class FunctionReturnValueView {
    @JsonProperty("type_tag")
    private String typeTag;
    private String value;

    public FunctionReturnValueView() {
    }

    public FunctionReturnValueView(String typeTag, String value) {
        this.typeTag = typeTag;
        this.value = value;
    }

    public String getTypeTag() {
        return typeTag;
    }

    public void setTypeTag(String typeTag) {
        this.typeTag = typeTag;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "FunctionReturnValueView{" +
                "typeTag='" + typeTag + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
