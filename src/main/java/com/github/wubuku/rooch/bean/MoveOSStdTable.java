package com.github.wubuku.rooch.bean;

public class MoveOSStdTable {

    private String handle;

    public MoveOSStdTable() {

    }

    public MoveOSStdTable(String handle) {
        this.handle = handle;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    @Override
    public String toString() {
        return "MoveOSStdTable{" +
                "handle='" + handle + '\'' +
                '}';
    }
}
