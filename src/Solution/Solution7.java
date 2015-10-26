package Solution;

public class Solution7 {
	
	
	public class ListNode {
		int val;
		ListNode next = null;
		ListNode(int val) {
			this.val = val;
		}
	}

	public ListNode ReverseList(ListNode head) {
		if(head==null)
			return null;
		ListNode prvNode=null;
		ListNode currentNode=head;
		ListNode reverseNode=null;
		
		while(currentNode!=null){
			ListNode tempNextNode=currentNode.next;
	
			if(currentNode.next==null)
				reverseNode=currentNode;
				
			currentNode.next=prvNode;
			
			prvNode=currentNode;
			currentNode=tempNextNode;
		}
		return reverseNode;
	}
}
