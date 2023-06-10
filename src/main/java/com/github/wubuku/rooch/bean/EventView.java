package com.github.wubuku.rooch.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EventView {
    @JsonProperty("event_id")
    private EventID eventId;
    @JsonProperty("type_tag")
    private String typeTag;
    @JsonProperty("event_data")
    private String eventData;
    @JsonProperty("event_index")
    private Long eventIndex;

    public EventID getEventId() {
        return eventId;
    }

    public void setEventId(EventID eventId) {
        this.eventId = eventId;
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

    public Long getEventIndex() {
        return eventIndex;
    }

    public void setEventIndex(Long eventIndex) {
        this.eventIndex = eventIndex;
    }

    @Override
    public String toString() {
        return "EventView{" +
                "eventId=" + eventId +
                ", typeTag='" + typeTag + '\'' +
                ", eventData='" + eventData + '\'' +
                ", eventIndex=" + eventIndex +
                '}';
    }
}
