package Search;

/**二分查找：先将关键字与数组中间值比较，如相等则返回，如大于则查找右半部分，如小于则查找左半部分，查找完没有匹配到后返回-1
 *
 */
public class BinarySearch {

	public static void main(String args[]){
		BinarySearch binarySearch=new BinarySearch();
		int[] a={1,2,3,4,5,6,7,8,9};
		System.out.println(binarySearch.getBinarySearch(a, 6));
	}
	
	/**
	 * 对以排序数组进行，二分查找关键字，如找到返回位置，如没有则返回-1
	 * 
	 * @param a
	 *            待查找数组
	 * @param x
	 *            待匹配关键字
	 * @return 如果有关键字下标，否则返回-1
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
