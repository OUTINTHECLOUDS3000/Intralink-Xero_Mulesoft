package com.example.utils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class HmacUtil {
    public static String calculateHMAC(String data, String base64Key) throws Exception {
        byte[] key = Base64.getDecoder().decode(base64Key);
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "HmacSHA256");

        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(secretKeySpec);

        byte[] hmacBytes = mac.doFinal(data.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(hmacBytes);
    }
}
