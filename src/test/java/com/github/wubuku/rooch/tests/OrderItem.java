// <autogenerated>
//   This file was generated by T4 code generator .
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package com.github.wubuku.rooch.tests;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.math.BigInteger;

@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class)
public class OrderItem {

    private String productId;

    private BigInteger quantity;

    private BigInteger itemAmount;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public BigInteger getQuantity() {
        return quantity;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }

    public BigInteger getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(BigInteger itemAmount) {
        this.itemAmount = itemAmount;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "productId=" + '\'' + productId + '\'' +
                ", quantity=" + quantity +
                ", itemAmount=" + itemAmount +
                '}';
    }
}
