package caesar;
import java.util.Scanner;
public class caesarchiper {
	private String plain;
	private String chiper;
	private int key;
	
	public caesarchiper() {
		// TODO Auto-generated constructor stub
	}
	public caesarchiper(String msg,int key){
	
		this.plain=msg;
		this.key=key;
		this.chiper="";
		
	}
	public caesarchiper(int key,String msg){
		this.plain="";
		this.key=key;
		this.chiper=msg;
	}

	public String getPlain() {
		return plain;
	}

	public void setPlain(String plain) {
		this.plain = plain;
	}

	public String getChiper() {
		return chiper;
	}

	public void setChiper(String chiper) {
		this.chiper = chiper;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}
	
	public String encrypt(){
		setChiper("");
		int len=plain.length();
		for(int i=0;i<len;i++){
			char temp=plain.charAt(i);
			temp+=key;
			if(temp>'z'){
				temp-=26;
			}else if(temp>'Z'&&temp<'a'){
				temp-=26;
			}
			chiper+=temp;
		}
		
		return chiper;
	}
	public String decrypt(){
		setPlain("");
		int len=chiper.length();
		for(int i=0;i<len;i++){
			char temp=chiper.charAt(i);
			temp-=key;
			if(temp<'A'){
				temp+=26;
			}else if(temp>'Z'&&temp<'a'){
				temp+=26;
			}
			plain+=temp;
		}
		
		return plain;
	}
	
	public static void main(String [] args){
		Scanner s=new Scanner(System.in);
		caesarchiper c=new caesarchiper();
		System.out.println("Select option");
		System.out.println("1.Encrypt");
		System.out.println("2.Decrypt");
		int sel=s.nextInt();
		if(sel==1){
			
			System.out.println("Enter Plain message:");
			c.setPlain(s.next());
			int key;
			while(true){
				System.out.println("Enter key:bent(0,26)");
				key=s.nextInt();
				if(key<= 0 || key>25){
					System.out.println("Enter valid key");
				}else{
					break;
				}
			}
			c.setKey(key);
			System.out.println("CaesarChiper:");
			System.out.println(c.encrypt());	
		}else if(sel==2){
			System.out.println("Enter encrypted message:");
			c.setChiper(s.next());
			int key;
			while(true){
				System.out.println("Enter key:bent(0,26)");
				key=s.nextInt();
				if(key<= 0 || key>25){
					System.out.println("Enter valid key");
				}else{
					break;
				}
			}
			c.setKey(key);
			System.out.println("Plain text");
			System.out.println(c.decrypt());
		}else{
			System.out.println("Invalid selection");
		}
		
	}
	
}
