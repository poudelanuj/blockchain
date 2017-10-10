package lecture6;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import lecture4.ECB_Mode;

public class HMAC {
	
	private String encryptionKeyString;
	private String [] encvalue=new String[2];
	private String [] decvalue=new String[2];
	
	public HMAC(String encryptionKeyString){
		this.encryptionKeyString=encryptionKeyString;
		
	}
	
	public String []  Encrypt_MAC(String plainText,String macKeyString) throws NoSuchAlgorithmException, InvalidKeyException{
		
		ECB_Mode cbc_mode=new ECB_Mode();//this class is in lecture 4
		SecretKeySpec encryptionKey = new SecretKeySpec(encryptionKeyString.getBytes(), "AES");
		String encryptedString=cbc_mode.Encrypt(plainText, encryptionKey);
		String macString=getMac(plainText,macKeyString);
		encvalue[0]=encryptedString;
		encvalue[1]=macString;
		
		return encvalue;
	}
	public String [] Decrypt_MAC(String encryptedMsg,String macKeyString) throws InvalidKeyException, NoSuchAlgorithmException{
		ECB_Mode cbc_mode=new ECB_Mode();//this class is in lecture 4
		SecretKeySpec key = new SecretKeySpec(encryptionKeyString.getBytes(), "AES");
		String decryptedString=cbc_mode.Decrypt(encryptedMsg, key);
		
		String macString=getMac(decryptedString, macKeyString);
		
		decvalue[0]=decryptedString;
		decvalue[1]=macString;
		
		return decvalue;
		
		
	}
	
	
	private String getMac(String plainText,String macKeyString) throws NoSuchAlgorithmException, InvalidKeyException{
		String HMAC_ALGORITHM = "HmacSha1";
		
		SecretKeySpec signingKey = new SecretKeySpec(macKeyString.getBytes(), HMAC_ALGORITHM);
		Mac mac = Mac.getInstance(HMAC_ALGORITHM);
		mac.init(signingKey);
		byte[] macBytes = mac.doFinal(plainText.getBytes());
		String macString = new String(Base64.getEncoder().encode(macBytes));
		
		return macString;
		
	}

}
