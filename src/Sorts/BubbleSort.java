package Sorts;
/**
 * ð�����򣺱Ƚ����ڵ�Ԫ�ء������һ���ȵڶ����󣬾ͽ�����������
 * 
 * ʱ�临�Ӷ�������:��������ã�O(n)
 * ʱ�临�Ӷ�����:��������O(n^2) 
 * ʱ�临�Ӷ�ƽ�����:O(n^2)
 * 
 * �ռ临�Ӷ�:O(1)
 * 
 * �ȶ������㷨
 */
public class BubbleSort {
	
	public static void main(String args[]) {
		int a[] = { 3, 6, 4, 9, 1, 2, 5, 8, 7, 10 };
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.getBubbleSort(a);
		bubbleSort.print(a);
	}

	/**
	 * ��������ð������
	 * 
	 * @param a
	 *            ���������
	 */
	public void getBubbleSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = a.length - 1; j > i; j--) {
				if (a[j - 1] > a[j]) {
					int temp = a[j - 1];
					a[j - 1] = a[j];
					a[j] = temp;
				}
			}
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
