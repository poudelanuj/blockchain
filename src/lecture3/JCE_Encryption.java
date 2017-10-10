package lecture3;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class JCE_Encryption{

	public String Encrypt(String plainText, SecretKey key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException{
		
		Cipher desCipher;
		desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
		desCipher.init(Cipher.ENCRYPT_MODE,key);
		String encryptedText=Base64.getEncoder().encodeToString(desCipher.doFinal(plainText.getBytes("UTF-8")));
		
		

		
		return encryptedText;
		
		
	}
	
	public String Decrypt(String encryptedMessage,SecretKey key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		
		Cipher desCipher;
		desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
		desCipher.init(Cipher.DECRYPT_MODE,key);
		String textDecrypted=new String(desCipher.doFinal(Base64.getDecoder().decode(encryptedMessage)));
		
		return textDecrypted;
		
		
		
	}
	
	
	
}
