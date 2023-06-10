package com.github.wubuku.rooch.utils;

import com.fasterxml.jackson.databind.JavaType;
import com.github.wubuku.rooch.bean.*;
import org.starcoin.jsonrpc.JSONRPC2Request;
import org.starcoin.jsonrpc.JSONRPC2Response;
import org.starcoin.jsonrpc.client.JSONRPC2Session;
import org.starcoin.jsonrpc.client.JSONRPC2SessionException;

import java.math.BigInteger;
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

    public <T> List<TypedGetAnnotatedStatesResponseItem<T>> getAnnotatedStates(String path, Class<T> valueClass) {
        List<Object> params = new ArrayList<>();
        params.add(path);
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("rooch_getAnnotatedStates", params,
                System.currentTimeMillis());
        try {
            JSONRPC2Response<List<TypedGetAnnotatedStatesResponseItem<T>>> jsonrpc2Response =
                    jsonrpc2Session.sendAndGetListResult(jsonrpc2Request,
                            jsonrpc2Session.getObjectMapper().getTypeFactory().constructParametricType(
                                    TypedGetAnnotatedStatesResponseItem.class, valueClass
                            ));
            assertSuccess(jsonrpc2Response);
            return jsonrpc2Response.getResult();
        } catch (JSONRPC2SessionException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> TypedGetAnnotatedStatesResponseItem<T> getAnnotatedTableItem(String tableHandle, byte[] key, Class<T> valueClass) {
        String path = "/table/" + tableHandle + "/" + HexUtils.byteArrayToHexWithPrefix(key);
        List<TypedGetAnnotatedStatesResponseItem<T>> list = getAnnotatedStates(path, valueClass);
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    public <T> List<GetAnnotatedStatesResponseMoveStructItem<T>> getMoveStructAnnotatedStates(
            String path, Class<T> valueClass, Class<?>... parameterClasses) {

        List<Object> params = new ArrayList<>();
        params.add(path);
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("rooch_getAnnotatedStates", params,
                System.currentTimeMillis());
        try {
            JavaType valueType = parameterClasses != null && parameterClasses.length > 0
                    ? jsonrpc2Session.getObjectMapper().getTypeFactory().constructParametricType(valueClass, parameterClasses)
                    : jsonrpc2Session.getObjectMapper().getTypeFactory().constructType(valueClass);
            JSONRPC2Response<List<GetAnnotatedStatesResponseMoveStructItem<T>>> jsonrpc2Response = jsonrpc2Session
                    .sendAndGetListResult(jsonrpc2Request,
                            jsonrpc2Session.getObjectMapper().getTypeFactory().constructParametricType(
                                    GetAnnotatedStatesResponseMoveStructItem.class, valueType
                            )
                    );
            assertSuccess(jsonrpc2Response);
            return jsonrpc2Response.getResult();
        } catch (JSONRPC2SessionException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> List<AnnotatedEventView<T>> getEventsByEventHandle(String eventHandleType,
                                                                  BigInteger cursor, Long limit,
                                                                  Class<T> eventType) {
        List<Object> params = new ArrayList<>();
        params.add(eventHandleType);
        if (cursor != null || limit != null) {
            params.add(cursor);
        }
        if (limit != null) {
            params.add(limit);
        }
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("rooch_getEventsByEventHandle", params,
                System.currentTimeMillis());
        try {
            JSONRPC2Response<List<AnnotatedEventView<T>>> jsonrpc2Response = jsonrpc2Session.sendAndGetListResult(jsonrpc2Request,
                    jsonrpc2Session.getObjectMapper().getTypeFactory().constructParametricType(
                            AnnotatedEventView.class, eventType
                    )
            );
            assertSuccess(jsonrpc2Response);
            return jsonrpc2Response.getResult();
        } catch (JSONRPC2SessionException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> T executeViewFunction(FunctionCallView functionCall, Class<T> returnClass) {
        List<Object> params = new ArrayList<>();
        params.add(functionCall);
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("rooch_executeViewFunction", params,
                System.currentTimeMillis());
        try {
            JSONRPC2Response<T> jsonrpc2Response = jsonrpc2Session
                    .send(jsonrpc2Request, returnClass);
            assertSuccess(jsonrpc2Response);
            return jsonrpc2Response.getResult();
        } catch (JSONRPC2SessionException e) {
            throw new RuntimeException(e);
        }
    }

}
