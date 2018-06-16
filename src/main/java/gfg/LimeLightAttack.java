package gfg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class LimeLightAttack {
	public static final int mod = 1000000009;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int tests = scan.nextInt();
		HashSet<Integer> set = new HashSet<Integer>();
		ArrayList<Integer> array = new ArrayList<Integer>();
		HashMap<Integer, Long> table = new HashMap<Integer, Long>();
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < tests; i++) {
			int num = scan.nextInt();
			set.add(num);
			array.add(num);
			max = Math.max(num, max);
		}

		long left = 0;
		long right = 0;
		long total = 0;
		long oddleft = 0;
		long oddtotal = 0;
		for (int i = 1; i <= max + 1; i++) {
			left = leftDiagonal(left, i - 1);
			right = rightDiagonal(right, i);
			oddleft = oddLeftDiagonal(oddleft, i);
			if (set.contains(i - 1)) {
				if ((i - 1) % 2 != 0) {
					table.put(i - 1, oddtotal - 1);
				} else {
					table.put(i - 1, (total + left % mod) % mod);
				}

			}

			total = (total + (left + right) % mod) % mod;
			oddtotal = (oddtotal + (oddleft + right) % mod) % mod;

		}

		for (int key : array) {
			System.out.println(table.get(key));
		}

	}

	public static long leftDiagonal(long lastLeftDiagonalSum, int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 2;
		}

		if (n % 2 != 0) {
			return lastLeftDiagonalSum % mod + (2 * n) % mod;
		} else {
			return lastLeftDiagonalSum % mod + (2 * (n - 1)) % mod;
		}

	}

	public static long rightDiagonal(long lastRightDiagonalSum, int n) {
		if (n == 1) {
			return 1;
		}
		return (lastRightDiagonalSum % mod + ((2 * (n - 1)) % mod)) % mod;
	}

	public static long oddLeftDiagonal(long lastOddLeftDiagonal, int n) {
		if (n == 1) {
			return 1;
		} else if (n == 2) {
			return 5;
		} else {
			if (n % 2 != 0) {
				return (lastOddLeftDiagonal % mod + ((2 * (n - 1)) % mod))
						% mod;
			} else {
				return (lastOddLeftDiagonal % mod + ((2 * (n)) % mod)) % mod;
			}
		}
	}
}
