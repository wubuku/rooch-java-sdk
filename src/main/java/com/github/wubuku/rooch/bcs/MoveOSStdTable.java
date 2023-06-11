package com.github.wubuku.rooch.bcs;

import java.util.Objects;

/**
 * From Move definition:
 * <pre>
 *     struct Table<phantom K: copy + drop, phantom V> has store {
 *         handle: ObjectID,
 *     }
 * </pre>
 */
public class MoveOSStdTable {
    public MoveOSStdObjectID handle;

    public MoveOSStdTable() {
    }

    public MoveOSStdTable(MoveOSStdObjectID handle) {
        this.handle = handle;
    }


    public static MoveOSStdTable deserialize(com.novi.serde.Deserializer deserializer) throws com.novi.serde.DeserializationError {
        deserializer.increase_container_depth();
        MoveOSStdTable value = new MoveOSStdTable();
        value.handle = MoveOSStdObjectID.deserialize(deserializer);
        deserializer.decrease_container_depth();
        return value;
    }

    public static MoveOSStdTable bcsDeserialize(byte[] input) throws com.novi.serde.DeserializationError {
        if (input == null) {
            throw new com.novi.serde.DeserializationError("Cannot deserialize null array");
        }
        com.novi.serde.Deserializer deserializer = new com.novi.bcs.BcsDeserializer(input);
        MoveOSStdTable value = deserialize(deserializer);
        if (deserializer.get_buffer_offset() < input.length) {
            throw new com.novi.serde.DeserializationError("Some input bytes were not read");
        }
        return value;
    }


    public void serialize(com.novi.serde.Serializer serializer) throws com.novi.serde.SerializationError {
        serializer.increase_container_depth();
        handle.serialize(serializer);
        serializer.decrease_container_depth();
    }

    public byte[] bcsSerialize() throws com.novi.serde.SerializationError {
        com.novi.serde.Serializer serializer = new com.novi.bcs.BcsSerializer();
        serialize(serializer);
        return serializer.get_bytes();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoveOSStdTable that = (MoveOSStdTable) o;
        return Objects.equals(handle, that.handle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(handle);
    }

    @Override
    public String toString() {
        return "MoveOSStdTable{" +
                "handle=" + handle +
                '}';
    }
}
