package com.github.wubuku.rooch.bcs.tests;

import com.github.wubuku.rooch.bcs.MoveOSStdTable;

import java.math.BigInteger;

public class TestSomethingProperties {
    public Integer i;
    public BigInteger j;
    public MoveOSStdTable fooTable;
    public MoveOSStdTable barTable;

    public static TestSomethingProperties deserialize(com.novi.serde.Deserializer deserializer) throws com.novi.serde.DeserializationError {
        deserializer.increase_container_depth();
        TestSomethingProperties value = new TestSomethingProperties();
        value.i = deserializer.deserialize_u32();
        value.j = deserializer.deserialize_u128();
        value.fooTable = MoveOSStdTable.deserialize(deserializer);
        value.barTable = MoveOSStdTable.deserialize(deserializer);
        deserializer.decrease_container_depth();
        return value;
    }

    public static TestSomethingProperties bcsDeserialize(byte[] input) throws com.novi.serde.DeserializationError {
        if (input == null) {
            throw new com.novi.serde.DeserializationError("Cannot deserialize null array");
        }
        com.novi.serde.Deserializer deserializer = new com.novi.bcs.BcsDeserializer(input);
        TestSomethingProperties value = deserialize(deserializer);
        if (deserializer.get_buffer_offset() < input.length) {
            throw new com.novi.serde.DeserializationError("Some input bytes were not read");
        }
        return value;
    }


    public void serialize(com.novi.serde.Serializer serializer) throws com.novi.serde.SerializationError {
        serializer.increase_container_depth();
        serializer.serialize_u32(i);
        serializer.serialize_u128(j);
        fooTable.serialize(serializer);
        barTable.serialize(serializer);
        //TraitHelpers.serialize_vector_TypeTag(type_params, serializer);
        serializer.decrease_container_depth();
    }

    public byte[] bcsSerialize() throws com.novi.serde.SerializationError {
        com.novi.serde.Serializer serializer = new com.novi.bcs.BcsSerializer();
        serialize(serializer);
        return serializer.get_bytes();
    }

}
