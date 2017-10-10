package lecture4;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class CBC_Mode implements BlockCipher{

	public byte[] iv;
	public String Encrypt(String plainText, SecretKeySpec key) {
		IvParameterSpec ivParameterSpec = new IvParameterSpec(getIV());
		String encryptedText=null;
		try {
			Cipher cipher=Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE,key,ivParameterSpec);
			encryptedText=Base64.getEncoder().encodeToString(cipher.doFinal(plainText.getBytes("UTF-8")));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return encryptedText;
	}

	public String Decrypt(String encryptedText, SecretKeySpec key) {
		IvParameterSpec ivParameterSpec = new IvParameterSpec(this.iv);
		Cipher cipherDecrypt;
		String decrypted=null;
		try {
			cipherDecrypt = Cipher.getInstance("AES/CBC/PKCS5Padding");
			//cipherDecrypt=Cipher.getInstance("AES/CFB/NoPadding");
			// TODO this is used for CBF
			cipherDecrypt.init(Cipher.DECRYPT_MODE, key, ivParameterSpec);
			decrypted = new String(cipherDecrypt.doFinal(Base64.getDecoder().decode(encryptedText)));
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return decrypted;
	}
	
	public SecretKeySpec getSecretKey(String keyText) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		
		MessageDigest digest;
		digest = MessageDigest.getInstance("SHA-256");
		digest.update("0123456789abcdef".getBytes("UTF-8"));
		byte[] keyBytes = new byte[16];
		System.arraycopy(digest.digest(), 0, keyBytes, 0, keyBytes.length);
		SecretKeySpec secretKeySpec= new SecretKeySpec(keyBytes, "AES");
			
		
		return secretKeySpec;
		
	}
	private byte[] getIV(){
		int ivSize = 16;
		byte[] iv = new byte[ivSize];
		SecureRandom random = new SecureRandom();
		random.nextBytes(iv);
		this.iv=iv;
		return iv;
		
	}
	
	

}
