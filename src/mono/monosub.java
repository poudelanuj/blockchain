package mono;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class monosub {
	private List<Integer> mylist;
	private String plain;
	private String encrypt;
	public void generateList(){
		Random rand=new Random();
		int randomNum=0;
		mylist=new ArrayList<Integer>();
		for(int i=0;i<26;i++){
			randomNum=rand.nextInt(27-1)+1;
			while(mylist.contains(randomNum)){
				randomNum=rand.nextInt(27-1)+1;
			}
			System.out.println(randomNum);
			mylist.add(randomNum);
			
		}
		
		
	}
	
	public String encrypt(){
		setEncrypt("");
		generateList();
		int len=plain.length();
		String Up="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String Lo=Up.toLowerCase();
		
		for(int i=0;i<len;i++){
			char temp=plain.charAt(i);
			int key=0;
			if(temp>=97 && temp<=122){
				//key=mylist.indexOf((int)(temp-'a'+1));
				key=mylist.get(Lo.indexOf(temp));
				temp=Lo.charAt(key);
				
				
			}else if(temp>=65 && temp<=90){
				key=mylist.get(Up.indexOf(temp));
				temp=Up.charAt(key);
			}
			
			
			encrypt+=temp;
		}
		
		return encrypt;
	}
	
	public monosub(String plain) {
		// TODO Auto-generated constructor stub
		this.plain=plain;
	}
	public String getPlain() {
		return plain;
	}

	public void setPlain(String plain) {
		this.plain = plain;
	}

	public String getEncrypt() {
		return encrypt;
	}

	public void setEncrypt(String encrypt) {
		this.encrypt = encrypt;
	}

	public static void main(String [] args){
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the text to be encrpyt:");
		monosub m=new monosub(s.nextLine());
		String msg=m.encrypt();
		System.out.println(msg);
		
	}
	
}

