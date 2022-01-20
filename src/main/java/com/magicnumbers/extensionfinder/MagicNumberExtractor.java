package com.magicnumbers.extensionfinder;

import java.util.List;

/**
 * @author Adam Niemiec
 */
class MagicNumberExtractor {

    private String validateHexStringLength(String hexString) {
        if (hexString.length() < 2) {
            hexString = "0" + hexString;
        }
        return hexString;
    }

    private String decToHex(byte b) {
        int value = b & 0xFF;
        String hexString = Integer.toHexString(value);
        return validateHexStringLength(hexString);
    }

    String getHeader(List<Byte> bytes) {
        StringBuilder stringBuilder = new StringBuilder();

        for (byte b : bytes) {
            stringBuilder.append(decToHex(b));
        }
        return stringBuilder.toString();
    }
}