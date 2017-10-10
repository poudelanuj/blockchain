package lecture5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;

public class Hashing {
	
	private static Scanner scanner;

	public static void main(String[] args) throws NoSuchAlgorithmException{
		scanner = new Scanner(System.in);
		System.out.print("Enter the text to do Hashing:");
		String message=scanner.nextLine();
		// select the hash function, eg. SHA1, SHA-224, SHA-256, SHA-512
		MessageDigest messageDigest=MessageDigest.getInstance("SHA-512");
		
		byte[] encodedHash=messageDigest.digest(message.getBytes());
		String encodedHashString=new String(Base64.getEncoder().encode(encodedHash));
		System.out.println("Hash:"+encodedHashString);
		
	}

}
