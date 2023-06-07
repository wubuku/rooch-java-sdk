package com.github.wubuku.rooch;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.wubuku.rooch.bean.*;
import com.github.wubuku.rooch.utils.MoveOSStdViewFunctions;
import com.github.wubuku.rooch.utils.RoochJsonRpcClient;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.util.List;

public class RoochJsonRpcClientTests {

    static final long DEFAULT_MAX_GAS_BUDGE = 1000000;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testGetStatesResponse_1() throws MalformedURLException, JsonProcessingException {
        String rpcBaseUrl = "http://127.0.0.1:50051/";
        String path = "/object/0x1e6c3ad9f200f8b284a53a8aab1caa1922dac9ef0369a9020f99622d5e04d03e";
        RoochJsonRpcClient rpcClient = new RoochJsonRpcClient(rpcBaseUrl);
        GetStatesResponse response = rpcClient.getStates(path);
        System.out.println(response);
    }

    @Test
    void testGetAnnotatedStatesResponse_1() throws MalformedURLException, JsonProcessingException {
        String rpcBaseUrl = "http://127.0.0.1:50051/";
        String path = "/object/0x1e6c3ad9f200f8b284a53a8aab1caa1922dac9ef0369a9020f99622d5e04d03e";
        RoochJsonRpcClient rpcClient = new RoochJsonRpcClient(rpcBaseUrl);
        GetAnnotatedStatesResponse response = rpcClient.getAnnotatedStates(path);
        System.out.println(response);
        System.out.println(response.get(0).getMoveValue().getClass());
    }

    @Test
    void testGetAnnotatedStatesResponse_3() throws MalformedURLException, JsonProcessingException {
        String rpcBaseUrl = "http://127.0.0.1:50051/";
        String path = "/object/0x1e6c3ad9f200f8b284a53a8aab1caa1922dac9ef0369a9020f99622d5e04d03e";
        RoochJsonRpcClient rpcClient = new RoochJsonRpcClient(rpcBaseUrl);

        // ////////////////////
        List<GetAnnotatedStatesResponseMoveStructItem<MoveOSStdObject>> response = rpcClient.getMoveStructAnnotatedStates(path,
                MoveOSStdObject.class, TestSomethingProperties.class
        );
        System.out.println(response);
        System.out.println(response.get(0).getMoveValue().getValue().getValue());
        MoveOSStdObject<TestSomethingProperties> moveOSStdObject = (MoveOSStdObject<TestSomethingProperties>) response.get(0).getMoveValue().getValue();
        System.out.println(moveOSStdObject.getValue().getValue().i);

        // ////////////////////
        List<GetAnnotatedStatesResponseMoveStructItem<TestSomethingObject>> response2 = rpcClient.getMoveStructAnnotatedStates(path,
                TestSomethingObject.class
        );
        System.out.println(response2);
        System.out.println(response2.get(0).getMoveValue().getValue().getValue());
        System.out.println(response2.get(0).getMoveValue().getValue().getValue().getValue().i);
    }

    @Test
    void testGetEvents_1() throws MalformedURLException, JsonProcessingException {
        String rpcBaseUrl = "http://127.0.0.1:50051/";
        String eventHandleId = "0xef73ee3a1b60c4487af65ec6d38c76a72e0d91a71e3e2e93d564c9071aaa28df";
        RoochJsonRpcClient rpcClient = new RoochJsonRpcClient(rpcBaseUrl);
        List<MoveOSEvent> response = rpcClient.getEventsByEventHandle(eventHandleId);
        System.out.println(response);
        System.out.println(response.get(0).getParsedEventData().getValue().getClass());

        List<MoveOSEvent<TestSomethingCreated>> response2 = rpcClient.getEventsByEventHandle(eventHandleId, TestSomethingCreated.class);
        System.out.println(response2);
        System.out.println(response2.get(0).getParsedEventData().getValue().i);
    }

    @Test
    void testGetEventsAndGetAnnotatedStates_1() throws MalformedURLException, JsonProcessingException {
        String rpcBaseUrl = "http://127.0.0.1:50051/";
        RoochJsonRpcClient rpcClient = new RoochJsonRpcClient(rpcBaseUrl);

        String eventType = "0xf8e38d63a5208d499725e7ac4851c4a0836e45e2230041b7e3cf43e4738c47b4::something::SomethingCreated";
        Triple<String, String, BigInteger> result = MoveOSStdViewFunctions.getEventHandle(rpcClient, eventType);
        System.out.println(result);

        // ////////////////////
        String eventHandleId = result.getItem1();
        System.out.println(eventHandleId);
        List<MoveOSEvent<TestSomethingCreated>> response2 = rpcClient.getEventsByEventHandle(eventHandleId, TestSomethingCreated.class);
        System.out.println(response2);
        System.out.println(response2.get(0).getParsedEventData().getValue().i);

        // ////////////////////
        String objId = response2.get(0).getParsedEventData().getValue().obj_id;
        String path = "/object/"+ objId;
        List<GetAnnotatedStatesResponseMoveStructItem<TestSomethingObject>> response3 = rpcClient.getMoveStructAnnotatedStates(path,
                TestSomethingObject.class
        );
        System.out.println(response3);
    }

    @Test
    void testExecuteViewFunction_1() throws MalformedURLException {
        String rpcBaseUrl = "http://127.0.0.1:50051/";
        RoochJsonRpcClient rpcClient = new RoochJsonRpcClient(rpcBaseUrl);
        String eventType = "0x9a7ee8b910f40f7613d9b4dafb573395783a913f4e7598aaac25510bd7444de2::something::SomethingCreated";
        Triple result = MoveOSStdViewFunctions.getEventHandle(rpcClient, eventType);
        System.out.println(result);
    }

    @Test
    void testGetTransactions_1() throws MalformedURLException, JsonProcessingException {

    }

    public static class TestSomethingCreated {
        public String obj_id;
        public Integer i;
        public BigInteger j;

        @Override
        public String toString() {
            return "TestSomethingCreated{" +
                    "obj_id='" + obj_id + '\'' +
                    ", i=" + i +
                    ", j=" + j +
                    '}';
        }
    }

    public static class TestSomethingObject extends MoveOSStdObject<TestSomethingProperties> {

    }

    public static class TestSomethingProperties {
        public Integer i;
        public BigInteger j;

        public AnnotatedMoveTableView fooTable;

        public AnnotatedMoveTableView barTable;

        @Override
        public String toString() {
            return "TestSomethingProperties{" +
                    "i=" + i +
                    ", j=" + j +
                    ", fooTable=" + fooTable +
                    ", barTable=" + barTable +
                    '}';
        }
    }


}
