package com.github.wubuku.rooch.bcs.tests;

import com.github.wubuku.rooch.bcs.MoveOSStdObject;

public class TestSomethingObject extends MoveOSStdObject<TestSomethingProperties> {
    public static MoveOSStdObject<TestSomethingProperties> deserialize(com.novi.serde.Deserializer deserializer) throws com.novi.serde.DeserializationError {
        return MoveOSStdObject.deserialize(deserializer,
                TestSomethingProperties::deserialize);
    }

    public static MoveOSStdObject<TestSomethingProperties> bcsDeserialize(byte[] input) throws com.novi.serde.DeserializationError {
        if (input == null) {
            throw new com.novi.serde.DeserializationError("Cannot deserialize null array");
        }
        com.novi.serde.Deserializer deserializer = new com.novi.bcs.BcsDeserializer(input);
        MoveOSStdObject<TestSomethingProperties> value = deserialize(deserializer);
        if (deserializer.get_buffer_offset() < input.length) {
            throw new com.novi.serde.DeserializationError("Some input bytes were not read");
        }
        return value;
    }

    public void serialize(com.novi.serde.Serializer serializer) throws com.novi.serde.SerializationError {
        this.serialize(serializer, (s, v) -> v.serialize(s));
    }

    public byte[] bcsSerialize() throws com.novi.serde.SerializationError {
        com.novi.serde.Serializer serializer = new com.novi.bcs.BcsSerializer();
        serialize(serializer);
        return serializer.get_bytes();
    }

}
