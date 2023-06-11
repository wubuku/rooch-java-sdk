package com.github.wubuku.rooch.bcs;

public interface TypedDeserializer<T> {
    T deserialize(com.novi.serde.Deserializer deserializer) throws com.novi.serde.DeserializationError;
}
