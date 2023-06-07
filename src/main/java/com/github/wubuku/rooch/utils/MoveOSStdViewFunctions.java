package com.github.wubuku.rooch.utils;

import com.github.wubuku.rooch.bean.FunctionCallView;
import com.github.wubuku.rooch.bean.Triple;

import java.math.BigInteger;
import java.util.List;

public class MoveOSStdViewFunctions {
    private MoveOSStdViewFunctions() {
    }

    public static Triple<String, String, BigInteger> getEventHandle(RoochJsonRpcClient rpcClient, String eventType) {
        FunctionCallView call = new FunctionCallView();
        call.setFunctionId("0x1::events::get_event_handle");
        call.setTypeArgs(new String[]{eventType});
        call.setArgs(new String[0]);
        List<?> result = rpcClient.executeViewFunction(call);
        String objectId = ((List<?>) result.get(0)).get(0).toString();
        if (!objectId.startsWith("0x")) {
            objectId = "0x" + objectId;
        }
        String address = result.get(1).toString();
        BigInteger eventSeq = new BigInteger(result.get(2).toString());
        return new Triple<>(objectId, address, eventSeq);
    }

}
