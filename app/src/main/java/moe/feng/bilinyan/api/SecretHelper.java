package moe.feng.bilinyan.api;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import moe.feng.bilinyan.util.UrlBuilder;

public class SecretHelper {

	public static String produceMD5(UrlBuilder url, String appSecret) {
		try {
			return encodeMD5String(url.toStringWithoutUrlRoot() + appSecret);
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}

	public static String encodeMD5String(String original) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("MD5");
		digest.update(original.getBytes());
		byte[] bytes = digest.digest();
		StringBuffer sb = new StringBuffer("");
		for (byte bit : bytes) {
			sb.append(Integer.toHexString(bit & 0xff));
		}
		return sb.toString();
	}

}
