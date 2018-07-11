package gfg;

import java.util.Scanner;

public class FingerPrints {

    public static void main(String[] args) {
        Scanner scanner=new Scanner( System.in);
        int n=scanner.nextInt();
        int k=scanner.nextInt();
        boolean array[]=new boolean[10];
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        for (int i=0;i<k;i++){
            array[scanner.nextInt()]=true;
        }
        for(int i=0;i<n;i++){
        if(array[arr[i]]){
            System.out.print(arr[i]+" ");
        }
        }
        System.out.println();
    }
}
