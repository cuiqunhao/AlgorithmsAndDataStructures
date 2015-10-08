package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

	private Node rootNode = null;

	/**
	 * ���캯��,������������ڵ�
	 * */
	public BinaryTree(Node rootNode) {
		this.rootNode = rootNode;
	}

	/**
	 * ǰ�����������
	 * */
	public void DLR(Node rootNode) {
		if (rootNode != null) {
			System.out.print(rootNode.getData());
			DLR(rootNode.getLeftChild());
			DLR(rootNode.getRightChild());
		}
	}

	/**
	 * �ǵݹ�ǰ�����������
	 * */
	public void nonDLR(Node currentNode) {
		if (currentNode == null) {
			return;
		}
		Stack<Node> statNodes = new Stack<Node>();
		while (currentNode != null || !statNodes.isEmpty()) {
			while (currentNode != null) {
				System.out.print(currentNode.getData());
				statNodes.push(currentNode);
				currentNode = currentNode.getLeftChild();
			}
			currentNode = statNodes.pop();
			currentNode = currentNode.getRightChild();
		}

	}

	/**
	 * �������������
	 * */
	public void LDR(Node rootNode) {
		if (rootNode != null) {
			LDR(rootNode.getLeftChild());
			System.out.print(rootNode.getData());
			LDR(rootNode.getRightChild());
		}
	}

	/**
	 * �ǵݹ��������������
	 * */
	public void nonLDR(Node currentNode) {
		if (currentNode == null) {
			return;
		}
		Stack<Node> stackNodes = new Stack<Node>();
		while (currentNode != null || !stackNodes.isEmpty()) {
			while (currentNode != null) {
				stackNodes.push(currentNode);
				currentNode = currentNode.getLeftChild();
			}
			currentNode = stackNodes.pop();
			System.out.print(currentNode.getData());
			currentNode = currentNode.getRightChild();
		}
	}

	/**
	 * �������������
	 * */
	public void LRD(Node rootNode) {
		if (rootNode != null) {
			LRD(rootNode.getLeftChild());
			LRD(rootNode.getRightChild());
			System.out.print(rootNode.getData());
		}
	}

	/**
	 * �ǵݹ�������������
	 * */
	public void nonLRD(Node rootNode) {
		Node currentNode = rootNode;
		Stack<Node> stackNodes = new Stack<Node>();
		while (rootNode != null) {
			for (; rootNode.getLeftChild() != null; rootNode = rootNode
					.getLeftChild()) {
				stackNodes.push(rootNode);
			}
			while (rootNode != null
					&& (rootNode.getRightChild() == null || rootNode
							.getRightChild() == currentNode)) {
				System.out.print(rootNode.getData());
				currentNode = rootNode;
				if (stackNodes.isEmpty()) {
					return;
				}
				rootNode = stackNodes.pop();
			}
			stackNodes.push(rootNode);
			rootNode = rootNode.getRightChild();
		}
	}

	/**
	 * ��α���������
	 * */
	public void Level(Node rootNode) {
		if (rootNode == null) {
			return;
		}
		Queue<Node> queueNodes = new LinkedList<Node>();
		queueNodes.add(rootNode);
		while (!queueNodes.isEmpty()) {
			Node currentNode = queueNodes.remove();
			System.out.print(currentNode.getData());
			if (currentNode.getLeftChild() != null) {
				queueNodes.add(currentNode.getLeftChild());
			}
			if (currentNode.getRightChild() != null) {
				queueNodes.add(currentNode.getRightChild());
			}
		}
	}

	/**
	 * ���ص�ǰ�����
	 * 
	 * @return Node
	 * */
	public Node getRootNode() {
		return this.rootNode;
	}

	/**
	 * �ݹ�������߶�
	 * 
	 * @param currentNode
	 *            ��ǰ���ڵ�
	 * @return int �߶�
	 * */
	public int getHight(Node currentNode) {
		int LHight = 0, RHight = 0;
		if (currentNode == null)
			return 0;
		LHight = getHight(currentNode.getLeftChild());
		RHight = getHight(currentNode.getRightChild());
		return (LHight >= RHight) ? ++LHight : ++RHight;
	}

	/**
	 * �ж�һ���������Ƿ�Ϊƽ������������������������߶Ȳ������1��
	 * 
	 * @param currentNode
	 *            ��ǰ���
	 * @return true ��ƽ������� false ����ƽ�������
	 * */
	public boolean isAVL(Node currentNode) {
		int L, R;
		if (currentNode == null) {
			return true;
		}
		L = getHight(currentNode.getLeftChild());
		R = getHight(currentNode.getRightChild());
		if (L - R > 1 || R - L > 1) {
			return false;
		} else {
			return isAVL(currentNode.getLeftChild())
					&& isAVL(currentNode.getRightChild());
		}
	}

	/**
	 * �ݹ�->����������(���������������ҽ��)
	 * 
	 * @param currentNode
	 *            ��ǰ���
	 * */
	public void getMirror(Node currentnode) {
		if (currentnode == null) {
			return;
		}
		Node tempNode;
		tempNode = currentnode.getLeftChild();
		currentnode.setLeftChild(currentnode.getRightChild());
		currentnode.setRightChild(tempNode);
		getMirror(currentnode.getLeftChild());
		getMirror(currentnode.getRightChild());
	}

	/**
	 * �ǵݹ�->����������
	 * 
	 * @param currentNode
	 *            ��ǰ���
	 * */
	public void nonGetMirror(Node currentnode) {
		if (currentnode == null) {
			return;
		}
		Stack<Node> stackNodes = new Stack<Node>();
		stackNodes.push(currentnode);
		while (!stackNodes.isEmpty()) {
			currentnode = stackNodes.pop();
			Node tempNode;
			tempNode = currentnode.getLeftChild();
			currentnode.setLeftChild(currentnode.getRightChild());
			currentnode.setRightChild(tempNode);

			if (currentnode.getLeftChild() != null) {
				stackNodes.push(currentnode.getLeftChild());
			}
			if (currentnode.getRightChild() != null) {
				stackNodes.push(currentnode.getRightChild());
			}
		}
	}

	/**
	 * �����·��
	 * 
	 * @param currentNode
	 *            ��ǰ���ڵ�
	 */
	public void getLongest(Node currentNode) {
		if (currentNode == null) {
			return;
		}
		System.out.print(currentNode.getData());
		if (getHight(currentNode.getLeftChild()) >= getHight(currentNode
				.getRightChild())) {
			getLongest(currentNode.getLeftChild());
		} else {
			getLongest(currentNode.getRightChild());
		}
	}

	public void delete(String data) {
		Stack<Node> statckNodes = new Stack<Node>();
		
		boolean flag=false;//��
		Node fatherNode=null;
		
		Node curretNode = getRootNode();
		while (curretNode != null || !statckNodes.isEmpty()) {
			while (curretNode != null) {
				statckNodes.push(curretNode);
				if (curretNode.getData().equals(data)) {
					if(fatherNode==null){
						this.rootNode=null;
					}else {
						
					}
				}
				if(curretNode!=null)
				curretNode = curretNode.getLeftChild();

			}
			curretNode = statckNodes.pop();
			curretNode = curretNode.getRightChild();
		}
	}

	public static void main(String args[]) {

		Node dNode = new Node("D");
		Node cNode = new Node("C", dNode, null);

		Node aNode = new Node("A", cNode, null);
		Node bNode = new Node("B");

		Node rootNode = new Node("R", aNode, bNode);

		BinaryTree binaryTree = new BinaryTree(rootNode);
		System.out.print("DLR:");
		binaryTree.DLR(binaryTree.getRootNode());
		System.out.println();

		System.out.print("nonDLR:");
		binaryTree.nonDLR(binaryTree.getRootNode());
		System.out.println();

		System.out.print("LDR:");
		binaryTree.LDR(binaryTree.getRootNode());
		System.out.println();

		System.out.print("nonLDR:");
		binaryTree.nonLDR(binaryTree.getRootNode());
		System.out.println();

		System.out.print("LRD:");
		binaryTree.LRD(binaryTree.getRootNode());
		System.out.println();

		System.out.print("nonLRD:");
		binaryTree.nonLRD(binaryTree.getRootNode());
		System.out.println();

		System.out.print("LEVEL:");
		binaryTree.Level(binaryTree.getRootNode());
		System.out.println();

		binaryTree.getMirror(binaryTree.getRootNode());
		binaryTree.nonGetMirror(binaryTree.getRootNode());

		System.out.print("LEVEL:");
		binaryTree.Level(binaryTree.getRootNode());
		System.out.println();

		System.out.print("High:");
		System.out.println(binaryTree.getHight(binaryTree.getRootNode()));

		System.out.print("Long��Left:");
		binaryTree.getLongest(binaryTree.getRootNode());
		System.out.println();

		System.out.print("isAVL:");
		System.out.print(binaryTree.isAVL(binaryTree.getRootNode()));
		System.out.println();

		binaryTree.delete("A");
		binaryTree.Level(binaryTree.getRootNode());
		

	}

}
