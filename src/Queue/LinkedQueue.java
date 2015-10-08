package Queue;

public class LinkedQueue implements queue {

	public class Node {
		private Object data;
		private Node next;

		public Node(Object data) {
			this.data = data;
			this.next = null;
		}

		public Node(Object data, Node next) {
			this.data = data;
			this.next = next;
		}

		public Object getData() {
			return data;
		}

		public void setData(Object data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	}

	private Node headNode;
	private Node tilNode;
	private int length;

	public LinkedQueue() {
		this.headNode = null;
		this.tilNode = null;
		this.length = 0;
	}

	public void add(Object data) {
		Node tempNode = new Node(data);
		if (tilNode == null) {
			headNode = tempNode;
			tilNode = tempNode;
		} else {
			tilNode.setNext(tempNode);
			tilNode = tempNode;
		}
		length++;
	}

	@Override
	public Object poll() {
		if (headNode == null) {
			return null;
		} else {
			Object tempdata = headNode.getData();
			headNode = headNode.getNext();
			return tempdata;
		}
	}

	@Override
	public Object peek() {
		if (headNode == null)
			return null;
		else
			return headNode.getData();
	}

	@Override
	public boolean isEmpty() {
		boolean flag = false;
		if (headNode == null || tilNode == null)
			flag = true;
		return flag;
	}

	@Override
	public void clear() {
		headNode = null;
		tilNode = null;
	}

	@Override
	public void Travels() {
		Node currentNode = headNode;
		while (currentNode != null) {
			System.out.println(currentNode.getData());
			currentNode = currentNode.getNext();
		}
	}

	@Override
	public int getSize() {
		return this.length;
	}

	public static void main(String args[]) {
		queue testQueue = new LinkedQueue();
		testQueue.add(1);
		testQueue.add(2);
		testQueue.add(3);
		testQueue.add(4);
		testQueue.Travels();
		System.out.println(testQueue.getSize());

		System.out.println(testQueue.poll());
		System.out.println(testQueue.peek());
		System.out.println(testQueue.peek());
		
		System.out.println(testQueue.isEmpty());
		testQueue.clear();
		System.out.println(testQueue.isEmpty());
	}

}
