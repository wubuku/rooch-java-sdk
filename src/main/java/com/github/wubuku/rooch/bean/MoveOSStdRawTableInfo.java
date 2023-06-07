package com.github.wubuku.rooch.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MoveOSStdRawTableInfo {
    @JsonProperty("state_root")
    private String stateRoot;

    public String getStateRoot() {
        return stateRoot;
    }

    public void setStateRoot(String stateRoot) {
        this.stateRoot = stateRoot;
    }

    @Override
    public String toString() {
        return "MoveOSStdRawTableInfo{" +
                "stateRoot='" + stateRoot + '\'' +
                '}';
    }
}
