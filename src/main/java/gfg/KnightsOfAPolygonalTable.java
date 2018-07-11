package gfg;

import java.util.*;

public class KnightsOfAPolygonalTable {

    public static class Knight implements Comparable<Knight>{
        int power;
        int coins;
        int index;
        int coinCount;
        public Knight(){

        }

        public int compareTo(Knight o) {
            if(this.power>o.power) return -1;
            else if(this.power<o.power) return 1;
            return 0;
        }

        @Override
        public String toString() {
            return index+":"+power+"="+coins;
        }
    }

    public static class CoinsComparator implements Comparator<Knight>{

        public int compare(Knight o1, Knight o2) {
            if(o1.coins>o2.coins){
                return -1;
            }
            else if(o1.coins<o2.coins){
                return 1;
            }
            return 0;
        }
    }

    public static class IndexComparator implements Comparator<Knight>{

        public int compare(Knight o1, Knight o2) {
            if(o1.index>o2.index){
                return 1;
            }
            else if(o1.index<o2.index){
                return -1;
            }
            return 0;
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int k=scanner.nextInt();
        List<Knight> knights=new ArrayList<Knight>(n);
        List<Knight> indexed=new ArrayList<Knight>(n);
        int[] coins=new int[n];
        for(int i=0;i<n;i++){
            knights.add(i,new Knight());
            knights.get(i).power=scanner.nextInt();
            knights.get(i).index=i;
        }
        for(int i=0;i<n;i++){
            knights.get(i).coins=scanner.nextInt();
            indexed.add(i,knights.get(i));
        }
        new KnightsOfAPolygonalTable().max(knights,k);
        for(int i=0;i<n;i++){
            System.out.print((indexed.get(i).coinCount+(indexed.get(i).coins))+" ");
        }
        System.out.println();
       // System.out.println(knights);
/*        HashSet<Integer> set=new HashSet<>();
        List<Knight> knights2=new ArrayList<Knight>(5);
        Random r=new Random();
        for (int i=0;i<5;i++){
            int ran=r.nextInt(10);
            int coin=r.nextInt(20);
            while (set.contains(ran)){
                ran=r.nextInt(10);
                coin=r.nextInt(20);
            }
            set.add(ran);
            Knight kn=new Knight();
            kn.index=i;
            kn.power=ran;
            kn.coins=coin;
            knights2.add(kn);

        }
        System.out.println(knights2);
        new KnightsOfAPolygonalTable().max(knights2,3);*/



    }

    public void max(List<Knight> knights,int k){
        Collections.sort(knights);
       Queue<Knight> coinq = new LinkedList<>();
        for(int i=0;i<knights.size();i++) {
            coinq.add(knights.get(i));
        }
        Stack<Knight> stack=new Stack<>();
        for(int i=0;i<knights.size();i++){
            int t=k;
            while (!stack.empty()){
                coinq.add(stack.pop());
            }
            while (!coinq.isEmpty()&&t>0){
                if(coinq.peek().power<knights.get(i).power){
                    t--;
                    Knight tmp=coinq.remove();
                    knights.get(i).coinCount=knights.get(i).coinCount+tmp.coins;
                    stack.push(tmp);
                }
                else{
                    coinq.remove();
                }
            }

        }


/*        for(int i=0;i<knights.size()-1;i++){
            PriorityQueue<Knight> coinq=new PriorityQueue<Knight>(new CoinsComparator());
                for(int j=i+1;j<knights.size();j++){
                    if(coinq.size()==k){
                        if(coinq.peek().coins<knights.get(j).coins){
                            coinq.remove();
                            coinq.add(knights.get(j));
                        }
                    }
                    else {
                        coinq.add(knights.get(j));
                    }
                }
            knights.get(i).coinCount=knights.get(i).coins;
             while (!coinq.isEmpty()){
                knights.get(i).coinCount=knights.get(i).coinCount+coinq.remove().coins;
             }
        }
        knights.get(knights.size()-1).coinCount=knights.get(knights.size()-1).coins;*/
        //Collections.sort(knights,new IndexComparator());



    }
}
