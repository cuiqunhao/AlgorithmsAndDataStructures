package Solution;

public class Solution5 {

	/**
	 * 约瑟夫环利用循环队列求解
	 * 
	 * @author Lyf
	 *
	 */
	public class Node {
		public int data;
		public Node next;

		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	public class LinkedList {
		Node headNode = null;

		public LinkedList(int n) {
			headNode = new Node(0, null);
			Node tempHeadNode = headNode;
			for (int i = 1; i < n; i++) {
				Node temp = new Node(i, null);
				headNode.next = temp;
				headNode = headNode.next;
			}
			headNode.next = tempHeadNode;
			headNode = headNode.next;
		}

		public void Print() {
			Node tempNode = headNode;
			System.out.println(tempNode.data);
			tempNode = tempNode.next;
			while (tempNode != headNode) {
				System.out.println(tempNode.data);
				tempNode = tempNode.next;
			}
		}

		public int size() {
			int length = 0;
			Node tempNode = headNode;
			tempNode = tempNode.next;
			length++;
			while (tempNode != headNode) {
				length++;
				tempNode = tempNode.next;
			}
			return length;
		}

	}

	LinkedList linkedList;

	public int LastRemaining_Solution(int n, int m) {
		linkedList = new LinkedList(n);
		Node prvNode = null;
		int count = 1;
		while (linkedList.size() > 1) {

			prvNode = linkedList.headNode;
			linkedList.headNode = linkedList.headNode.next;

			count++;
			if (count == m) {
				prvNode.next = linkedList.headNode.next;
				linkedList.headNode = prvNode.next;
				count = 1;
			}
		}
		return linkedList.headNode.data;
	}

	public static void main(String args[]) {
		System.out.println(new Solution5().LastRemaining_Solution(5, 3));
	} 	
}
