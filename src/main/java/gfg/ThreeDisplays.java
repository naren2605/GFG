package gfg;

import java.util.Scanner;

public class ThreeDisplays {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int[] display_size=new int[n];
		int[] display_cost=new int[n];
		for(int i=0;i<n;i++){
			display_size[i]=scan.nextInt();
		}
		for(int i=0;i<n;i++){
			display_cost[i]=scan.nextInt();
		}
		int mincost=Integer.MAX_VALUE;
		int[] minar=new int[n];
		for(int i=n-2;i>=0;i--){
			int tempmin=Integer.MAX_VALUE;
			for(int j=n-1;j>i;j--){
				
				if(display_size[i]<display_size[j]){
					if(minar[j]!=0&&minar[j]!=Integer.MAX_VALUE){
						mincost=Math.min(display_cost[i]+minar[j],mincost);
					}
					tempmin=Math.min(tempmin,display_cost[i]+display_cost[j]);
				}
			}
			minar[i]=tempmin;
		}
		if(mincost==Integer.MAX_VALUE){
			System.out.println("-1");
		}
		else{
			System.out.println(mincost);
		}
	}
}
