package gfg;

import java.util.Arrays;

public class PermutationOfAString {

	
	public static void main(String[] args) {
		String s="ABSG";
		
		char[] cs=s.toCharArray();
		Arrays.sort(cs);
		s=new String(cs);
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
