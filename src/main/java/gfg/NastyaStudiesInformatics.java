package gfg;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NastyaStudiesInformatics {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int l=scanner.nextInt();
        int r=scanner.nextInt();
        int x=scanner.nextInt();
        int y=scanner.nextInt();

        System.out.println(solution_cf(l,r,x,y));
        System.out.println(main2(l,r,x,y, 0 , 0));

   /*     int count=0;
        for(int a=l;a<=r;a++){
            for (int b=a;b<=r;b++){
                *//*int gcd=gcd(a,b);
                int lcm=a*b/gcd;*//*
                if(x*y==a*b && x*x<=a*b && y*y>=a*b ){
                    if(a==b){
                        count++;
                    }
                    else {
                        count=count+2;
                    }
                    System.out.println(a+":"+b+":"+x+":"+y);

                }

            }
        }
        System.out.println(count);*/
    }
    static int  gcd(int a, int b) {
        while (b!=0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    static long solution_cf(int l,int r,int x,int y){
        if (y % x != 0){
            return 0;
        }

        int ans = 0;
        int n = y / x;
        int count = 0;
        for (int d = 1; d * d <= n; ++d) {
            if (n % d == 0) {
                int c = n / d;
                if (l <= c * x && c * x <= r && l <= d * x && d * x <= r && gcd(c, d) == 1) {
                    if (d * d == n) ++ans;
                    else ans += 2;
                }
            }
            count++;
            }

        System.out.println("count = "+count);

        return ans;
    }

    static long main2(long L, long R, long X, long Y, int i, int j) {
        if (Y%X > 0)
            return 0;

        long t = Y / X, t2;
        int count = 0;
        List<Long> Vl = new ArrayList<Long>();
        for (i = 2; i * i <= t; i++) {
            if (t % i > 0) continue;

            long v = 1;
            while (t % i == 0) {
                v *= i;
                t /= i;
                count++;
            }
            Vl.add(v);
            count++;
        }
        if (t != 1) Vl.add(t);

        long ans = 0;
        for (i = 0; i < (1 << Vl.size()); i++) {
            long v1 = X, v2 = X;
            for (j = 0; j < Vl.size(); j++) {
                if ((i & (1 << j)) >0 ) v1 *= Vl.get(j);
                else v2 *= Vl.get(j);
                count++;
            }
            if (L <= v1 && v1 <= R && L <= v2 && v2 <= R) ans++;
        }
        System.out.println("another count = "+count);
        return ans;
    }



}
