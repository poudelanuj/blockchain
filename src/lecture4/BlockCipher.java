package lecture4;

import javax.crypto.spec.SecretKeySpec;


public interface BlockCipher {
	
	public String Encrypt(String plainText,SecretKeySpec key);
	public String Decrypt(String encryptedText,SecretKeySpec key);

}
