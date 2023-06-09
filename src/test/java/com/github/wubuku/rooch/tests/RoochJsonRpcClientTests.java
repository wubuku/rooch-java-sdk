package com.github.wubuku.rooch.tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.wubuku.rooch.bean.*;
import com.github.wubuku.rooch.utils.HexUtils;
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
        String path = "/object/0x4349384f4591976d3b5c043d81f7b468bab7ef851f51703923e26cda31133520";
        RoochJsonRpcClient rpcClient = new RoochJsonRpcClient(rpcBaseUrl);
        GetStatesResponse response = rpcClient.getStates(path);
        System.out.println(response);
    }

    @Test
    void testGetAnnotatedStatesResponse_1() throws MalformedURLException, JsonProcessingException {
        String objectId = "0xad1122eb6c6cd05ce491ca3f27f7ca4e3574d607c88cfab593de0ac0ea35070e";

        String rpcBaseUrl = "http://127.0.0.1:50051/";
        String path = "/object/" + objectId;
        RoochJsonRpcClient rpcClient = new RoochJsonRpcClient(rpcBaseUrl);
        GetAnnotatedStatesResponse response = rpcClient.getAnnotatedStates(path);
        System.out.println(response);
        System.out.println(response.get(0).getMoveValue().getClass());

        // ////////////////////
        List<GetAnnotatedStatesResponseMoveStructItem<MoveOSStdObject>> response2 = rpcClient.getMoveStructAnnotatedStates(path,
                MoveOSStdObject.class, TestSomethingProperties.class
        );
        System.out.println(response2);
        System.out.println(response2.get(0).getMoveValue().getValue().getValue());
        MoveOSStdObject<TestSomethingProperties> moveOSStdObject = (MoveOSStdObject<TestSomethingProperties>) response2.get(0).getMoveValue().getValue();
        System.out.println(moveOSStdObject.getValue().getValue().i);

        // ////////////////////
        List<GetAnnotatedStatesResponseMoveStructItem<TestSomethingObject>> response3 = rpcClient.getMoveStructAnnotatedStates(path,
                TestSomethingObject.class
        );
        System.out.println(response3);
        System.out.println(response3.get(0).getMoveValue().getValue().getValue());
        System.out.println(response3.get(0).getMoveValue().getValue().getValue().getValue().i);
    }

    @Test
    void testGetTableItem_1() throws MalformedURLException {
        String rpcBaseUrl = "http://127.0.0.1:50051/";
        String tableHandle = "0x59e2c8f9d1d07e91fcd979fed7dbb98c3e0672b70633d9b5766054d89c738e61";
        byte[] key = new byte[]{1};
        String path = "/table/" + tableHandle + "/" + HexUtils.byteArrayToHexWithPrefix(key);
        RoochJsonRpcClient rpcClient = new RoochJsonRpcClient(rpcBaseUrl);
        List<TypedGetAnnotatedStatesResponseItem<BigInteger>> response = rpcClient
                .getAnnotatedStates(path, BigInteger.class);
        System.out.println(response);
        System.out.println(response.get(0).getMoveValue());

        TypedGetAnnotatedStatesResponseItem<BigInteger> response2 = rpcClient
                .getAnnotatedTableItem(tableHandle, key, BigInteger.class);
        System.out.println(response2);
        System.out.println(response2.getMoveValue());
    }

    @Test
    void testGetEvents_1() throws MalformedURLException, JsonProcessingException {
        String rpcBaseUrl = "http://127.0.0.1:50051/";
        //Id: "0x53f32af12dc9236eb67f1c064cf55ee8891a90040f71ba17422cfdd91eb7358b";
        String eventHandleType = "0x565d5717526aecec1f9d464867f7d92d6eae2dc8ca73a0dc2613dd185d3d7bc7::something::SomethingCreated";
        RoochJsonRpcClient rpcClient = new RoochJsonRpcClient(rpcBaseUrl);
        EventPageView<Object> getEventsResponse1 = rpcClient.getEventsByEventHandle(eventHandleType,
                null,
                null,
                Object.class);
        System.out.println(getEventsResponse1);
        System.out.println(getEventsResponse1.getData().get(0).getParsedEventData().getValue().getClass());

        System.out.println("------------------------");
        BigInteger cursor = null;
        Long limit = 1L;
        System.out.println("cursor: " + cursor);
        EventPageView<TestSomethingCreated> getEventsResponse2 = rpcClient.getEventsByEventHandle(eventHandleType,
                cursor, limit, TestSomethingCreated.class);
        System.out.println(getEventsResponse2);
        System.out.println(getEventsResponse2.getData().get(0).getParsedEventData().getValue().i);

        System.out.println("------------------------");
        //cursor = getEventsResponse2.getData().get(0).getEvent().getEventId().getEventSeq();
        cursor = getEventsResponse2.getNextCursor();
        System.out.println("cursor: " + cursor);

        if (getEventsResponse2.getHasNextPage()) {
            getEventsResponse2 = rpcClient.getEventsByEventHandle(eventHandleType,
                    cursor, limit, TestSomethingCreated.class);
            System.out.println(getEventsResponse2);
            System.out.println(getEventsResponse2.getData().get(0).getParsedEventData().getValue().i);
            System.out.println("cursor: " + cursor);
        }
    }

    @Test
    void testGetEvents_2() throws MalformedURLException, JsonProcessingException {
        String rpcBaseUrl = "http://127.0.0.1:50051/";
        RoochJsonRpcClient rpcClient = new RoochJsonRpcClient(rpcBaseUrl);

        String eventHandleType2 = "0x565d5717526aecec1f9d464867f7d92d6eae2dc8ca73a0dc2613dd185d3d7bc7::something::BarTableItemAdded";//Id: "0x86a59b599dad6bd0b054eee46578c962f83479c38405555cf7ee421f82b4c7b2";
        EventPageView<TestBarTableItemAdded> getEventsResponse3 = rpcClient.getEventsByEventHandle(eventHandleType2,
                null, null, TestBarTableItemAdded.class);
        System.out.println(getEventsResponse3);
        System.out.println(getEventsResponse3.getData().get(0).getParsedEventData().getValue().item.getValue().key.getClass());
        System.out.println(getEventsResponse3.getData().get(0).getParsedEventData().getValue().item.getValue().value.getClass());
    }

    @Test
    void testGetEventsAndGetAnnotatedStates_1() throws MalformedURLException, JsonProcessingException {
        String rpcBaseUrl = "http://127.0.0.1:50051/";
        RoochJsonRpcClient rpcClient = new RoochJsonRpcClient(rpcBaseUrl);

        String contractAddr = "0x565d5717526aecec1f9d464867f7d92d6eae2dc8ca73a0dc2613dd185d3d7bc7";
        String eventType = contractAddr + "::something::SomethingCreated";
        StringStringBigIntAnnotatedFunReturnValueViewTriple evtHandleResult = MoveOSStdViewFunctions.getEventHandle(rpcClient, eventType);
        System.out.println(evtHandleResult);

        // ////////// get event handle by event type //////////
        String eventHandle = evtHandleResult.getItem1().getMoveValue();
        System.out.println("eventHandle:");
        System.out.println(eventHandle);//0xd503491955e774d10d2dc373f7507022190bd2202d2a8ddbe33d838f42b61521
        System.out.println("-----------------");
        EventPageView<TestSomethingCreated> getEventsResponse1 = rpcClient.getEventsByEventHandle(
                eventType, //eventHandle,
                null, null, TestSomethingCreated.class);
        System.out.println(getEventsResponse1);
        System.out.println(getEventsResponse1.getData().get(0).getParsedEventData().getValue().i);

        //if (false) {
        // /////////// get created object ID in event emitted /////////
        String objId = getEventsResponse1.getData().get(0).getParsedEventData().getValue().obj_id;
        System.out.println("Created ObjectID: " + objId);
        System.out.println("-----------------");
        System.out.println("Get state of created object:");
        String path = "/object/" + HexUtils.formatHex(objId);
        List<GetAnnotatedStatesResponseMoveStructItem<TestSomethingObject>> response3 =
                rpcClient.getMoveStructAnnotatedStates(path,
                        TestSomethingObject.class
                );
        System.out.println(response3);

        // /////////// get table info. by table handle in object fields ///////////
        MoveOSStdTable moveTable = response3.get(0).getMoveValue().getValue().getValue().getValue().barTable.getValue();
        String tableHandle = moveTable.getHandle();
        System.out.println("tableHandle: " + tableHandle);
        String path4 = "/object/" + HexUtils.formatHex(tableHandle);
        List<GetAnnotatedStatesResponseMoveStructItem<MoveOSStdObject>> response4 = rpcClient.getMoveStructAnnotatedStates(path4,
                MoveOSStdObject.class, MoveOSStdRawTableInfo.class
        );
        System.out.println(response4);
        MoveOSStdObject<MoveOSStdRawTableInfo> tableMoveObj = response4.get(0).getMoveValue().getValue();
        System.out.println(tableMoveObj.getValue().getValue().getStateRoot());
        //}
        //String tableHandle = "0x7b658546b4b6d3921b446dddf7379c720edf6a8d04e3a3d2b2139c2c93076bd9";

        // //////////// get table item value by table handle and item key //////////
        byte[] key = new byte[]{0};
        TypedGetAnnotatedStatesResponseItem<BigInteger> tableItemVal1 = rpcClient.getAnnotatedTableItem(tableHandle, key, BigInteger.class);
        System.out.println(tableItemVal1);

        // ////////// get event handle by event type //////////
        String eventType2 = contractAddr + "::something::BarTableItemAdded";
        StringStringBigIntAnnotatedFunReturnValueViewTriple evtHandleResult2 = MoveOSStdViewFunctions.getEventHandle(rpcClient, eventType2);
        System.out.println(evtHandleResult2);
        String eventHandleId2 = evtHandleResult2.getItem1().getMoveValue();
        //String eventHandle2 = "0x86a59b599dad6bd0b054eee46578c962f83479c38405555cf7ee421f82b4c7b2";
        System.out.println(eventHandleId2);
        EventPageView<TestBarTableItemAdded> getEventsResponse2 = rpcClient.getEventsByEventHandle(
                eventType2, null, null, TestBarTableItemAdded.class);
        System.out.println(getEventsResponse2);
        System.out.println(getEventsResponse2.getData().get(0).getParsedEventData().getValue().item.getValue().key.getClass());
        System.out.println(getEventsResponse2.getData().get(0).getParsedEventData().getValue().item.getValue().value.getClass());

    }

    @Test
    void testExecuteViewFunction_1() throws MalformedURLException {
        String rpcBaseUrl = "http://127.0.0.1:50051/";
        RoochJsonRpcClient rpcClient = new RoochJsonRpcClient(rpcBaseUrl);
        String eventType = "0x565d5717526aecec1f9d464867f7d92d6eae2dc8ca73a0dc2613dd185d3d7bc7::something::SomethingCreated";
        Triple<?, ?, ?> result = MoveOSStdViewFunctions.getEventHandle(rpcClient, eventType);
        System.out.println(result);
    }

    @Test
    void testGetTransactions_1() throws MalformedURLException, JsonProcessingException {

    }

    public static class TestBarTableItemAdded {
        public AnnotatedMoveStructView<TestKeyValuePair<Integer, BigInteger>> item;

        @Override
        public String toString() {
            return "TestBarTableItemAdded{" +
                    "item=" + item +
                    '}';
        }
    }

    public static class TestKeyValuePair<K, V> {
        public K key;
        public V value;

        @Override
        public String toString() {
            return "TestKeyValuePair{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
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
