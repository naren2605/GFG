package gfg;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class KandanesAlgorithm {

	public static void main(String[] args) {
		
	
		int[] array=new int[10];
		
		Random rand=new Random();
		Scanner scanner=new Scanner(System.in);
/*	for(int k=0;k<10;k++){
		for(int i=0;i<10;i++){
			array[i]=rand.nextInt(10);
			if(rand.nextBoolean()){
				array[i]=0-array[i];
			}
		}
		System.out.print(Arrays.toString(array));
		bruteForceMaxSumSubArray(array);
		kandanesMaxSumSubArray(array);
		System.out.println();
	}*/
		bruteForceMaxSumSubArray(new int[]{-1,16,-15,24,-23,25});
		kandanesMaxSumSubArray(new int[]{-1,16,-15,24,-23,25});
		kandanesMaxSumSubArray2(new int[]{-1,16,-15,24,-23,25});
	}
	
	
	public static void bruteForceMaxSumSubArray(int[] array){
		
		int sum=Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			int temp=0;
			for (int j = i; j < array.length; j++) {
				temp=temp+array[j];
				if (temp>sum) sum=temp;
			}
			
		}
		
		System.out.print("="+sum);
	}
	
	/*
	 *  order n time, order n space
	 * 
	 */
			
	public static void kandanesMaxSumSubArray(int[] array){
		
		int sums[]=new int[array.length];
		sums[0]=array[0];
		int 		sum=sums[0];
		for (int i = 1; i < array.length; i++) {
		
			sums[i]=Math.max(array[i], sums[i-1]+array[i]);
			sum=Math.max(sum, sums[i]);
		}

	System.out.print(" >>> "+sum);		
		}
		
	



/*
 * order n time, order 1 space
 */
public static void kandanesMaxSumSubArray2(int[] array){
	
	int sums[]=new int[array.length];
	sums[0]=array[0];
	int 		sum=sums[0];
	int sumNminus1=sums[0];
	for (int i = 1; i < array.length; i++) {
	
		sumNminus1=Math.max(array[i], sumNminus1+array[i]);
		sum=Math.max(sum, sumNminus1);
	}

System.out.print(" >>> "+sum);		
	}
	


}