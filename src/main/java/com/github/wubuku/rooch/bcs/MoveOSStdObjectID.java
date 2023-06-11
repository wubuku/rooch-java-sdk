package com.github.wubuku.rooch.bcs;

import java.util.Objects;

/**
 * From Move definition:
 * <pre>
 *     struct ObjectID has store, copy, drop {
 *         //TODO should use u256 to replace address?
 *         id: address,
 *     }
 * </pre>
 */
public class MoveOSStdObjectID {
    public AccountAddress id;

    public MoveOSStdObjectID() {
    }

    public MoveOSStdObjectID(AccountAddress id) {
        this.id = id;
    }

    public static MoveOSStdObjectID deserialize(com.novi.serde.Deserializer deserializer) throws com.novi.serde.DeserializationError {
        deserializer.increase_container_depth();
        MoveOSStdObjectID value = new MoveOSStdObjectID();
        value.id = AccountAddress.deserialize(deserializer);
        deserializer.decrease_container_depth();
        return value;
    }

    public static MoveOSStdObjectID bcsDeserialize(byte[] input) throws com.novi.serde.DeserializationError {
        if (input == null) {
            throw new com.novi.serde.DeserializationError("Cannot deserialize null array");
        }
        com.novi.serde.Deserializer deserializer = new com.novi.bcs.BcsDeserializer(input);
        MoveOSStdObjectID value = deserialize(deserializer);
        if (deserializer.get_buffer_offset() < input.length) {
            throw new com.novi.serde.DeserializationError("Some input bytes were not read");
        }
        return value;
    }


    public void serialize(com.novi.serde.Serializer serializer) throws com.novi.serde.SerializationError {
        serializer.increase_container_depth();
        id.serialize(serializer);
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
        MoveOSStdObjectID moveOSStdObjectID = (MoveOSStdObjectID) o;
        return Objects.equals(id, moveOSStdObjectID.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ObjectID{" +
                "id=" + id +
                '}';
    }
}
