package gfg;


import java.util.HashSet;
import java.util.Scanner;

public class NatashaAndAnArray {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        HashSet<Integer> set=new HashSet<>();
        while (n-->0){
            int i=scanner.nextInt();
            if(i!=0){
                set.add(i);
            }

        }
        System.out.println(set.size());

    }
}
