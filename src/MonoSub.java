public class MonoSub implements chiper {
	
	private String plain;
	private String encrypt;
	String Up="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String Lo=Up.toLowerCase();
	
	
	public String encrypt(String plain,String key){
		encrypt="";
		int len=plain.length();
		String lkey=key.toLowerCase();
		
		for(int i=0;i<len;i++){
			char temp=plain.charAt(i);
			char skey=0;
			if(Character.isAlphabetic(temp)){
				if(temp>=97 && temp<=122){
					skey=lkey.charAt(Lo.indexOf(temp));	
				}else if(temp>=65 && temp<=90){
					skey=key.charAt(Up.indexOf(temp));	
				}
				encrypt+=skey;
			}else{
				encrypt+=temp;
			}
			
		}
		return encrypt;
	}
	
	public String decrypt(String encrypt,String key){
	
		plain="";
		int len=encrypt.length();
		String lkey=key.toLowerCase();
		
		for(int i=0;i<len;i++){
			char temp=encrypt.charAt(i);
			char skey=0;
			if(Character.isAlphabetic(temp)){
				if(temp>=97 && temp<=122){
					skey=Lo.charAt(lkey.indexOf(temp));
				}else if(temp>=65 && temp<=90){
					skey=Up.charAt(key.indexOf(temp));	
				}
				plain+=skey;
			}else{
				plain+=temp;
			}
			
		}
		return plain;	
	}
}

