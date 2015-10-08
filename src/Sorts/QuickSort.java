package Sorts;

/**
 * �������򣺽���¼����Ĭ��ѡ��һ��ֵ��Ϊ�����֣���С�Ҵ����εݹ���ȥ
 * 
 * ʱ�临�Ӷ�������:��������ã�O(nlog2n)
 *  ʱ�临�Ӷ�����:��������O(n^2)
 *   ʱ�临�Ӷ�ƽ�����:�ӽ�������
 * 
 * �ռ临�Ӷ�����:O(n) �ռ临�Ӷ�ƽ�����:O(lon2n)
 * 
 * ���ȶ������㷨��3��2��2��
 * */
public class QuickSort {
	public static void main(String arg[]) {
		int a[] = { 3, 6, 4, 9, 1, 2, 5, 8, 7, 10 };
		QuickSort swapSort = new QuickSort();
		swapSort.getQuickSort(a);
		swapSort.print(a);
	}

	/**
	 * Ĭ��ѡȡ��һ����Ϊ��ֵ���Դ������һ�������
	 * 
	 * @param a
	 *            ����������
	 * @param low
	 *            ����±�
	 * @param high
	 *            �ұ��±�
	 * @return �ֽ��±�ֵ
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
	 * ��װ�±��ڶ���������ʹ��
	 * 
	 * @param a
	 */
	public void getQuickSort(int[] a) {
		getQuickSort(a, 0, a.length - 1);
	}

	/**
	 * �Եݹ鷽ʽ�����һ����ӿ������һ��εĻ��֣�����low=high
	 * 
	 * @param a
	 *            ����������
	 * @param low
	 *            ���
	 * @param high
	 *            �ұ�
	 */
	public void getQuickSort(int[] a, int low, int high) {
		if (low < high) {
			int pivotpos = Partition(a, low, high);
			getQuickSort(a, low, pivotpos - 1);
			getQuickSort(a, pivotpos + 1, high);
		}
	}

	/**
	 * �������
	 * 
	 * @param a
	 *            ���������
	 * */
	public void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
