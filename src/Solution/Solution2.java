package Solution;

import java.util.ArrayList;

public class Solution2 {

	/**
	 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的
	 * 
	 * @param array
	 * @param sum
	 * @return
	 */
	public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
		ArrayList<Integer> dataArrayList = new ArrayList<Integer>();
		if (array == null || array.length == 0)
			return dataArrayList;
		int xy = array[array.length - 1] * array[array.length - 1];
		int x = 0, y = 0;
		boolean flag = false;

		int low = 0, high = array.length - 1;
		while (low <= high) {
			if (array[low] + array[high] > sum)
				high--;
			else if (array[low] + array[high] < sum)
				low++;
			else {
				flag = true;
				int tempx = array[low];
				int tempy = array[high];
				int tempxy = tempx * tempy;
				if (tempxy < xy) {
					xy = tempxy;
					x = tempx;
					y = tempy;
				}
				high--;
				low++;

			}
		}
		if (flag) {
			dataArrayList.add(x);
			dataArrayList.add(y);
		}
		return dataArrayList;
	}

	public static void main(String args[]) {
		int[] arry = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
				17, 18, 19, 20 };
		ArrayList<Integer> testArrayList = new Solution2().FindNumbersWithSum(
				arry, 21);
		for (Integer integer : testArrayList) {
			System.out.println(integer);
		}
	}
}
