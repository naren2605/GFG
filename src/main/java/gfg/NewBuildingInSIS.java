package gfg;

import java.util.Scanner;

/*
http://codeforces.com/contest/1020/problem/A
 */
public class NewBuildingInSIS {


    private int n;
    private int h;
    private int a;
    private int b;

    public NewBuildingInSIS(int n,int h,int a, int b){
        this.n=n;
        this.h=h;
        this.a=a;
        this.b=b;
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int h=scan.nextInt();
        int a=scan.nextInt();
        int b=scan.nextInt();
        int t=scan.nextInt();
        NewBuildingInSIS town=new NewBuildingInSIS(n,h,a,b);
        while (t-->0){
            int t1=scan.nextInt();
            int f1=scan.nextInt();
            int t2=scan.nextInt();
            int f2=scan.nextInt();
            System.out.println(town.timeTaken(t1,f1,t2,f2));
        }
    }
//3 10 3 5 1
    private int timeTaken(int t1,int f1,int t2,int f2){

        if(t1==t2){
            return mod(f1,f2);
        }

        int totalTime=0;
        int linkingFloor=nearestLinkingFloor(f1);
        totalTime=totalTime+(mod(f1,linkingFloor));
        totalTime=totalTime+(mod(t1,t2));
        totalTime=totalTime+(mod(linkingFloor,f2));
        return totalTime;
    }

    private int nearestLinkingFloor(int f1){
        if(f1<=b && f1>=a){
          return f1;
        }
        else if(mod(f1,a)>=mod(f1,b)){
            return b;
        }else{
            return a;
        }
    }



    private int min(int n1,int n2){
        if(n1<n2){
            return n1;
        }else {
            return n2;
        }
    }

    private int mod(int n1,int n2){
        if(n1>n2){
            return n1-n2;
        }
        return n2-n1;
    }
}
