package com.github.wubuku.rooch.bcs;

public interface TypedSerializer<T> {
    void serialize(com.novi.serde.Serializer serializer, T value) throws com.novi.serde.SerializationError;
}
