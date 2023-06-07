package com.github.wubuku.rooch.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

/**
 * From Rust definition:
 * <pre>
 * #[derive(Debug, Clone, Deserialize, Serialize, JsonSchema)]
 * pub struct FunctionCallView {
 *     pub function_id: FunctionIdView,
 *     pub ty_args: Vec<TypeTagView>,
 *     pub args: Vec<StrView<Vec<u8>>>,
 * }
 * </pre>
 */
public class FunctionCallView {
    @JsonProperty("function_id")
    private String functionId;
    @JsonProperty("ty_args")
    private String[] typeArgs;
    private String[] args; // todo Is this ok?

    public String getFunctionId() {
        return functionId;
    }

    public void setFunctionId(String functionId) {
        this.functionId = functionId;
    }

    public String[] getTypeArgs() {
        return typeArgs;
    }

    public void setTypeArgs(String[] typeArgs) {
        this.typeArgs = typeArgs;
    }

    public String[] getArgs() {
        return args;
    }

    public void setArgs(String[] args) {
        this.args = args;
    }

    @Override
    public String toString() {
        return "FunctionCallView{" +
                "functionId='" + functionId + '\'' +
                ", typeArgs=" + Arrays.toString(typeArgs) +
                ", args=" + Arrays.toString(args) +
                '}';
    }
}
