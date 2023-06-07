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
        String eventHandleId = "0x436305b861b7780b1a88cd38e1b5c5348a20d2b65fbe84e87de926c96f703711";
        RoochJsonRpcClient rpcClient = new RoochJsonRpcClient(rpcBaseUrl);
        List<MoveOSEvent> response = rpcClient.getEventsByEventHandle(eventHandleId);
        System.out.println(response);
        System.out.println(response.get(0).getParsedEventData().getValue().getClass());

        List<MoveOSEvent<TestSomethingCreated>> response2 = rpcClient.getEventsByEventHandle(eventHandleId, TestSomethingCreated.class);
        System.out.println(response2);
        System.out.println(response2.get(0).getParsedEventData().getValue().i);

    }

    @Test
    void testExecuteViewFunction() throws MalformedURLException {
        String rpcBaseUrl = "http://127.0.0.1:50051/";
        RoochJsonRpcClient rpcClient = new RoochJsonRpcClient(rpcBaseUrl);
        String eventType = "0x9a7ee8b910f40f7613d9b4dafb573395783a913f4e7598aaac25510bd7444de2::something::SomethingCreated";
//        FunctionCallView call = new FunctionCallView();
//        call.setFunctionId("0x1::events::get_event_handle");
//        call.setTypeArgs(new String[]{eventType});
//        call.setArgs(new String[0]);
//        Object result = rpcClient.executeViewFunction(call);
//        System.out.println(result.getClass());

        Triple result = MoveOSStdViewFunctions.getEventHandle(rpcClient, eventType);
        System.out.println(result);
    }

    @Test
    void testGetTransactions_1() throws MalformedURLException, JsonProcessingException {

    }

    public static class TestSomethingCreated {
        public Integer i;
        public BigInteger j;

        @Override
        public String toString() {
            return "TestSomethingCreated{" +
                    "i=" + i +
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
