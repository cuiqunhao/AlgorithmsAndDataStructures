package Solution;

public class Solution {

	/**
	 * 统计一个数字在排序数组中出现的次数,采用二分查找发降低算啊复杂度。
	 * 
	 * @param array
	 * @param k
	 * @return 
	 */
	public int GetNumberOfK(int[] array, int k) {
		if(array==null ||array.length==0)return 0;
		return LastK(array, k)-FristK(array, k)+1;
	}

	public int FristK(int[] array, int k) {
		if(array.length==0 || array==null)return 0;
		int low=0, high=array.length-1;
		int mid =0;
		while (low <= high) {
			 mid=(high + low) / 2;
			if (array[mid] > k) {
				high=mid-1;
			} else if (array[mid] < k) {
				low=mid+1;
			} else {
				if( mid!=0 && array[mid-1]==k) 
					high=mid-1;
				else
					return mid;
			}
		}
		return 0;
	}
	
	public int LastK(int[] array, int k) {
		if(array.length==0 || array==null)return -1;
		int low=0, high=array.length-1;
		int mid =0;
		while (low <= high) {
			 mid=(high + low) / 2;
			if (array[mid] > k) {
				high=mid-1;
			} else if (array[mid] < k) {
				low=mid+1;
			} else {
				if(mid!=array.length-1 && array[mid+1]==k) 
					low=mid+1;
				else
					return mid;
			}
		}
		return -1;
	}

	public static void main(String arsg[]){
		int[] data={3,3,3,3,4,5};
		Solution testSolution=new Solution();
		System.out.println(testSolution.GetNumberOfK(data, 3));
	}
	
}
