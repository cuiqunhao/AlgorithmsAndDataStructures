package Linear;

public class LinkedList implements List {
	public class Node {
		private Object data;
		private Node next;

		public Node(Object data, Node next) {
			this.data = data;
			this.next = next;
		}

		public void setNex(Node next) {
			this.next = next;
		}

		public Object getData() {
			return this.data;
		}

		public void setData(Object data){
			this.data=data;
		}
		
		public Node getNext() {
			return this.next;
		}
	}

	private int length = 0;
	Node head = null;



	private void isValidIndx(int index) {
		if (index < 0 || index > length) {
			throw new RuntimeException("�����±��쳣");
		}
	}
	
	
	@Override
	public boolean isEmpty() {
		boolean flag = false;
		if (head == null)
			flag = true;
		return flag;
	}

	
/***
 * ������ֵ�Ƿ����ɾ�����
 * @param data int
 * @return �ɹ�ɾ������true�����򷵻�false
 */
	public boolean delete(Object data) {
		boolean flag = false;
		if (head == null)
			return flag;
		if (head.getData() == data) {
			head = head.getNext();
			length--;
			flag = true;
		}
		Node tempNode = head.getNext();
		Node tempPveNode = head;
		while (tempNode != null) {
			if (tempNode.getData() == data) {
				if (tempNode.getNext() == null) {
					tempPveNode.setNex(null);
					length--;
					flag = true;
				} else {
					tempPveNode.setNex(tempNode.getNext());
					length--;
					flag = true;
				}
			}
			tempNode = tempNode.getNext();
			tempPveNode = tempPveNode.getNext();
		}
		return flag;
	}

	@Override
	public boolean clear() {
		if (head != null)
			head = null;
		return false;
	}
	
	

	@Override
	public Object get(int index) {
		if(head==null){
			return new NullPointerException("��ǰ����Ϊ��");
		}
		if(index<0){
			return  new IndexOutOfBoundsException("��ǰ����ֵ�Ƿ���Ϊ��");
		}
		Node temp=head;
		int count=0;
		while(temp!=null){
			if(count==index){
				return temp.getData();
			}
			temp=temp.getNext();
			count++;
		}
			return new IndexOutOfBoundsException("��ǰ����Խ��,����������");	
	}
	

	@Override
	public boolean add(Object x) {
		if (head == null) {
			head = new Node(x, null);
			length++;
		} else {
			Node tempNode = head;
			Node newNode = new Node(x, null);
			while (tempNode.getNext() != null) {
				tempNode = tempNode.getNext();
			}
			tempNode.setNex(newNode);
			length++;
		}
		return false;
	}

	@Override
	public int getLength() {
		return this.length;
	}

	@Override
	public boolean set(int index, Object data) {
		boolean flag=false;
		int count =0;
		isValidIndx(index);
		if(head==null)return flag;
		Node temNode=head;
		
		while(temNode!=null){
			if(count==index){
				temNode.setData(data);
				flag=true;
				return flag;
			}
			count++;
			temNode=temNode.getNext();
		}
		
		return flag;
	}

	@Override
	public boolean remove(int index) {
		isValidIndx(index);
		if(head==null)return false;
		
		if(index==0){
			head=head.getNext();
			return true;
		}
		
		Node currentNode =head.getNext();
		Node prvNode=head;
		int count =1;
		while(currentNode!=null){
			if(index==count){
				prvNode.setNex(currentNode.getNext());
				return true;
			}
			count++;
			currentNode=currentNode.getNext();
			prvNode=prvNode.getNext();
		}
		return false;
	}
	
	@Override
	public boolean insert(int index, Object data) {
		boolean flag=false;
		
		isValidIndx(index);
		if(head==null)return false;//����Ϊ��
		
		if(index==0){//ͷ���
			Node newNod=new Node(data, head);
			head=newNod;
			length++;
			return true;
		}
		Node temp=head.getNext();
		Node Prvtemp=head;
		int count =1;
		
		while(temp!=null){//�м���
			if(count ==index){
				Node newNode=new Node(data, temp);
				Prvtemp.setNex(newNode);
				flag=true;
			}
			temp=temp.getNext();
			Prvtemp=Prvtemp.getNext();
			count++;
		}
		if(index==length){//β���
			Node newNod=new Node(data, null);
			Prvtemp.setNex(newNod);
			flag=true;
		}
		return flag;

	}

	@Override
	public void Traversal() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.getData());
			temp = temp.getNext();
		}		
	}


	
	public static void main(String args[]) {
		LinkedList Lyf = new LinkedList();
		Lyf.add(1);
		Lyf.add(2);
		Lyf.add(3);
		Lyf.add(4);
		System.out.println(Lyf.delete(4));
		Lyf.Traversal();
		System.out.println();
		
		System.out.println(Lyf.get(2));
		System.out.println(Lyf.getLength());
		Lyf.insert(2, 0);
		Lyf.set(0, 8);
		Lyf.remove(3);
		Lyf.Traversal();
	}

	

}
