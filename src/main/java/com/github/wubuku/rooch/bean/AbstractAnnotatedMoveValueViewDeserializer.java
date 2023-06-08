package com.github.wubuku.rooch.bean;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;

public abstract class AbstractAnnotatedMoveValueViewDeserializer<S> extends JsonDeserializer<AnnotatedMoveValueView> {
    @Override
    public AnnotatedMoveValueView deserialize(JsonParser jsonParser, DeserializationContext ctx) throws IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (JsonToken.VALUE_STRING.equals(currentToken)) {
            return new AnnotatedStringView(jsonParser.getValueAsString());
            //throw new InvalidFormatException(jsonParser, "AnnotatedMoveValueViewDeserializer.deserialize() error.", currentToken, AnnotatedMoveValueView.class);
        } else if (JsonToken.VALUE_NULL.equals(currentToken)) {
            return null;
        } else if (currentToken.isBoolean()) {
            return new AnnotatedBooleanView(jsonParser.getValueAsBoolean());
        } else if (currentToken.isNumeric()) {
            return new AnnotatedNumberView(jsonParser.getNumberValue());
        } else if (currentToken.isScalarValue()) {
            throw new InvalidFormatException(jsonParser, "AnnotatedMoveValueViewDeserializer.deserialize() error.", currentToken, AnnotatedMoveValueView.class);
        } else if (JsonToken.START_OBJECT.equals(currentToken)) {
            String fieldName = jsonParser.nextFieldName();
            Integer abilities = null;
            String type = null;
            S value = null;
            while (null != fieldName) {
                if ("abilities".equals(fieldName)) {
                    jsonParser.nextToken();
                    abilities = jsonParser.getValueAsInt();
                } else if ("type".equals(fieldName)) {
                    jsonParser.nextToken();
                    type = jsonParser.getValueAsString();
                } else if ("value".equals(fieldName)) {
                    jsonParser.nextToken();
                    value = jsonParser.readValueAs(getMoveStructClass());
                } else {
                    throw new InvalidFormatException(jsonParser, "AnnotatedMoveValueViewDeserializer.deserialize() error. Unknown field name: " + fieldName, jsonParser.currentToken(), AnnotatedMoveValueView.class);
                }
                fieldName = jsonParser.nextFieldName();
            }
            if (!JsonToken.END_OBJECT.equals(jsonParser.currentToken())) {
                throw new InvalidFormatException(jsonParser, "AnnotatedMoveValueViewDeserializer.deserialize() error.", jsonParser.currentToken(), AnnotatedMoveValueView.class);
            }
            return new AnnotatedMoveStructView(abilities, type, value);
            //throw new InvalidFormatException(jsonParser, "AnnotatedMoveValueViewDeserializer.deserialize() error.", jsonParser.currentToken(), AnnotatedMoveValueView.class);
        } else if (JsonToken.START_ARRAY.equals(currentToken)) {
            //todo Not implemented yet
            throw new InvalidFormatException(jsonParser, "AnnotatedMoveValueViewDeserializer.deserialize() error.", jsonParser.currentToken(), AnnotatedMoveValueView.class);
        }
        return null;
    }

    protected abstract Class<S> getMoveStructClass();
}
