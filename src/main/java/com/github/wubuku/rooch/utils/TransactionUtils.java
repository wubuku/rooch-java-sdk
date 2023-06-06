package com.github.wubuku.rooch.utils;

import com.google.common.primitives.Bytes;

public class TransactionUtils {
    /**
     * This is currently hardcoded.
     */
    public static final byte[] INTENT_BYTES = new byte[]{0, 0, 0};

    private TransactionUtils() {
    }

    /**
     * @param privateKey private key
     * @param txBytes    BCS serialized transaction data bytes without its type tag.
     */
    public static byte[] ed25519SignTransactionBytes(byte[] privateKey, byte[] txBytes) {
        return SignatureUtils.ed25519Sign(privateKey, Bytes.concat(TransactionUtils.INTENT_BYTES, txBytes));
    }

}
