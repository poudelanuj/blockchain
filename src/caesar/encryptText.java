package caesar;

import static org.junit.Assert.*;

import org.junit.Test;

public class encryptText {

	@Test
	public void test() {
		caesarchiper test=new caesarchiper("anj",2);
		String output=test.encrypt();
		assertEquals("dqm", output);
	}

}
