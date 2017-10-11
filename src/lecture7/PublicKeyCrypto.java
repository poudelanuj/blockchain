package lecture7;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class PublicKeyCrypto {
	private Scanner fileIn;

	public void Encrypt(String inputfilename,String outputfilename,PublicKey publicKey) throws IOException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException{
		BufferedWriter writer=null;
		try{
			writer=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputfilename),"utf-8"));
			
			fileIn = new Scanner(new File(inputfilename));
			while(fileIn.hasNextLine()){
				String line=fileIn.nextLine();
				RSA rsa=new RSA();
				writer.write(rsa.RSA_Encrypt(line, publicKey)+"\n");
			}
			
		}finally{
			if(writer!=null){
				writer.close();
			}
		}
		
		
	}
	public void Decrypt(String inputfilename,String outputfilename,PrivateKey privateKey) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, IOException{
		BufferedWriter writer=null;
		try{
			writer=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputfilename),"utf-8"));
			
			fileIn = new Scanner(new File(inputfilename));
			while(fileIn.hasNextLine()){
				String line=fileIn.nextLine();
				RSA rsa=new RSA();
				writer.write(rsa.RSA_Decrypt(line, privateKey)+"\n");
			}
			
		}finally{
			if(writer!=null){
				writer.close();
			}
		}
		
		
	}
	
	public static void main(String[] args) throws IOException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException{
		PublicKeyCrypto publicKeyCrypto=new PublicKeyCrypto();
		KeyGeneration keyGeneration=new KeyGeneration();
		KeyPair keyPair=keyGeneration.generateKey(1024);
		publicKeyCrypto.Encrypt("text.txt","encrypted.txt",keyPair.getPublic());
		publicKeyCrypto.Decrypt("encrypted.txt","decrypted.txt",keyPair.getPrivate() );
	}
}
