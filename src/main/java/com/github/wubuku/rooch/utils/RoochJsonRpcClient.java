package com.github.wubuku.rooch.utils;

import com.github.wubuku.rooch.bean.GetAnnotatedStatesResponse;
import com.github.wubuku.rooch.bean.GetAnnotatedStatesResponseMoveStructItem;
import com.github.wubuku.rooch.bean.GetStatesResponse;
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

    public <T extends GetAnnotatedStatesResponseMoveStructItem<?>> T[] getMoveStructAnnotatedStateArray(String path, Class<T[]> arrayClazz) {
        List<Object> params = new ArrayList<>();
        params.add(path);
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("rooch_getAnnotatedStates", params,
                System.currentTimeMillis());
        try {
            JSONRPC2Response<T[]> jsonrpc2Response = jsonrpc2Session
                    .send(jsonrpc2Request, arrayClazz);
            assertSuccess(jsonrpc2Response);
            return jsonrpc2Response.getResult();
        } catch (JSONRPC2SessionException e) {
            throw new RuntimeException(e);
        }
    }

    public <T extends GetAnnotatedStatesResponseMoveStructItem<?>> List<T> getMoveStructAnnotatedStates(String path, Class<T> itemClazz) {
        List<Object> params = new ArrayList<>();
        params.add(path);
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("rooch_getAnnotatedStates", params,
                System.currentTimeMillis());
        try {
            JSONRPC2Response<List<T>> jsonrpc2Response = jsonrpc2Session
                    .sendAndGetListResult(jsonrpc2Request, itemClazz);
            assertSuccess(jsonrpc2Response);
            return jsonrpc2Response.getResult();
        } catch (JSONRPC2SessionException e) {
            throw new RuntimeException(e);
        }
    }

}
