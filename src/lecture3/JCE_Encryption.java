package lecture3;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class JCE_Encryption {
	
	public static void main(String [] args){
		try{
			Scanner scanner=new Scanner(System.in);
			KeyGenerator keyGenerator=KeyGenerator.getInstance("DES");
			SecretKey myDesKey=keyGenerator.generateKey();
			
			Cipher desCipher;
			desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

			desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
			
			byte[] text=scanner.nextLine().getBytes();
			System.out.println("Text [byte format]:"+text);
			System.out.println("Text : "+new String(text));
			
			//encrypt the text
			byte[] textEncrypted=desCipher.doFinal(text);
			System.out.println("Text Encrypted : "+textEncrypted);
			
			//init the same chiper for description
			desCipher.init(Cipher.DECRYPT_MODE, myDesKey);
			byte[] textDecrypted=desCipher.doFinal(textEncrypted);
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
