package gfg;

	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.Collections;
	import java.util.List;
	import java.util.Scanner;
	
	public class Terminators {
	
		public static void main(String[] args) {
	
			Scanner scan = new Scanner(System.in);
			int tests = scan.nextInt();
			while (tests-- > 0) {
				int n = scan.nextInt();
				List<Position> dayOne = new ArrayList<Terminators.Position>(n);
				List<Position> dayTwo = new ArrayList<Terminators.Position>(n);
				for (int i = 0; i < n; i++) {
					dayOne.add(new Position(i, scan.nextInt()));
					dayTwo.add(new Position(i, scan.nextInt()));
				}
				System.out.println(largestGroup(dayOne, dayTwo, n));
			}
	
		}
		
		
		public static class Position implements Comparable<Position>{
			int index;
			int positionIndex;
			public Position(int index,int positionIndex) {
				this.index=index;this.positionIndex=positionIndex;
			}
			
			public int compareTo(Position position) {
				if(this.positionIndex>position.positionIndex){
					return 1;
				}
				else if(this.positionIndex<position.positionIndex){
					return -1;
				}
				return 0;
			}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "["+positionIndex+":"+index+"]";
			}
		}
	
		public static int largestGroup(List<Position> dayOne, List<Position> dayTwo, int n) {
	
			int[] flag = new int[n];
			Arrays.fill(flag, 1);
			Collections.sort(dayOne);
			//System.out.println(dayOne);
			//System.out.println(dayTwo);
	
			int max = 1;
			for (int i = 0; i < n - 1; i++) {
	
				for (int j = i + 1; j < n; j++) {
					if (dayTwo.get(dayOne.get(i).index).positionIndex < dayTwo.get(dayOne.get(j).index).positionIndex) {
						flag[j] = Math.max(flag[j],flag[i] + 1);
					}
					//System.out.println(Arrays.toString(flag));
				}
				max = Math.max(max, flag[i]);
			}
	
			max = Math.max(max, flag[flag.length - 1]);
	
			return max;
		}
	
	}
