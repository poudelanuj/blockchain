package lecture1;
public  class CaesarChiper implements chiper {
	
	protected String plain;
	protected String chiper;
	protected int key;
	public String encrypt(String plain, String skey) {
		chiper="";
		int len=plain.length();
		key=Integer.parseInt(skey);
		for(int i=0;i<len;i++){
			char temp=plain.charAt(i);
			char test=temp;
			if(Character.isAlphabetic(temp)){
				temp+=key;
				if(temp>'z'){
					temp-=26;
				}
				if(temp>'Z' && test<='Z'){
					temp-=26;
				}
			}
			chiper+=temp;
		}
		return chiper;
	}

	public String decrypt(String chiper, String skey) {
		plain="";
		int len=chiper.length();
		key=Integer.parseInt(skey);
		for(int i=0;i<len;i++){
			char temp=chiper.charAt(i);
			char test=temp;
			if(Character.isAlphabetic(temp)){
				temp-=key;
				if(temp<'A'){
					temp+=26;
				}
				if(temp<'a' && test >='a'){
					temp+=26;
				}
			}
			
			plain+=temp;
		}
		
		return plain;
	}

}
