package lecture1;
public class PolySub implements chiper {
	public static char [][] arr;
	final String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public PolySub(){
		generateMat();
	}

	public void generateMat(){
		arr=new char[30][30];
		char val='A';
		for(int i=0;i<26;i++){
			char v=val;
			for(int j=0;j<26;j++){
				char value=(char) (v+j);
				if(value>'Z'){
					value-=26;				
				}
				arr[i][j]=value;		
			}
			val+=1;
		}
		
		
	}
	
	public String encrypt(String plain,String key){
		String encrypted="";
		for(int i=0;i<plain.length();i++){
			int tempMsg=AB.indexOf(plain.charAt(i));
			int tempKey=AB.indexOf(key.charAt(i));
			char enc=arr[tempKey][tempMsg];
			encrypted+=enc;	
		}
		return encrypted;
	}
	
	public String decrypt(String encrypt,String key){
		String plain="";
		for(int i=0;i<encrypt.length();i++){
			int tempKey=AB.indexOf(key.charAt(i));
			char tempEnc=encrypt.charAt(i);
			for(int j=0;j<26;j++){
				if(arr[tempKey][j]==tempEnc){
					plain+=AB.charAt(j);
					break;
				}
			}
			
		}
		return plain;
	}

}
