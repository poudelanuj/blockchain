package caesar;

import static org.junit.Assert.*;

import org.junit.Test;

public class decryptTest {

	@Test
	public void test() {
		caesarchiper test=new caesarchiper(3,"des");
		String output=test.decrypt();
		assertEquals("abp", output);
	}

}
