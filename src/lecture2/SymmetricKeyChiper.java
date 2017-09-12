package lecture2;

import lecture1.chiper;

public class SymmetricKeyChiper implements chiper {
	
	public static int[] s = new int[256]; 
	public static int[] t = new int[256]; 
	public String key, input;


	public  String  encrypt(String input,String key) {
		String encrypt="";
		int j = 0;
		for (int i = 0; i < 256; i++) {
			if (j == key.length())
				j = 0;
			t[i] = (int) (key.charAt(j++));
		}
		for (int i = 0; i < 256; i++)
			s[i] = i;
		j = 0;
		for (int i = 0; i < 256; i++) {
			j = (j + s[i] + 256) % 256;
			swap(i, j);
		}
		int Rand = 0;
		j = 0;
		int i = 256;
		for (int x = 0; x < input.length(); x++) {
			i = (i + 1) % 256;
			j = (j + s[i] + 256) % 256;
			swap(i, j);
			Rand = (char) s[((s[i] + s[j]) % 256)];
			encrypt+=(char) (input.charAt(x) ^ Rand);
		}
		return encrypt;
	}
	
	public String decrypt(String enc,String key){
		return encrypt(enc, key);
	}

	

	static void swap(int i, int j) {
		int temp = s[i];
		s[i] = s[j];
		s[j] = temp;
	}
}