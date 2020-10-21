package com.Base64;



import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class XLineSignature {
    public String getSignature(String channelSecret, String httpRequestBody) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        SecretKeySpec key = new SecretKeySpec(channelSecret.getBytes(), "HmacSHA256");
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(key);
        byte[] source = httpRequestBody.getBytes("UTF-8");
        String signature = Base64.encodeBase64String(mac.doFinal(source));
// Compare X-Line-Signature request header string and the signature
        return signature;
    }
}

