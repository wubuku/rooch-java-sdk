package com.github.wubuku.rooch.bean;

import java.util.Map;

public class AnnotatedMoveValueViewDeserializer extends AbstractAnnotatedMoveValueViewDeserializer<Map>{
    @Override
    public Class<Map> getMoveStructClass() {
        return Map.class;
    }
}
