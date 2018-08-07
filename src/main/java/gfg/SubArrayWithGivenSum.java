package gfg;

import java.util.HashMap;
import java.util.Scanner;

public class SubArrayWithGivenSum {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while (t-- > 0) {
			int n = s.nextInt();
			int k = s.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = s.nextInt();
			}
			int[] s1 = new int[n];
			HashMap<Integer, Integer> s3 = new HashMap<>();
			int sum1 = 0;
			int sum2 = 0;
			for (int i = 0; i < n; i++) {
				sum1 = sum1 + arr[i];
				sum2 = sum2 + arr[n - 1 - i];
				s1[i] = sum1;
				if (s3.get(sum2) == null) {
					s3.put(sum2, n - 1 - i);
				}
			}
			int[] bounds = getBounds(n, k, s1, s3, sum1);
			if (bounds[0] == -1) {
				System.out.println(-1);
			} else if (bounds[0] == bounds[1]) {
				System.out.println(bounds[0] + 1);
			} else {
				System.out.println((bounds[0] + 1) + " " + (bounds[1] + 1));
			}
		}
	}

	static int[] getBounds(int n, int k, int[] s1,
			HashMap<Integer, Integer> s3, int sum1) {
		for (int i = 0; i < n; i++) {
			if (s1[i] == k) {
				return new int[] { 0, i };
			}
		}
		for (int i = 0; i < n; i++) {
			if ((s3.get(sum1 - s1[i] - k) != null)) {
				int b1 = (i + 1);
				int b2 = (s3.get(sum1 - s1[i] - k) - 1);
				if (b1 <= b2) {
					return new int[] { b1, b2 };
				}
			}
		}
		if (s3.get(k) != null) {
			int b1 = s3.get(k);
			int b2 = (n - 1);
			return new int[] { b1, b2 };
		}
		return new int[] { -1, -1 };
	}
}
