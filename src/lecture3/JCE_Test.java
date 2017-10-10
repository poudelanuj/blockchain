package lecture3;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import org.junit.Test;

public class JCE_Test {

	@Test
	public void test() throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
		KeyGenerator keyGenerator=KeyGenerator.getInstance("DES");
		SecretKey myDesKey=keyGenerator.generateKey();
		JCE_Encryption jce_Encryption=new JCE_Encryption();
		String encryptedMessage=jce_Encryption.Encrypt("HelloNepal", myDesKey);
		assertEquals("DES Test:","HelloNepal",jce_Encryption.Decrypt(encryptedMessage, myDesKey));
		
		
	}

}
