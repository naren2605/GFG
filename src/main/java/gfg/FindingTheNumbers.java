package gfg;

import java.util.*;

public class FindingTheNumbers {

    /**
     *  https://practice.geeksforgeeks.org/problems/finding-the-numbers/0
     */

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while (t-->0){
            int n=scanner.nextInt();
            HashMap<Integer,Integer> map=new HashMap<>();
            ArrayList<Integer> list=new ArrayList<>();
            n=2*n+2;
            timeComplexityNAndSpaceComplexityN(list,map,n,scanner);

        }
    }

    private static void timeComplexityNAndSpaceComplexityN(ArrayList<Integer> list,HashMap<Integer,Integer> map, int n,Scanner scanner) {
        n--;
        int num = scanner.nextInt();
        list.add(num);
        int xorProduct=num;
        while (n-->0) {
            num = scanner.nextInt();
            xorProduct=xorProduct^num;
            list.add(num);
        }
        int andProduct=xorProduct&(-xorProduct);
        int uniqueNumber=0;
        for (int i=0;i<list.size();i++){
            if((list.get(i)&andProduct)==andProduct){
                uniqueNumber=uniqueNumber^list.get(i);
            }

        }
        int number1=uniqueNumber;
        int number2=xorProduct^number1;
        if(number1<number2){
            System.out.println(number1+" "+number2);
        }else{
            System.out.println(number2+" "+number2);
        }

    }


        private static void timeComplexityNLogNandSpaceComplexityN(ArrayList<Integer> list,HashMap<Integer,Integer> map, int n,Scanner scanner){
        while (n-->0){
            int num=scanner.nextInt();
            list.add(num);
            if(map.get(num)==null){
                map.put(num,1);
            }
            else{
                map.put(num,map.get(num)+1);
            }
        }

        Collections.sort(list);
        for (int i=0;i<list.size();i++){
            if(map.get(list.get(i))%2!=0){
                System.out.print(list.get(i)+" ");
            }
        }
        System.out.println();
    }
}
