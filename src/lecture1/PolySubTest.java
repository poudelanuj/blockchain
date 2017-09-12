package lecture1;
import static org.junit.Assert.*;

import org.junit.Test;


public class PolySubTest {

	@Test
	public void test() {
		PolySub polySub=new PolySub();
		String enc=polySub.encrypt("ANUJ","SDCF");
		System.out.println(enc);
		assertEquals("text test","ANUJ",polySub.decrypt(enc,"SDCF"));
		
	}

}
