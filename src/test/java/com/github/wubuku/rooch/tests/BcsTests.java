package com.github.wubuku.rooch.tests;


import com.github.wubuku.rooch.utils.HexUtils;
import com.novi.bcs.BcsSerializer;
import com.novi.serde.SerializationError;
import org.junit.jupiter.api.Test;


public class BcsTests {

    @Test
    void testBcsSerialize_1() throws SerializationError {
        BcsSerializer serializer = new BcsSerializer();

        serializer.serialize_u8((byte) 0);
        System.out.println(HexUtils.byteArrayToHex(serializer.get_bytes()));
    }

}
