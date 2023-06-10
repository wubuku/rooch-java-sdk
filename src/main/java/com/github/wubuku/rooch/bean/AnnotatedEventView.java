package com.github.wubuku.rooch.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;

public class AnnotatedEventView<T> {
    private EventView event;
    private String sender;
    @JsonProperty("tx_hash")
    private String txHash;
    @JsonProperty("timestamp_ms")
    private Long timestampMs;

//    @JsonProperty("block_height")
//    private BigInteger blockHeight;

    @JsonProperty("parsed_event_data")
    private AnnotatedMoveStructView<T> parsedEventData;

    public EventView getEvent() {
        return event;
    }

    public void setEvent(EventView event) {
        this.event = event;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getTxHash() {
        return txHash;
    }

    public void setTxHash(String txHash) {
        this.txHash = txHash;
    }

    public Long getTimestampMs() {
        return timestampMs;
    }

    public void setTimestampMs(Long timestampMs) {
        this.timestampMs = timestampMs;
    }

    public AnnotatedMoveStructView<T> getParsedEventData() {
        return parsedEventData;
    }

    public void setParsedEventData(AnnotatedMoveStructView<T> parsedEventData) {
        this.parsedEventData = parsedEventData;
    }

    @Override
    public String toString() {
        return "AnnotatedEventView{" +
                "event=" + event +
                ", sender='" + sender + '\'' +
                ", txHash='" + txHash + '\'' +
                ", timestampMs=" + timestampMs +
                ", parsedEventData=" + parsedEventData +
                '}';
    }
}
