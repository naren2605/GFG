package gfg;

public class PermutationOfAString {

	
	public static void main(String[] args) {
		String s="two";
		permute("", s, s.length());
	}
	
	public static void permute(String left,String right,int n){
		//System.out.println(left);
		if(left.length()==n){
			System.out.println(left);
		}
		else{
			for(int i=0;i<right.length();i++){
				permute(left+right.substring(i, i+1), right.substring(0, i)+right.substring(i+1), n);
			}
		}
		
	}
	
}
