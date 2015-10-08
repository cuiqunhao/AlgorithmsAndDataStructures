package Stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Á´Ê½Õ»
 * @author Administrator
 *
 */
public class LinkedStack implements satck {

	class Node {
		private Object data;
		private Node nextNode;
		
		public Node(Object data,Node nextNode){
			this.data=data;
			this.nextNode=nextNode;
		}

		public Object getData() {
			return data;
		}

		public void setData(Object data) {
			this.data = data;
		}

		public Node getNextNode() {
			return nextNode;
		}

		public void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}

	}

	
	private Node head=null;
	
	@Override
	public void push(Object data) {
		if(head==null){
			head=new Node(data, null);
			return ;
		}
		Node temp=new Node(data, head);
		head=temp;
		
	}

	
	public void isValid(){
		if(head==null){
			throw new NullPointerException("Õ»Îª¿Õ!");
		}
	}
	
	@Override
	public Object pop() {
		isValid();
		Node tempNode=head;
		head=head.getNextNode();
		return tempNode.getData();
	}

	@Override
	public Object peek() {
		isValid();
		return head.getData();
	}


	@Override
	public boolean clear() {
		head=null;
		return true;
	}

	@Override
	public void Travels() {
		Node tempNode=head;
		while(tempNode!=null){
			System.out.println(tempNode.getData());
			tempNode=tempNode.getNextNode();
		}
		
	}

	
	@Override
	public boolean isEmpty() {
		boolean flag=false;
		if(head==null)flag=true;
		return flag;
	}

	
	public static void main(String args[]) {
		LinkedStack testStack=new LinkedStack();
		testStack.push(1);
		testStack.push(2);
		System.out.println(testStack.isEmpty());
		testStack.push(3);
		testStack.push(4);
		testStack.push(5);
		testStack.Travels();
		
		System.out.println(testStack.pop());
		System.out.println(testStack.pop());
		
		
		System.out.println(testStack.peek());
		System.out.println(testStack.peek());
		
		System.out.println(testStack.clear());
		System.out.println(testStack.isEmpty());
		
	}



	

}
