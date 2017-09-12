import static org.junit.Assert.*;

import org.junit.Test;


public class CaesarTest {

	@Test
	public void test() {
		CaesarChiper caesarChiper = new CaesarChiper();
		String key = "2";
		String enc = caesarChiper.encrypt("anuj", key);
		System.out.println(enc);
		assertEquals("text check","anuj",caesarChiper.decrypt(enc,key));

		key = "25";
		enc = caesarChiper.encrypt("http://google.com", key);
		System.out.println(enc);
		assertEquals("domain check","http://google.com",caesarChiper.decrypt(enc,key));
	}

}
