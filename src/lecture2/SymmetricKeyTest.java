package lecture2;

import static org.junit.Assert.*;

import org.junit.Test;

public class SymmetricKeyTest {

	@Test
	public void test() {
		SymmetricKeyChiper symmetricKeyChiper=new SymmetricKeyChiper();
		String  enc=symmetricKeyChiper.encrypt("ANUJ", "HELO");
		assertEquals("text test:","ANUJ",symmetricKeyChiper.decrypt(enc, "HELO"));
	}

}
