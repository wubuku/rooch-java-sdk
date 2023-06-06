package com.github.wubuku.rooch.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;

public class MoveOSEvent<T> {
    @JsonProperty("event_id")
    private EventID eventId;
    private String sender;
    @JsonProperty("tx_hash")
    private String txHash;
    @JsonProperty("type_tag")
    private String typeTag;
    @JsonProperty("event_data")
    private String eventData;
    @JsonProperty("parsed_json") //todo rename this?
    private AnnotatedMoveStructView<T> parsedEventData;
    @JsonProperty("timestamp_ms")
    private Long timestampMs;
    @JsonProperty("block_height")
    private BigInteger blockHeight;
    @JsonProperty("event_index")
    private Long eventIndex;

    public EventID getEventId() {
        return eventId;
    }

    public void setEventId(EventID eventId) {
        this.eventId = eventId;
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

    public String getTypeTag() {
        return typeTag;
    }

    public void setTypeTag(String typeTag) {
        this.typeTag = typeTag;
    }

    public String getEventData() {
        return eventData;
    }

    public void setEventData(String eventData) {
        this.eventData = eventData;
    }

    public AnnotatedMoveStructView<T> getParsedEventData() {
        return parsedEventData;
    }

    public void setParsedEventData(AnnotatedMoveStructView<T> parsedEventData) {
        this.parsedEventData = parsedEventData;
    }

    public Long getTimestampMs() {
        return timestampMs;
    }

    public void setTimestampMs(Long timestampMs) {
        this.timestampMs = timestampMs;
    }

    public BigInteger getBlockHeight() {
        return blockHeight;
    }

    public void setBlockHeight(BigInteger blockHeight) {
        this.blockHeight = blockHeight;
    }

    public Long getEventIndex() {
        return eventIndex;
    }

    public void setEventIndex(Long eventIndex) {
        this.eventIndex = eventIndex;
    }

    @Override
    public String toString() {
        return "MoveOSEvent{" +
                "eventId=" + eventId +
                ", sender='" + sender + '\'' +
                ", txHash='" + txHash + '\'' +
                ", typeTag='" + typeTag + '\'' +
                ", eventData='" + eventData + '\'' +
                ", parsedEventData=" + parsedEventData +
                ", timestampMs=" + timestampMs +
                ", blockHeight=" + blockHeight +
                ", eventIndex=" + eventIndex +
                '}';
    }

    public static class EventID {
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
}
