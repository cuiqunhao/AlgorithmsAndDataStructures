package Solution;

import java.util.ArrayList;
import java.util.Stack;

public class Solution8 {

	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> returnArrayList=new ArrayList<Integer>();
		Stack<Integer> stack=new Stack<Integer>();
		ListNode tempListNode=listNode;
		
		while(tempListNode!=null){
			stack.add(tempListNode.val);
			tempListNode=tempListNode.next;
		}
		while(!stack.isEmpty()){
			returnArrayList.add(stack.pop());
		}
		return returnArrayList;
	}
}
