package lecture4;


import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.spec.SecretKeySpec;
import static org.junit.Assert.*;

import org.junit.Test;


public class CBC_Test {
	@Test
	public void test() throws NoSuchAlgorithmException, UnsupportedEncodingException{
	
		CBC_Mode cbc_Mode=new CBC_Mode();
		SecretKeySpec secretKeySpec=cbc_Mode.getSecretKey("asdfghjklqwertyu");
		String encryptedText=cbc_Mode.Encrypt("Hellonepal",secretKeySpec);
		System.out.println(encryptedText);
		assertEquals("CBC Mode:","Hellonepal",cbc_Mode.Decrypt(encryptedText, secretKeySpec));
		
	
	}
	

}