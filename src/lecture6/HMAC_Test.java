package lecture6;

import static org.junit.Assert.*;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

public class HMAC_Test {

	@Test
	public void test() throws InvalidKeyException, NoSuchAlgorithmException {
		HMAC hmac=new HMAC("1234567890abcdef"); //this is the key for encryption
		String [] value=new String[2];
		String [] retValue=new String[2];
		
		value=hmac.Encrypt_MAC("Some Text","Hello nepal");
		retValue=hmac.Decrypt_MAC(value[0], "Hello nepal");
		assertEquals("Some Text",retValue[0]);// test for send text
		
		assertEquals(value[1],retValue[1]);// test for the mac key
		
		
	}

}
