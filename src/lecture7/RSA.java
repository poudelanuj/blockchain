package lecture7;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class RSA {
	
	public String RSA_Encrypt(String plainText,PublicKey publicKey) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		String encryptedText=null;
		Cipher cipher=Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		encryptedText=Base64.getEncoder().encodeToString(cipher.doFinal(plainText.getBytes("UTF-8")));
		
		return encryptedText;
	}
	
	public String RSA_Decrypt(String encryptedText,PrivateKey privateKey) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		String decryptedText=null;
		Cipher cipher=Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		decryptedText=new String(cipher.doFinal(Base64.getDecoder().decode(encryptedText)));
		
		return decryptedText;
	}
	
	
	

}
