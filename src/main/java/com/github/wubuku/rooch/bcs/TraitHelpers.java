package com.github.wubuku.rooch.bcs;

final class TraitHelpers {
    private TraitHelpers() {
    }

    // ///////////////////////////////////////////////////////
    // Note the naming:
    // we use `array` for fixed-length arrays
    // and `vector` for variable-length vectors.
    // ///////////////////////////////////////////////////////

    /**
     * Serializes a u8 (byte) array of fixed size 16.
     */
    public static void serializeFixed16U8Array(java.util.@com.novi.serde.ArrayLen(length = 16) List<@com.novi.serde.Unsigned Byte> value, com.novi.serde.Serializer serializer) throws com.novi.serde.SerializationError {
        if (value.size() != 16) {
            throw new IllegalArgumentException("Invalid length for fixed-size array: " + value.size() + " instead of " + 16);
        }
        for (@com.novi.serde.Unsigned Byte item : value) {
            serializer.serialize_u8(item);
        }
    }

    /**
     * Deserialize a u8 (byte) array of fixed size 16.
     */
    public static java.util.@com.novi.serde.ArrayLen(length = 16)
            List<@com.novi.serde.Unsigned Byte> deserializeFixed16U8Array(com.novi.serde.Deserializer deserializer) throws com.novi.serde.DeserializationError {
        java.util.List<@com.novi.serde.Unsigned Byte> obj = new java.util.ArrayList<@com.novi.serde.Unsigned Byte>(16);
        for (long i = 0; i < 16; i++) {
            obj.add(deserializer.deserialize_u8());
        }
        return obj;
    }


    /**
     * Serializes a u8 (byte) array of fixed size 32.
     */
    public static void serializeFixed32U8Array(java.util.@com.novi.serde.ArrayLen(length = 32) List<@com.novi.serde.Unsigned Byte> value, com.novi.serde.Serializer serializer) throws com.novi.serde.SerializationError {
        if (value.size() != 32) {
            throw new IllegalArgumentException("Invalid length for fixed-size array: " + value.size() + " instead of " + 32);
        }
        for (@com.novi.serde.Unsigned Byte item : value) {
            serializer.serialize_u8(item);
        }
    }

    public static java.util.@com.novi.serde.ArrayLen(length = 32)
            List<@com.novi.serde.Unsigned Byte> deserializeFixed32U8Array(com.novi.serde.Deserializer deserializer) throws com.novi.serde.DeserializationError {
        java.util.List<@com.novi.serde.Unsigned Byte> obj = new java.util.ArrayList<@com.novi.serde.Unsigned Byte>(32);
        for (long i = 0; i < 32; i++) {
            obj.add(deserializer.deserialize_u8());
        }
        return obj;
    }

    /**
     * Serialize an optional variable-length byte array.
     */
    public static void serializeOptionBytes(java.util.Optional<com.novi.serde.Bytes> value, com.novi.serde.Serializer serializer) throws com.novi.serde.SerializationError {
        if (value.isPresent()) {
            serializer.serialize_option_tag(true);
            serializer.serialize_bytes(value.get());
        } else {
            serializer.serialize_option_tag(false);
        }
    }

    public static java.util.Optional<com.novi.serde.Bytes> deserializeOptionBytes(com.novi.serde.Deserializer deserializer) throws com.novi.serde.DeserializationError {
        boolean tag = deserializer.deserialize_option_tag();
        if (!tag) {
            return java.util.Optional.empty();
        } else {
            return java.util.Optional.of(deserializer.deserialize_bytes());
        }
    }

    public static void serializeOptionStr(java.util.Optional<String> value, com.novi.serde.Serializer serializer) throws com.novi.serde.SerializationError {
        if (value.isPresent()) {
            serializer.serialize_option_tag(true);
            serializer.serialize_str(value.get());
        } else {
            serializer.serialize_option_tag(false);
        }
    }

    public static java.util.Optional<String> deserializeOptionStr(com.novi.serde.Deserializer deserializer) throws com.novi.serde.DeserializationError {
        boolean tag = deserializer.deserialize_option_tag();
        if (!tag) {
            return java.util.Optional.empty();
        } else {
            return java.util.Optional.of(deserializer.deserialize_str());
        }
    }

    public static void serializeOptionU64(java.util.Optional<@com.novi.serde.Unsigned Long> value, com.novi.serde.Serializer serializer) throws com.novi.serde.SerializationError {
        if (value.isPresent()) {
            serializer.serialize_option_tag(true);
            serializer.serialize_u64(value.get());
        } else {
            serializer.serialize_option_tag(false);
        }
    }

    public static java.util.Optional<@com.novi.serde.Unsigned Long> deserializeOptionU64(com.novi.serde.Deserializer deserializer) throws com.novi.serde.DeserializationError {
        boolean tag = deserializer.deserialize_option_tag();
        if (!tag) {
            return java.util.Optional.empty();
        } else {
            return java.util.Optional.of(deserializer.deserialize_u64());
        }
    }

    public static void serializeAccountAddressVector(java.util.List<AccountAddress> value, com.novi.serde.Serializer serializer) throws com.novi.serde.SerializationError {
        serializer.serialize_len(value.size());
        for (AccountAddress item : value) {
            item.serialize(serializer);
        }
    }

    public static java.util.List<AccountAddress> deserializeAccountAddressVector(com.novi.serde.Deserializer deserializer) throws com.novi.serde.DeserializationError {
        long length = deserializer.deserialize_len();
        java.util.List<AccountAddress> obj = new java.util.ArrayList<AccountAddress>((int) length);
        for (long i = 0; i < length; i++) {
            obj.add(AccountAddress.deserialize(deserializer));
        }
        return obj;
    }

    public static void serializeStrVector(java.util.List<String> value, com.novi.serde.Serializer serializer) throws com.novi.serde.SerializationError {
        serializer.serialize_len(value.size());
        for (String item : value) {
            serializer.serialize_str(item);
        }
    }

    public static java.util.List<String> deserializeStrVector(com.novi.serde.Deserializer deserializer) throws com.novi.serde.DeserializationError {
        long length = deserializer.deserialize_len();
        java.util.List<String> obj = new java.util.ArrayList<String>((int) length);
        for (long i = 0; i < length; i++) {
            obj.add(deserializer.deserialize_str());
        }
        return obj;
    }

    public static void serializeBytesVector(java.util.List<com.novi.serde.Bytes> value, com.novi.serde.Serializer serializer) throws com.novi.serde.SerializationError {
        serializer.serialize_len(value.size());
        for (com.novi.serde.Bytes item : value) {
            serializer.serialize_bytes(item);
        }
    }

    public static java.util.List<com.novi.serde.Bytes> deserializeBytesVector(com.novi.serde.Deserializer deserializer) throws com.novi.serde.DeserializationError {
        long length = deserializer.deserialize_len();
        java.util.List<com.novi.serde.Bytes> obj = new java.util.ArrayList<com.novi.serde.Bytes>((int) length);
        for (long i = 0; i < length; i++) {
            obj.add(deserializer.deserialize_bytes());
        }
        return obj;
    }

    public static void serializeU8Vector(java.util.List<@com.novi.serde.Unsigned Byte> value, com.novi.serde.Serializer serializer) throws com.novi.serde.SerializationError {
        serializer.serialize_len(value.size());
        for (@com.novi.serde.Unsigned Byte item : value) {
            serializer.serialize_u8(item);
        }
    }

    public static java.util.List<@com.novi.serde.Unsigned Byte> deserializeU8Vector(com.novi.serde.Deserializer deserializer) throws com.novi.serde.DeserializationError {
        long length = deserializer.deserialize_len();
        java.util.List<@com.novi.serde.Unsigned Byte> obj = new java.util.ArrayList<@com.novi.serde.Unsigned Byte>((int) length);
        for (long i = 0; i < length; i++) {
            obj.add(deserializer.deserialize_u8());
        }
        return obj;
    }

//    static void serialize_option_AuthenticationKey(java.util.Optional<AuthenticationKey> value, com.novi.serde.Serializer serializer) throws com.novi.serde.SerializationError {
//        if (value.isPresent()) {
//            serializer.serialize_option_tag(true);
//            value.get().serialize(serializer);
//        } else {
//            serializer.serialize_option_tag(false);
//        }
//    }
//
//    static java.util.Optional<AuthenticationKey> deserialize_option_AuthenticationKey(com.novi.serde.Deserializer deserializer) throws com.novi.serde.DeserializationError {
//        boolean tag = deserializer.deserialize_option_tag();
//        if (!tag) {
//            return java.util.Optional.empty();
//        } else {
//            return java.util.Optional.of(AuthenticationKey.deserialize(deserializer));
//        }
//    }

//    static void serialize_option_KeyRotationCapabilityResource(java.util.Optional<KeyRotationCapabilityResource> value, com.novi.serde.Serializer serializer) throws com.novi.serde.SerializationError {
//        if (value.isPresent()) {
//            serializer.serialize_option_tag(true);
//            value.get().serialize(serializer);
//        } else {
//            serializer.serialize_option_tag(false);
//        }
//    }
//
//    static java.util.Optional<KeyRotationCapabilityResource> deserialize_option_KeyRotationCapabilityResource(com.novi.serde.Deserializer deserializer) throws com.novi.serde.DeserializationError {
//        boolean tag = deserializer.deserialize_option_tag();
//        if (!tag) {
//            return java.util.Optional.empty();
//        } else {
//            return java.util.Optional.of(KeyRotationCapabilityResource.deserialize(deserializer));
//        }
//    }

//    static void serialize_option_ScriptFunction(java.util.Optional<EntryFunction> value, com.novi.serde.Serializer serializer) throws com.novi.serde.SerializationError {
//        if (value.isPresent()) {
//            serializer.serialize_option_tag(true);
//            value.get().serialize(serializer);
//        } else {
//            serializer.serialize_option_tag(false);
//        }
//    }
//
//    static java.util.Optional<EntryFunction> deserialize_option_ScriptFunction(com.novi.serde.Deserializer deserializer) throws com.novi.serde.DeserializationError {
//        boolean tag = deserializer.deserialize_option_tag();
//        if (!tag) {
//            return java.util.Optional.empty();
//        } else {
//            return java.util.Optional.of(EntryFunction.deserialize(deserializer));
//        }
//    }

//    static void serialize_option_WithdrawCapabilityResource(java.util.Optional<WithdrawCapabilityResource> value, com.novi.serde.Serializer serializer) throws com.novi.serde.SerializationError {
//        if (value.isPresent()) {
//            serializer.serialize_option_tag(true);
//            value.get().serialize(serializer);
//        } else {
//            serializer.serialize_option_tag(false);
//        }
//    }
//
//    static java.util.Optional<WithdrawCapabilityResource> deserialize_option_WithdrawCapabilityResource(com.novi.serde.Deserializer deserializer) throws com.novi.serde.DeserializationError {
//        boolean tag = deserializer.deserialize_option_tag();
//        if (!tag) {
//            return java.util.Optional.empty();
//        } else {
//            return java.util.Optional.of(WithdrawCapabilityResource.deserialize(deserializer));
//        }
//    }

//    static void serialize_tuple2_AccessPath_WriteOp(com.novi.serde.Tuple2<AccessPath, WriteOp> value, com.novi.serde.Serializer serializer) throws com.novi.serde.SerializationError {
//        value.field0.serialize(serializer);
//        value.field1.serialize(serializer);
//    }
//
//    static com.novi.serde.Tuple2<AccessPath, WriteOp> deserialize_tuple2_AccessPath_WriteOp(com.novi.serde.Deserializer deserializer) throws com.novi.serde.DeserializationError {
//        return new com.novi.serde.Tuple2<AccessPath, WriteOp>(
//                AccessPath.deserialize(deserializer),
//                WriteOp.deserialize(deserializer)
//        );
//    }

//    static void serialize_vector_ArgumentABI(java.util.List<ArgumentABI> value, com.novi.serde.Serializer serializer) throws com.novi.serde.SerializationError {
//        serializer.serialize_len(value.size());
//        for (ArgumentABI item : value) {
//            item.serialize(serializer);
//        }
//    }
//
//    static java.util.List<ArgumentABI> deserialize_vector_ArgumentABI(com.novi.serde.Deserializer deserializer) throws com.novi.serde.DeserializationError {
//        long length = deserializer.deserialize_len();
//        java.util.List<ArgumentABI> obj = new java.util.ArrayList<ArgumentABI>((int) length);
//        for (long i = 0; i < length; i++) {
//            obj.add(ArgumentABI.deserialize(deserializer));
//        }
//        return obj;
//    }

//    static void serialize_vector_Module(java.util.List<Module> value, com.novi.serde.Serializer serializer) throws com.novi.serde.SerializationError {
//        serializer.serialize_len(value.size());
//        for (Module item : value) {
//            item.serialize(serializer);
//        }
//    }
//
//    static java.util.List<Module> deserialize_vector_Module(com.novi.serde.Deserializer deserializer) throws com.novi.serde.DeserializationError {
//        long length = deserializer.deserialize_len();
//        java.util.List<Module> obj = new java.util.ArrayList<Module>((int) length);
//        for (long i = 0; i < length; i++) {
//            obj.add(Module.deserialize(deserializer));
//        }
//        return obj;
//    }

//    static void serialize_vector_TypeArgumentABI(java.util.List<TypeArgumentABI> value, com.novi.serde.Serializer serializer) throws com.novi.serde.SerializationError {
//        serializer.serialize_len(value.size());
//        for (TypeArgumentABI item : value) {
//            item.serialize(serializer);
//        }
//    }
//
//    static java.util.List<TypeArgumentABI> deserialize_vector_TypeArgumentABI(com.novi.serde.Deserializer deserializer) throws com.novi.serde.DeserializationError {
//        long length = deserializer.deserialize_len();
//        java.util.List<TypeArgumentABI> obj = new java.util.ArrayList<TypeArgumentABI>((int) length);
//        for (long i = 0; i < length; i++) {
//            obj.add(TypeArgumentABI.deserialize(deserializer));
//        }
//        return obj;
//    }

//    static void serialize_vector_TypeTag(java.util.List<TypeTag> value, com.novi.serde.Serializer serializer) throws com.novi.serde.SerializationError {
//        serializer.serialize_len(value.size());
//        for (TypeTag item : value) {
//            item.serialize(serializer);
//        }
//    }
//
//    static java.util.List<TypeTag> deserialize_vector_TypeTag(com.novi.serde.Deserializer deserializer) throws com.novi.serde.DeserializationError {
//        long length = deserializer.deserialize_len();
//        java.util.List<TypeTag> obj = new java.util.ArrayList<TypeTag>((int) length);
//        for (long i = 0; i < length; i++) {
//            obj.add(TypeTag.deserialize(deserializer));
//        }
//        return obj;
//    }

//    static void serialize_vector_tuple2_AccessPath_WriteOp(java.util.List<com.novi.serde.Tuple2<AccessPath, WriteOp>> value, com.novi.serde.Serializer serializer) throws com.novi.serde.SerializationError {
//        serializer.serialize_len(value.size());
//        for (com.novi.serde.Tuple2<AccessPath, WriteOp> item : value) {
//            TraitHelpers.serialize_tuple2_AccessPath_WriteOp(item, serializer);
//        }
//    }
//
//    static java.util.List<com.novi.serde.Tuple2<AccessPath, WriteOp>> deserialize_vector_tuple2_AccessPath_WriteOp(com.novi.serde.Deserializer deserializer) throws com.novi.serde.DeserializationError {
//        long length = deserializer.deserialize_len();
//        java.util.List<com.novi.serde.Tuple2<AccessPath, WriteOp>> obj = new java.util.ArrayList<com.novi.serde.Tuple2<AccessPath, WriteOp>>((int) length);
//        for (long i = 0; i < length; i++) {
//            obj.add(TraitHelpers.deserialize_tuple2_AccessPath_WriteOp(deserializer));
//        }
//        return obj;
//    }

}

