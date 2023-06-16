package com.github.wubuku.rooch.bcs.tests;


import com.github.wubuku.rooch.bcs.BcsUtils;
import com.github.wubuku.rooch.bcs.MoveOSStdObject;
import com.github.wubuku.rooch.utils.HexUtils;
import com.novi.bcs.BcsSerializer;
import com.novi.serde.DeserializationError;
import com.novi.serde.SerializationError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class BcsTests {

    @Test
    void testBcsSerialize_1() throws SerializationError {
        BcsSerializer serializer = new BcsSerializer();

        serializer.serialize_u8((byte) 0);
        System.out.println(HexUtils.byteArrayToHex(serializer.get_bytes()));

        System.out.println(HexUtils.byteArrayToHexWithPrefix(BcsUtils.serializeU16((short)0)));
    }

    @Test
    void testBcsDeserializeAndSerialize() throws DeserializationError, SerializationError {
        String hex = "0xff69fc3d5c81dff1b61e8b00757c79a0b8e0bbfb60254863d5b47cfc7ff9a443565d5717526aecec1f9d464867f7d92d6eae2dc8ca73a0dc2613dd185d3d7bc701000000020000000000000000000000000000008d8129535edcbf4c9c58803f68fb1ef92c9784b5c89bcf7c951c1dda0ec67b6fec01e0c0767784ac961c6f9377b001f24eedd847f3247619ea0e9ff79993ddf5";
        MoveOSStdObject<TestSomethingProperties> obj = TestSomethingObject.bcsDeserialize(HexUtils.hexToByteArray(hex));
        System.out.println(obj);

        byte[] bytes = obj.bcsSerialize((s,v) -> v.serialize(s));
        String hex2 = HexUtils.byteArrayToHexWithPrefix(bytes);
        System.out.println(hex2);

        Assertions.assertEquals(hex, hex2);
    }

}
