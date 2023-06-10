package com.github.wubuku.rooch;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.wubuku.rooch.bean.AnnotatedMoveOptionView;
import com.github.wubuku.rooch.bean.GetAnnotatedStatesResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.starcoin.jsonrpc.client.JSONRPC2SessionException;

import java.net.MalformedURLException;
import java.util.Base64;

public class JsonRpcTests {
    ObjectMapper objectMapper = new ObjectMapper();
    String testJson1 = "[\n" +
            "  {\n" +
            "    \"state\": {\n" +
            "      \"value\": \"0xffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff0f00000000000000000000000040ad744b6a3cd57d800e595b0aa9bf29ae0d2c1dadc78860a2c57df3cea5da9100c83391cba13a30ef3e961c5d940e424418ffcf4751b9310608113b58e21f160568656c6c6f06e4bda0e5a5bd2a000000000000002040ad744b6a3cd57d800e595b0aa9bf29ae0d2c1dadc78860a2c57df3cea5da91020100ffff0201000000ffffffff020100000000000000ffffffffffffffff020568656c6c6f06e4bda0e5a5bd012a00000000000000\",\n" +
            "      \"value_type\": \"0x40ad744b6a3cd57d800e595b0aa9bf29ae0d2c1dadc78860a2c57df3cea5da91::complex_struct::ComplexStruct\"\n" +
            "    },\n" +
            "    \"move_value\": {\n" +
            "      \"abilities\": 12,\n" +
            "      \"type\": \"0x40ad744b6a3cd57d800e595b0aa9bf29ae0d2c1dadc78860a2c57df3cea5da91::complex_struct::ComplexStruct\",\n" +
            "      \"value\": {\n" +
            "        \"field_address\": \"0x40ad744b6a3cd57d800e595b0aa9bf29ae0d2c1dadc78860a2c57df3cea5da91\",\n" +
            "        \"field_ascii_str\": \"hello\",\n" +
            "        \"field_object_id\": \"0xc83391cba13a30ef3e961c5d940e424418ffcf4751b9310608113b58e21f16\",\n" +
            "        \"field_str\": \"你好\",\n" +
            "        \"field_struct\": {\n" +
            "          \"abilities\": 7,\n" +
            "          \"type\": \"0x40ad744b6a3cd57d800e595b0aa9bf29ae0d2c1dadc78860a2c57df3cea5da91::complex_struct::SimpleStruct\",\n" +
            "          \"value\": {\n" +
            "            \"value\": \"42\"\n" +
            "          }\n" +
            "        },\n" +
            "        \"field_u128\": \"340282366920938463463374607431768211455\",\n" +
            "        \"field_u16\": 65535,\n" +
            "        \"field_u256\": \"91343852333181432387730302044767688728495783935\",\n" +
            "        \"field_u32\": 4294967295,\n" +
            "        \"field_u64\": \"18446744073709551615\",\n" +
            "        \"field_u8\": 255,\n" +
            "        \"field_vec_str\": [\n" +
            "          \"hello\",\n" +
            "          \"你好\"\n" +
            "        ],\n" +
            "        \"field_vec_struct\": [\n" +
            "          {\n" +
            "            \"abilities\": 7,\n" +
            "            \"type\": \"0x40ad744b6a3cd57d800e595b0aa9bf29ae0d2c1dadc78860a2c57df3cea5da91::complex_struct::SimpleStruct\",\n" +
            "            \"value\": {\n" +
            "              \"value\": \"42\"\n" +
            "            }\n" +
            "          }\n" +
            "        ],\n" +
            "        \"field_vec_u16\": [\n" +
            "          1,\n" +
            "          65535\n" +
            "        ],\n" +
            "        \"field_vec_u32\": [\n" +
            "          1,\n" +
            "          4294967295\n" +
            "        ],\n" +
            "        \"field_vec_u64\": [\n" +
            "          \"1\",\n" +
            "          \"18446744073709551615\"\n" +
            "        ],\n" +
            "        \"field_vec_u8\": \"0x40ad744b6a3cd57d800e595b0aa9bf29ae0d2c1dadc78860a2c57df3cea5da91\"\n" +
            "      }\n" +
            "    }\n" +
            "  }\n" +
            "]";

    @Test
    void testJsonRpc_1() throws MalformedURLException, JSONRPC2SessionException, JsonProcessingException {


    }

    @Test
    void testJsonRpc_2() throws MalformedURLException, JSONRPC2SessionException, JsonProcessingException {

    }

    @Test
    void testJsonRpc_3() throws MalformedURLException, JSONRPC2SessionException, JsonProcessingException {

    }

    @Test
    void testJsonDeserialize_5() throws JsonProcessingException {
        String jsonOpt = "{\n" +
                "  \"abilities\": 7,\n" +
                "  \"type\": \"0x1::option::Option<0x1::string::String>\",\n" +
                "  \"value\": {\n" +
                "    \"vec\": [\n" +
                "      \"foo\"\n" +
                "    ]\n" +
                "  }\n" +
                "}";
        AnnotatedMoveOptionView<String> s = objectMapper.readValue(jsonOpt,
                new TypeReference<AnnotatedMoveOptionView<String>>() {
                }
        );
        System.out.println(s);
    }

    @Test
    void testJsonDeserialize_4() throws JsonProcessingException {

//        ObjectMapper om = objectMapper;
//        Class<?> parametrized = PaginatedMoveEvents.class;
//        Class<?> parameterClasses = MintNFTEvent.class;
//        JSONRPC2Response<PaginatedMoveEvents<MintNFTEvent>> paginatedMoveEventsJSONRPC2Response = om.readValue(json,
//                om.getTypeFactory().constructParametricType(JSONRPC2Response.class,
//                        om.getTypeFactory().constructParametricType(parametrized, parameterClasses)));
//        System.out.println(paginatedMoveEventsJSONRPC2Response);
    }

    @Test
    void testJsonDeserialize_2() throws JsonProcessingException {
        GetAnnotatedStatesResponse getAnnotatedStatesResponse = objectMapper.readValue(
                testJson1,
                new TypeReference<GetAnnotatedStatesResponse>() {
                }
        );
        System.out.println(getAnnotatedStatesResponse);
    }

//    @Test
//    void testJsonDeserialize_2() throws JsonProcessingException {
//        GetMoveStructAnnotatedStatesResponse<Map> getAnnotatedStatesResponse = objectMapper.readValue(
//                testJson1,
//                objectMapper.getTypeFactory().constructParametricType(GetMoveStructAnnotatedStatesResponse.class, Map.class)
//        );
//        System.out.println(getAnnotatedStatesResponse);
//    }

    @Test
    void testBase64() {
        String originalInput = "test input";
        String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        String decodedString = new String(decodedBytes);
//        System.out.println(originalInput);
//        System.out.println(decodedString);
        Assertions.assertEquals(originalInput, decodedString);
    }
//
//    public static class MintNFTEvent {
//        public String creator;
//        public String name;
//        public String object_id;
//
//        @Override
//        public String toString() {
//            return "MintNFTEvent{" +
//                    "creator='" + creator + '\'' +
//                    ", name='" + name + '\'' +
//                    ", object_id='" + object_id + '\'' +
//                    '}';
//        }
//    }

}
