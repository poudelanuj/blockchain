package lecture1;
import static org.junit.Assert.*;

import org.junit.Test;


public class MonoSubTest {

	@Test
	public void test() {
		MonoSub monoSub=new MonoSub();
		String enc=monoSub.encrypt("Anuj", "ZXCVBNMASDFGHJKLQWERTYUIOP");
		assertEquals("text check","Anuj",monoSub.decrypt(enc,"ZXCVBNMASDFGHJKLQWERTYUIOP"));
		enc=monoSub.encrypt("http://google.com","QWERTYUIOPLKJHGFDSAZXCVBNM");
		assertEquals("Domain Check","http://google.com",monoSub.decrypt(enc,"QWERTYUIOPLKJHGFDSAZXCVBNM"));
	}

}
