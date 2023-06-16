package com.github.wubuku.rooch.bcs;

import com.novi.bcs.BcsSerializer;
import com.novi.serde.Bytes;
import com.novi.serde.SerializationError;

import java.math.BigInteger;

public class BcsUtils {
    private BcsUtils() {
    }

    public static byte[] serializeU8(Byte v) {
        BcsSerializer s = new BcsSerializer();
        try {
            s.serialize_u8(v);
        } catch (SerializationError e) {
            throw new RuntimeException(e);
        }
        return s.get_bytes();
    }

    public static byte[] serializeU16(Short v) {
        BcsSerializer s = new BcsSerializer();
        try {
            s.serialize_u16(v);
        } catch (SerializationError e) {
            throw new RuntimeException(e);
        }
        return s.get_bytes();
    }

    public static byte[] serializeU32(Integer v) {
        BcsSerializer s = new BcsSerializer();
        try {
            s.serialize_u32(v);
        } catch (SerializationError e) {
            throw new RuntimeException(e);
        }
        return s.get_bytes();
    }

    public static byte[] serializeU64(Long v) {
        BcsSerializer s = new BcsSerializer();
        try {
            s.serialize_u64(v);
        } catch (SerializationError e) {
            throw new RuntimeException(e);
        }
        return s.get_bytes();
    }

    public static byte[] serializeU128(BigInteger v) {
        BcsSerializer s = new BcsSerializer();
        try {
            s.serialize_u128(v);
        } catch (SerializationError e) {
            throw new RuntimeException(e);
        }
        return s.get_bytes();
    }

    public static byte[] serializeU256(BigInteger v) {
        BcsSerializer s = new BcsSerializer();
        try {
            s.serialize_u256(v);
        } catch (SerializationError e) {
            throw new RuntimeException(e);
        }
        return s.get_bytes();
    }

    public static byte[] serializeBool(Boolean v) {
        BcsSerializer s = new BcsSerializer();
        try {
            s.serialize_bool(v);
        } catch (SerializationError e) {
            throw new RuntimeException(e);
        }
        return s.get_bytes();
    }

    public static byte[] serializeU16(Bytes v) {
        BcsSerializer s = new BcsSerializer();
        try {
            s.serialize_bytes(v);
        } catch (SerializationError e) {
            throw new RuntimeException(e);
        }
        return s.get_bytes();
    }

    public static byte[] serializeStr(String v) {
        BcsSerializer s = new BcsSerializer();
        try {
            s.serialize_str(v);
        } catch (SerializationError e) {
            throw new RuntimeException(e);
        }
        return s.get_bytes();
    }

}
