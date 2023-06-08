package com.github.wubuku.rooch.utils;

import com.github.wubuku.rooch.bean.FunctionCallView;
import com.github.wubuku.rooch.bean.StringStringBigIntAnnotatedFunReturnValueViewTriple;

public class MoveOSStdViewFunctions {
    private MoveOSStdViewFunctions() {
    }

    public static StringStringBigIntAnnotatedFunReturnValueViewTriple getEventHandle(RoochJsonRpcClient rpcClient, String eventType) {
        FunctionCallView call = new FunctionCallView();
        call.setFunctionId("0x1::events::get_event_handle");
        call.setTypeArgs(new String[]{eventType});
        call.setArgs(new String[0]);
        return rpcClient.executeViewFunction(call, StringStringBigIntAnnotatedFunReturnValueViewTriple.class);
    }

}
