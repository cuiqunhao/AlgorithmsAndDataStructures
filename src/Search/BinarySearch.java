package Search;

/**���ֲ��ң��Ƚ��ؼ����������м�ֵ�Ƚϣ�������򷵻أ������������Ұ벿�֣���С���������벿�֣�������û��ƥ�䵽�󷵻�-1
 *
 */
public class BinarySearch {

	public static void main(String args[]){
		BinarySearch binarySearch=new BinarySearch();
		int[] a={1,2,3,4,5,6,7,8,9};
		System.out.println(binarySearch.getBinarySearch(a, 6));
	}
	
	/**
	 * ��������������У����ֲ��ҹؼ��֣����ҵ�����λ�ã���û���򷵻�-1
	 * 
	 * @param a
	 *            ����������
	 * @param x
	 *            ��ƥ��ؼ���
	 * @return ����йؼ����±꣬���򷵻�-1
	 */
	public int getBinarySearch(int[] a, int x) {
		int low = 0, high = a.length - 1, mid;
		while (low <= high) {
			mid = (low + high) / 2;
			if (a[mid] == x) {
				return mid;
			} else if (a[mid] > x) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}
}
