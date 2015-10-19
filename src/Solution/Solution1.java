package Solution;

import java.util.ArrayList;

public class Solution1 {

	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		if (sum < 3)
			return null;

		ArrayList<ArrayList<Integer>> data = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> newarrayList = new ArrayList<Integer>();
		int small = 1;
		int big = 2;
		int tempsum = 0;
		while (small < big) {
			tempsum = ((small + big) * (big - small + 1)) / 2;
			if (tempsum < sum)
				big++;
			else if (tempsum > sum)
				small++;
			else {
				newarrayList.clear();
				for (int i = small; i <= big; i++) {
					newarrayList.add(i);
				}
				data.add(newarrayList);
				big++;
			}
		}

		return data;
	}

	public void print(ArrayList<ArrayList<Integer>> x) {
		if (x == null || x.size() == 0)
			return;
		for (int i = 0; i < x.size(); i++) {
			for (int j = 0; j < x.get(i).size(); j++) {
				System.out.print(x.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

	public static void main(String args[]) {
		Solution1 testSolution1 = new Solution1();
		testSolution1.print(testSolution1.FindContinuousSequence(9));
	}
}
