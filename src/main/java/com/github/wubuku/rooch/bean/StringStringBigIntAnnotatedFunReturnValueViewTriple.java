package com.github.wubuku.rooch.bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = StringStringBigIntAnnotatedFunReturnValueViewTriple.Deserializer.class)
public class StringStringBigIntAnnotatedFunReturnValueViewTriple extends Triple<
        StringAnnotatedFunctionReturnValueView,
        StringAnnotatedFunctionReturnValueView,
        BigIntegerAnnotatedFunctionReturnValueView
        > {

    public static class Deserializer extends AbstractTripleDeserializer<
            StringAnnotatedFunctionReturnValueView,
            StringAnnotatedFunctionReturnValueView,
            BigIntegerAnnotatedFunctionReturnValueView
            > {

        @Override
        protected Class<StringAnnotatedFunctionReturnValueView> item1Class() {
            return StringAnnotatedFunctionReturnValueView.class;
        }

        @Override
        protected Class<StringAnnotatedFunctionReturnValueView> item2Class() {
            return StringAnnotatedFunctionReturnValueView.class;
        }

        @Override
        protected Class<BigIntegerAnnotatedFunctionReturnValueView> item3Class() {
            return BigIntegerAnnotatedFunctionReturnValueView.class;
        }

        @Override
        protected Triple<StringAnnotatedFunctionReturnValueView, StringAnnotatedFunctionReturnValueView, BigIntegerAnnotatedFunctionReturnValueView> newInstance() {
            return new StringStringBigIntAnnotatedFunReturnValueViewTriple();
        }
    }
}
