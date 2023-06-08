package com.github.wubuku.rooch.bean;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;

public abstract class AbstractTripleDeserializer<T1, T2, T3> extends JsonDeserializer<Triple<T1, T2, T3>> {
    @Override
    public Triple<T1, T2, T3> deserialize(JsonParser jsonParser, DeserializationContext ctx) throws IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        ctx.getContextualType();
        if (JsonToken.VALUE_STRING.equals(currentToken)) {
            throw new InvalidFormatException(jsonParser, "AbstractTripleDeserializer.deserialize() error.", currentToken, AbstractTripleDeserializer.class);
        } else if (JsonToken.VALUE_NULL.equals(currentToken)) {
            return null;
        } else if (currentToken.isBoolean()) {
            throw new InvalidFormatException(jsonParser, "AbstractTripleDeserializer.deserialize() error.", currentToken, AbstractTripleDeserializer.class);
        } else if (currentToken.isNumeric()) {
            throw new InvalidFormatException(jsonParser, "AbstractTripleDeserializer.deserialize() error.", currentToken, AbstractTripleDeserializer.class);
        } else if (currentToken.isScalarValue()) {
            throw new InvalidFormatException(jsonParser, "AbstractTripleDeserializer.deserialize() error.", currentToken, AbstractTripleDeserializer.class);
        } else if (JsonToken.START_OBJECT.equals(currentToken)) {
            throw new InvalidFormatException(jsonParser, "AbstractTripleDeserializer.deserialize() error.", jsonParser.currentToken(), AbstractTripleDeserializer.class);
        } else if (JsonToken.START_ARRAY.equals(currentToken)) {
            Triple<T1, T2, T3> triple = newInstance();
            jsonParser.nextToken();
            triple.setItem1(jsonParser.readValueAs(item1Class()));
            jsonParser.nextToken();
            triple.setItem2(jsonParser.readValueAs(item2Class()));
            jsonParser.nextToken();
            triple.setItem3(jsonParser.readValueAs(item3Class()));
            jsonParser.nextToken();
            if (!JsonToken.END_ARRAY.equals(jsonParser.currentToken())) {
                throw new InvalidFormatException(jsonParser, "AbstractTripleDeserializer.deserialize() error.", jsonParser.currentToken(), AbstractTripleDeserializer.class);
            }
            return triple;
        }
        return null;
    }

    protected abstract Class<T1> item1Class();

    protected abstract Class<T2> item2Class();

    protected abstract Class<T3> item3Class();

    protected abstract Triple<T1, T2, T3> newInstance();
}
