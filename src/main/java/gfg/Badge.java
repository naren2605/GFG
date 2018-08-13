package gfg;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/1020/problem/B
 */
public class Badge {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i]=scanner.nextInt();
        }

        for(int i=1;i<=n;i++){
            boolean[] visited=new boolean[n+1];
            int start=i;
            while(!visited[start]){
                visited[start]=true;
                start=arr[start];
            }
            System.out.print((start)+" ");
        }
    }
}
