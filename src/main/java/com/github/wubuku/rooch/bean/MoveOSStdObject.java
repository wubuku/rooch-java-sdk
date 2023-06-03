package com.github.wubuku.rooch.bean;

public class MoveOSStdObject<ValueT> {

    private String id;
    private String owner;
    private AnnotatedMoveStructView<ValueT> value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public AnnotatedMoveStructView<ValueT> getValue() {
        return value;
    }

    public void setValue(AnnotatedMoveStructView<ValueT> value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Value{" +
                "id='" + id + '\'' +
                ", owner='" + owner + '\'' +
                ", value=" + value +
                '}';
    }


}
