package gfg;

import java.util.Arrays;
import java.util.Random;

public class KandanesAlgorithm {

	public static void main(String[] args) {
		
	
		int[] array=new int[10];
		
		Random rand=new Random();
	
		for(int i=0;i<10;i++){
			array[i]=rand.nextInt(10);
			if(rand.nextBoolean()){
				array[i]=0-array[i];
			}
		}
		System.out.println(Arrays.toString(array));
		bruteForceMaxSumSubArray(array);
		
		
	}
	
	
	public static void bruteForceMaxSumSubArray(int[] array){
		
		int sum=Integer.MIN_VALUE;
		for (int i = 0; i < array.length-1; i++) {
			int temp=0;
			for (int j = i; j < array.length; j++) {
				temp=temp+array[i];
				if (temp>sum) sum=temp;
			}
			
		}
		
		System.out.println(sum);
	}

}
