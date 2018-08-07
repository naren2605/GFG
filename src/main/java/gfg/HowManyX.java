package gfg;

import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/how-many-xs/0
 */
public class HowManyX {

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while (t-->0){
            System.out.println(getCount(scanner.nextInt(),scanner.nextInt(),scanner.nextInt()));
        }
    }

    static int getCount(int x,int num1,int num2){

        if(num1<num2){
            return getCount(num2,x)-getCount(num1+1,x);
        }
        else if(num1>num2){
            return getCount(num1,x)-getCount(num2+1,x);
        }
        return 0;

    }

    static int getCount(int number,int x){
        int num=number;
        int count=0;
        int i=1;
        while (num>9){
            i=i*10;
            num=num/10;
        }
        int previous=0;
        if(x==0){
            i=i/10;
            while(i!=0){

                int left=(number/i);
                if(left%10>0){
                    count=count+(left/10)*i;
                }
                else{
                    count=count+(((left/10)-1)*i)+(number%i);
                }
                i=i/10;
            }
            return count;
        }
        while(i!=0){
            int left=(number/i);
            if(left%10<x){
                count=count+(previous*i);
            }
            else if(left%10>x){
                count=count+(previous+1)*i;
            }
            else{
                count=count+((previous*i)+(number%i));
            }
            previous=number/i;
            i=i/10;
        }
        return count;
    }
}
