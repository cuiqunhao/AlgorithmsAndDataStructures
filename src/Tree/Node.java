package Tree;


/**
 * 内部结点类 左指针|数据域|右置针
 * */
public class Node {

	private Node leftNode = null;
	private String data = null;
	private Node rightNode = null;

	public Node(String data, Node leftNode, Node rightNode) {
		this.leftNode = leftNode;
		this.rightNode = rightNode;
		this.data = data;
	}
	public Node(String data) {
		this.leftNode = null;
		this.rightNode =null;
		this.data = data;
	}
	
	
	public void setLeftChild(Node leftNode){
		this.leftNode=leftNode;
	}
	
	public void setRightChild(Node rightNode){
		this.rightNode=rightNode;
	}
	
	public Node getLeftChild() {
		return this.leftNode;
	}

	public Node getRightChild() {
		return this.rightNode;
	}

	public String getData() {
		return this.data;
	}
}
