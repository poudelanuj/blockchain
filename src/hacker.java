

import java.util.Scanner;

public class hacker {
	private String encrypted;
	private String decrypted;
	
	public hacker(){
		
	}
	public hacker(String msg){
		this.encrypted=msg;
	
		
	}
	public void decrypt(){
		for(int i=1;i<26;i++){
			decrypted="";
			
			int len=encrypted.length();
			for(int l=0;l<len;l++){
				char temp=encrypted.charAt(l);
				temp-=i;
				if(temp<'A'){
					temp+=26;
				}else if(temp>'Z'&&temp<'a'){
					temp+=26;
				}
				decrypted=decrypted+temp;
				
			}
			System.out.println(decrypted);
			
		}
	}
	public static void main(String [] args){
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the encrypted text:");
		String enc=s.nextLine();
		
		hacker h=new hacker(enc);
		System.out.println("Possible text:");
		h.decrypt();
		
	}
	
	
}

	

