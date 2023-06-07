package com.github.wubuku.rooch.utils;

import com.fasterxml.jackson.databind.JavaType;
import com.github.wubuku.rooch.bean.*;
import org.starcoin.jsonrpc.JSONRPC2Request;
import org.starcoin.jsonrpc.JSONRPC2Response;
import org.starcoin.jsonrpc.client.JSONRPC2Session;
import org.starcoin.jsonrpc.client.JSONRPC2SessionException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RoochJsonRpcClient {
    private final JSONRPC2Session jsonrpc2Session;

    /**
     * @param url The JSON RPC server URL.
     */
    public RoochJsonRpcClient(String url) throws MalformedURLException {
        this.jsonrpc2Session = new JSONRPC2Session(new URL(url));
    }

    private static void assertSuccess(JSONRPC2Response<?> response) {
        if (!response.indicatesSuccess()) {
            throw new RuntimeException(response.getError().toString());
        }
    }

    protected JSONRPC2Session getJSONRPC2Session() {
        return jsonrpc2Session;
    }

    public GetStatesResponse getStates(String path) {
        List<Object> params = new ArrayList<>();
        params.add(path);
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("rooch_getStates", params,
                System.currentTimeMillis());
        try {
            JSONRPC2Response<GetStatesResponse> jsonrpc2Response = jsonrpc2Session.send(jsonrpc2Request,
                    GetStatesResponse.class);
            assertSuccess(jsonrpc2Response);
            return jsonrpc2Response.getResult();
        } catch (JSONRPC2SessionException e) {
            throw new RuntimeException(e);
        }
    }

    public GetAnnotatedStatesResponse getAnnotatedStates(String path) {
        List<Object> params = new ArrayList<>();
        params.add(path);
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("rooch_getAnnotatedStates", params,
                System.currentTimeMillis());
        try {
            JSONRPC2Response<GetAnnotatedStatesResponse> jsonrpc2Response = jsonrpc2Session.send(jsonrpc2Request,
                    GetAnnotatedStatesResponse.class);
            assertSuccess(jsonrpc2Response);
            return jsonrpc2Response.getResult();
        } catch (JSONRPC2SessionException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("rawtypes")
    public <T> List<GetAnnotatedStatesResponseMoveStructItem<T>> getMoveStructAnnotatedStates(String path, Class<T> valueClass, Class<?>... parameterClasses) {
        List<Object> params = new ArrayList<>();
        params.add(path);
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("rooch_getAnnotatedStates", params,
                System.currentTimeMillis());
        try {
            JSONRPC2Response<List<GetAnnotatedStatesResponseMoveStructItem>> jsonrpc2Response = jsonrpc2Session
                    .sendAndGetListResult(jsonrpc2Request, GetAnnotatedStatesResponseMoveStructItem.class);
            assertSuccess(jsonrpc2Response);
            JavaType valueType = parameterClasses != null && parameterClasses.length > 0
                    ? jsonrpc2Session.getObjectMapper().getTypeFactory().constructParametricType(valueClass, parameterClasses)
                    : null;
            List<GetAnnotatedStatesResponseMoveStructItem> rawItems = jsonrpc2Response.getResult();
            List<GetAnnotatedStatesResponseMoveStructItem<T>> items = new ArrayList<>();
            if (rawItems != null) {
                for (GetAnnotatedStatesResponseMoveStructItem<?> rawItem : rawItems) {
                    AnnotatedMoveStructView<?> rawView = rawItem.getMoveValue();
                    T val = valueType != null
                            ? jsonrpc2Session.getObjectMapper().convertValue(rawView.getValue(), valueType)
                            : jsonrpc2Session.getObjectMapper().convertValue(rawView.getValue(), valueClass);
                    AnnotatedMoveStructView<T> view = new AnnotatedMoveStructView<>();
                    view.setValue(val);
                    GetAnnotatedStatesResponseMoveStructItem<T> item = new GetAnnotatedStatesResponseMoveStructItem<>();
                    item.setMoveValue(view);
                    item.setState(rawItem.getState());
                    items.add(item);
                }
            }
            return items;
        } catch (JSONRPC2SessionException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("rawtypes")
    public List<MoveOSEvent> getEventsByEventHandle(String eventHandleId) {
        List<Object> params = new ArrayList<>();
        params.add(eventHandleId);
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("rooch_getEventsByEventHandle", params,
                System.currentTimeMillis());
        try {
            JSONRPC2Response<List<MoveOSEvent>> jsonrpc2Response = jsonrpc2Session
                    .sendAndGetListResult(jsonrpc2Request, MoveOSEvent.class);
            assertSuccess(jsonrpc2Response);
            return jsonrpc2Response.getResult();
        } catch (JSONRPC2SessionException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("rawtypes")
    public <T> List<MoveOSEvent<T>> getEventsByEventHandle(String eventHandleId, Class<T> eventType) {
        List<Object> params = new ArrayList<>();
        params.add(eventHandleId);
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("rooch_getEventsByEventHandle", params,
                System.currentTimeMillis());
        try {
            JSONRPC2Response<List<MoveOSEvent>> jsonrpc2Response = jsonrpc2Session
                    .sendAndGetListResult(jsonrpc2Request, MoveOSEvent.class);
            assertSuccess(jsonrpc2Response);
            List<MoveOSEvent> rawItems = jsonrpc2Response.getResult();
            List<MoveOSEvent<T>> items = new ArrayList<>();
            if (rawItems != null) {
                for (MoveOSEvent<?> rawItem : rawItems) {
                    AnnotatedMoveStructView<?> rawView = rawItem.getParsedEventData();
                    T val = jsonrpc2Session.getObjectMapper().convertValue(rawView.getValue(), eventType);
                    AnnotatedMoveStructView<T> view = new AnnotatedMoveStructView<>();
                    view.setValue(val);
                    MoveOSEvent<T> item = new MoveOSEvent<>();
                    item.setParsedEventData(view);
                    item.setEventId(rawItem.getEventId());
                    item.setBlockHeight(rawItem.getBlockHeight());
                    item.setEventData(rawItem.getEventData());
                    item.setEventIndex(rawItem.getEventIndex());
                    item.setSender(rawItem.getSender());
                    item.setTimestampMs(rawItem.getTimestampMs());
                    item.setTxHash(rawItem.getTxHash());
                    item.setTypeTag(rawItem.getTypeTag());
                    items.add(item);
                }
            }
            return items;
        } catch (JSONRPC2SessionException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T executeViewFunction(FunctionCallView functionCall) {
        List<Object> params = new ArrayList<>();
        params.add(functionCall);
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("rooch_executeViewFunction", params,
                System.currentTimeMillis());
        try {
            JSONRPC2Response<Object> jsonrpc2Response = jsonrpc2Session
                    .send(jsonrpc2Request);
            assertSuccess(jsonrpc2Response);
            return (T) jsonrpc2Response.getResult();
        } catch (JSONRPC2SessionException e) {
            throw new RuntimeException(e);
        }
    }

}
