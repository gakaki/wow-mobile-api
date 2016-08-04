package com.wow.order.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.X509EncodedKeySpec;

import org.apache.commons.codec.binary.Base64;

import com.wow.common.util.StringUtil;

public class WebhooksVerifyUtil {

    public static String pubKeyPath = "";

    private static String pubKeyContent = "";

    /**
     * 将字符串进行64位编码
     * 
     * @param content
     * @return
     */
    private static byte[] decodeBase64(String content) {
        return Base64.decodeBase64(content);
    }

    /**
     * 读取文件, 部署 web 程序的时候, 签名和验签内容需要从 request 中获得
     * @param filePath
     * @return
     * @throws Exception
     */
    private static String getStringFromFile() throws Exception {
        if (StringUtil.isNotEmpty(pubKeyContent)) {
            return pubKeyContent;
        }

        FileInputStream in = new FileInputStream(pubKeyPath);
        InputStreamReader inReader = new InputStreamReader(in, "UTF-8");
        BufferedReader bf = new BufferedReader(inReader);
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            while ((line = bf.readLine()) != null) {
                if (sb.length() != 0) {
                    sb.append("\n");
                }
                sb.append(line);
            }
        } finally {
            try {
                if (bf != null) {
                    bf.close();
                }
            } catch (IOException e) {
            }
        }

        pubKeyContent = sb.toString();

        return pubKeyContent;
    }

    /**
     * 获得公钥
     * @return
     * @throws Exception
     */
    public static PublicKey getPubKey() throws Exception {
        String pubKeyString = getStringFromFile();
        pubKeyString = pubKeyString.replaceAll("(-+BEGIN PUBLIC KEY-+\\r?\\n|-+END PUBLIC KEY-+\\r?\\n?)", "");
        byte[] keyBytes = decodeBase64(pubKeyString);

        // generate public key
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(spec);
        return publicKey;
    }

    /**
     * 验证签名
     * @param dataString
     * @param signatureString
     * @param publicKey
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws SignatureException
     */
    public static boolean verifyData(String dataString, String signatureString) {
        byte[] signatureBytes = decodeBase64(signatureString);
        Signature signature;
        try {
            signature = Signature.getInstance("SHA256withRSA");
            signature.initVerify(getPubKey());
            signature.update(dataString.getBytes("UTF-8"));
            return signature.verify(signatureBytes);
        } catch (Exception e) {
            return false;
        }

    }

}
