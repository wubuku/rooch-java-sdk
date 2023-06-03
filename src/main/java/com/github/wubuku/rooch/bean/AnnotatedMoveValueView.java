package com.github.wubuku.rooch.bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = AnnotatedMoveValueViewDeserializer.class)
public interface AnnotatedMoveValueView {
}
