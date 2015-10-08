package Sorts;

/**
 * 快速排序：将记录分以默认选定一轴值分为两部分，左小右大，依次递归下去
 * 
 * 时间复杂度最好情况:数组排序好，O(nlog2n)
 *  时间复杂度最坏情况:数组逆序，O(n^2)
 *   时间复杂度平局情况:接近最好情况
 * 
 * 空间复杂度最坏情况:O(n) 空间复杂度平局情况:O(lon2n)
 * 
 * 不稳定排序算法｛3，2，2｝
 * */
public class QuickSort {
	public static void main(String arg[]) {
		int a[] = { 3, 6, 4, 9, 1, 2, 5, 8, 7, 10 };
		QuickSort swapSort = new QuickSort();
		swapSort.getQuickSort(a);
		swapSort.print(a);
	}

	/**
	 * 默认选取第一个数为轴值，以次数左右划分排序
	 * 
	 * @param a
	 *            待排序数组
	 * @param low
	 *            左边下标
	 * @param high
	 *            右边下标
	 * @return 分届下标值
	 */
	public int Partition(int[] a, int low, int high) {
		int piovt = a[low];
		while (low < high) {
			while (low < high && a[high] >= piovt)
				--high;
			a[low] = a[high];
			while (low < high && a[low] <= piovt)
				++low;
			a[high] = a[low];
		}
		a[low] = piovt;
		return low;
	}

	/**
	 * 封装下便于对数组整体使用
	 * 
	 * @param a
	 */
	public void getQuickSort(int[] a) {
		getQuickSort(a, 0, a.length - 1);
	}

	/**
	 * 以递归方式对左右划分子块进行下一层次的划分，至到low=high
	 * 
	 * @param a
	 *            待排序数组
	 * @param low
	 *            左边
	 * @param high
	 *            右边
	 */
	public void getQuickSort(int[] a, int low, int high) {
		if (low < high) {
			int pivotpos = Partition(a, low, high);
			getQuickSort(a, low, pivotpos - 1);
			getQuickSort(a, pivotpos + 1, high);
		}
	}

	/**
	 * 输出数组
	 * 
	 * @param a
	 *            待输出数组
	 * */
	public void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
