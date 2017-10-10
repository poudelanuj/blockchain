package lecture4;

import static org.junit.Assert.*;

import javax.crypto.spec.SecretKeySpec;

import org.junit.Test;

public class ECB_Test {

	@Test
	public void test() {
		SecretKeySpec aesKey = new SecretKeySpec("abcdef0123456789".getBytes(), "AES");
		ECB_Mode action=new ECB_Mode();
		String encMsg=action.Encrypt("hellonepal", aesKey);
		System.out.println(encMsg);
		assertEquals("ECB test:","hellonepal",action.Decrypt(encMsg, aesKey));
		
	}

}
