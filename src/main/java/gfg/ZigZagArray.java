package gfg;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.geeksforgeeks.org/convert-array-into-zig-zag-fashion/
 * @author narendra kumar
 *
 */
public class ZigZagArray {
	
	void convert(Integer[] array){
		
		for(int index=1;index<array.length;index++){
			if(index%2!=0){
				if(array[index]<array[index-1]){
					int tmp=array[index];
					array[index]=array[index-1];
					array[index-1]=tmp;
				}
			}
			else{
				if(array[index]>array[index-1]){
					int tmp=array[index];
					array[index]=array[index-1];
					array[index-1]=tmp;
				}
			}	
		}
		
	}

	public static void main(String[] args) {
		
		ZigZagArray zigZagArray=new ZigZagArray();
		
		Scanner scanner = new Scanner(System.in);
		
		int t=scanner.nextInt();
		
		while(t-->0){
			
			int n=scanner.nextInt();
			Integer[] array =new Integer[n];
			for(int i=0;i<n;i++){
				array[i]=scanner.nextInt();
			}
			zigZagArray.convert(array);
			for(int i=0;i<n;i++){
				System.out.print(array[i]+" ");
			}
			System.out.println();
		}
		
		
	}
}
