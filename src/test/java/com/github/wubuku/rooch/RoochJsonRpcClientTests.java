package com.github.wubuku.rooch;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.wubuku.rooch.bean.GetAnnotatedStatesResponse;
import com.github.wubuku.rooch.bean.GetAnnotatedStatesResponseMoveStructItem;
import com.github.wubuku.rooch.bean.GetStatesResponse;
import com.github.wubuku.rooch.bean.MoveOSStdObject;
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
        String path = "/object/0xfc706290bd386345feb92bb4a21cd04b4941c63c3eabfbb30202f9000a4c15e6";
        RoochJsonRpcClient rpcClient = new RoochJsonRpcClient(rpcBaseUrl);
        GetStatesResponse response = rpcClient.getStates(path);
        System.out.println(response);
    }

    @Test
    void testGetAnnotatedStatesResponse_1() throws MalformedURLException, JsonProcessingException {
        String rpcBaseUrl = "http://127.0.0.1:50051/";
        String path = "/object/0xfc706290bd386345feb92bb4a21cd04b4941c63c3eabfbb30202f9000a4c15e6";
        RoochJsonRpcClient rpcClient = new RoochJsonRpcClient(rpcBaseUrl);
        GetAnnotatedStatesResponse response = rpcClient.getAnnotatedStates(path);
        System.out.println(response);
    }

    @Test
    void testGetAnnotatedStatesResponse_2() throws MalformedURLException, JsonProcessingException {
        String rpcBaseUrl = "http://127.0.0.1:50051/";
        String path = "/object/0xfc706290bd386345feb92bb4a21cd04b4941c63c3eabfbb30202f9000a4c15e6";
        RoochJsonRpcClient rpcClient = new RoochJsonRpcClient(rpcBaseUrl);
        GetTestSomethingAnnotatedStatesResponseItem[] response = rpcClient.getMoveStructAnnotatedStateArray(path,
                GetTestSomethingAnnotatedStatesResponseItem[].class
        );

        System.out.println(response);
        System.out.println(response[0].getMoveValue().getValue());
    }

    @Test
    void testGetAnnotatedStatesResponse_3() throws MalformedURLException, JsonProcessingException {
        String rpcBaseUrl = "http://127.0.0.1:50051/";
        String path = "/object/0xfc706290bd386345feb92bb4a21cd04b4941c63c3eabfbb30202f9000a4c15e6";
        RoochJsonRpcClient rpcClient = new RoochJsonRpcClient(rpcBaseUrl);
        List<GetTestSomethingAnnotatedStatesResponseItem> response = rpcClient.getMoveStructAnnotatedStates(path,
                GetTestSomethingAnnotatedStatesResponseItem.class
        );

        System.out.println(response);
        System.out.println(response.get(0).getMoveValue().getValue());
    }

//    @Test
//    void testGetAnnotatedStatesResponse_3() throws MalformedURLException, JsonProcessingException {
//        String rpcBaseUrl = "http://127.0.0.1:50051/";
//        String path = "/object/0xfc706290bd386345feb92bb4a21cd04b4941c63c3eabfbb30202f9000a4c15e6";
//        RoochJsonRpcClient rpcClient = new RoochJsonRpcClient(rpcBaseUrl);
//        GetTestSomethingAnnotatedStatesResponseItem2[] response = rpcClient.getMoveOSStdObjectAnnotatedStates(path, GetTestSomethingAnnotatedStatesResponseItem2[].class);
//        System.out.println(response);
//        System.out.println(response[0].getMoveValue().getValue().getValue().getValue().i);
//    }

    @Test
    void testGetEvents_1() throws MalformedURLException, JsonProcessingException {

    }

    @Test
    void testGetTransactions_1() throws MalformedURLException, JsonProcessingException {

    }

    public static class GetTestSomethingAnnotatedStatesResponseItem extends GetAnnotatedStatesResponseMoveStructItem<TestSomethingObject> {

    }

    public static class TestSomethingObject extends MoveOSStdObject<TestSomethingProperties> {

    }

    public static class TestSomethingProperties {
        public Integer i;
        public BigInteger j;

        @Override
        public String toString() {
            return "TestSomethingProperties{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }


}
