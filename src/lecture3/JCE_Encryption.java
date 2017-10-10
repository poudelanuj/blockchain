package lecture3;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class JCE_Encryption{
	
	private static Scanner scanner;

	public static void main(String [] args) throws UnsupportedEncodingException{
		try{
			scanner = new Scanner(System.in);
			KeyGenerator keyGenerator=KeyGenerator.getInstance("DES");
			SecretKey myDesKey=keyGenerator.generateKey();
			
			Cipher desCipher;
			desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

			desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
			
			String text=scanner.nextLine();
			//encrypt the text
			String encryptedText=Base64.getEncoder().encodeToString(desCipher.doFinal(text.getBytes("UTF-8")));
			System.out.println("Text Encrypted : "+encryptedText);
			
			//init the same chiper for description
			desCipher.init(Cipher.DECRYPT_MODE, myDesKey);
			String textDecrypted=new String(desCipher.doFinal(Base64.getDecoder().decode(encryptedText)));
			System.out.println("Text Decrypted : "+new String(textDecrypted));
			
			
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}catch(InvalidKeyException e){
			e.printStackTrace();
		}catch(IllegalBlockSizeException e){
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
}
