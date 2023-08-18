package com.github.wubuku.rooch.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.wubuku.rooch.bean.HexToIntArrayDeserializer;

import java.io.IOException;
import java.util.Arrays;

public class JsonTests {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String json = "{\"deliveryWeekdays\":\"01020304050607\"}";
        Delivery delivery = mapper.readValue(json, Delivery.class);
        System.out.println(Arrays.toString(delivery.getDeliveryWeekdays()));

        String json2 = "{\"deliveryWeekdays\":[1,2,3,4,5,6,7]}";
        Delivery delivery2 = mapper.readValue(json2, Delivery.class);
        System.out.println(Arrays.toString(delivery2.getDeliveryWeekdays()));

        String json3 = "{\"deliveryWeekdays\":\"0x\"}";
        Delivery delivery3 = mapper.readValue(json3, Delivery.class);
        System.out.println(Arrays.toString(delivery3.getDeliveryWeekdays()));
    }

    public static class Delivery {
        @JsonDeserialize(using = HexToIntArrayDeserializer.class)
        private Integer[] deliveryWeekdays;

        public Integer[] getDeliveryWeekdays() {
            return deliveryWeekdays;
        }

        public void setDeliveryWeekdays(Integer[] deliveryWeekdays) {
            this.deliveryWeekdays = deliveryWeekdays;
        }
    }
}
