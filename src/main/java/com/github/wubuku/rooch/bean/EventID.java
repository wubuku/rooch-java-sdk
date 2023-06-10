package com.github.wubuku.rooch.bean;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;

public class EventID {
    @JsonProperty("event_handle_id")
    private String eventHandleId;
    @JsonProperty("event_seq")
    private BigInteger eventSeq;

    public String getEventHandleId() {
        return eventHandleId;
    }

    public void setEventHandleId(String eventHandleId) {
        this.eventHandleId = eventHandleId;
    }

    public BigInteger getEventSeq() {
        return eventSeq;
    }

    public void setEventSeq(BigInteger eventSeq) {
        this.eventSeq = eventSeq;
    }

    @Override
    public String toString() {
        return "EventID{" +
                "eventHandleId='" + eventHandleId + '\'' +
                ", eventSeq=" + eventSeq +
                '}';
    }
}
