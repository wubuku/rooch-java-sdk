package com.github.wubuku.rooch.bcs;

import java.util.Objects;

/**
 * From Move definition:
 * <pre>
 *     struct Object<T> {
 *         id: ObjectID,
 *         owner: address,
 *         //TODO define shared and immutable
 *         //shared: bool,
 *         //immutable: bool,
 *         // The value must be the last field
 *         value: T,
 *     }
 * </pre>
 *
 * @param <T>
 */
public class MoveOSStdObject<T> {
    public MoveOSStdObjectID id;
    public AccountAddress owner;
    public T value;

    public MoveOSStdObject() {
    }

    public MoveOSStdObject(MoveOSStdObjectID id, AccountAddress owner, T value) {
        this.id = id;
        this.owner = owner;
        this.value = value;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static <T> MoveOSStdObject<T> deserialize(
            com.novi.serde.Deserializer deserializer,
            TypedDeserializer<T> valueDeserialize
    ) throws com.novi.serde.DeserializationError {
        deserializer.increase_container_depth();
        MoveOSStdObject value = new MoveOSStdObject();
        value.id = MoveOSStdObjectID.deserialize(deserializer);
        value.owner = AccountAddress.deserialize(deserializer);
        value.value = valueDeserialize.deserialize(deserializer);
        deserializer.decrease_container_depth();
        return value;
    }


    public static <T> MoveOSStdObject<T> bcsDeserialize(
            byte[] input,
            TypedDeserializer<T> valueDeserialize
    ) throws com.novi.serde.DeserializationError {
        if (input == null) {
            throw new com.novi.serde.DeserializationError("Cannot deserialize null array");
        }
        com.novi.serde.Deserializer deserializer = new com.novi.bcs.BcsDeserializer(input);
        MoveOSStdObject<T> value = deserialize(deserializer, valueDeserialize);
        if (deserializer.get_buffer_offset() < input.length) {
            throw new com.novi.serde.DeserializationError("Some input bytes were not read");
        }
        return value;
    }


    public void serialize(
            com.novi.serde.Serializer serializer,
            TypedSerializer<T> valueSerialize
    ) throws com.novi.serde.SerializationError {
        serializer.increase_container_depth();
        id.serialize(serializer);
        owner.serialize(serializer);
        valueSerialize.serialize(serializer, value);
        serializer.decrease_container_depth();
    }


    public byte[] bcsSerialize(
            TypedSerializer<T> valueSerialize
    ) throws com.novi.serde.SerializationError {
        com.novi.serde.Serializer serializer = new com.novi.bcs.BcsSerializer();
        serialize(serializer, valueSerialize);
        return serializer.get_bytes();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoveOSStdObject<?> that = (MoveOSStdObject<?>) o;
        return
                Objects.equals(id, that.id)
                        && Objects.equals(owner, that.owner)
                        && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, owner, value);
    }
}
