package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

	private Node rootNode = null;

	/**
	 * 构造函数,构造二叉树根节点
	 * */
	public BinaryTree(Node rootNode) {
		this.rootNode = rootNode;
	}

	/**
	 * 前序遍历二叉树
	 * */
	public void DLR(Node rootNode) {
		if (rootNode != null) {
			System.out.print(rootNode.getData());
			DLR(rootNode.getLeftChild());
			DLR(rootNode.getRightChild());
		}
	}

	/**
	 * 非递归前序遍历二叉树
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
	 * 中序遍历二叉树
	 * */
	public void LDR(Node rootNode) {
		if (rootNode != null) {
			LDR(rootNode.getLeftChild());
			System.out.print(rootNode.getData());
			LDR(rootNode.getRightChild());
		}
	}

	/**
	 * 非递归中序遍历二叉树
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
	 * 后序遍历二叉树
	 * */
	public void LRD(Node rootNode) {
		if (rootNode != null) {
			LRD(rootNode.getLeftChild());
			LRD(rootNode.getRightChild());
			System.out.print(rootNode.getData());
		}
	}

	/**
	 * 非递归后序遍历二叉树
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
	 * 层次遍历二叉树
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
	 * 返回当前根结点
	 * 
	 * @return Node
	 * */
	public Node getRootNode() {
		return this.rootNode;
	}

	/**
	 * 递归二叉树高度
	 * 
	 * @param currentNode
	 *            当前根节点
	 * @return int 高度
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
	 * 判断一个二叉树是否为平衡二叉树（任意结点左右子树高度差都不大于1）
	 * 
	 * @param currentNode
	 *            当前结点
	 * @return true 是平衡二叉树 false 不是平衡二叉树
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
	 * 递归->二叉树镜像(任意子树交换左右结点)
	 * 
	 * @param currentNode
	 *            当前结点
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
	 * 非递归->二叉树镜像
	 * 
	 * @param currentNode
	 *            当前结点
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
	 * 最左最长路径
	 * 
	 * @param currentNode
	 *            当前根节点
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
		
		boolean flag=false;//左
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

		System.out.print("Long、Left:");
		binaryTree.getLongest(binaryTree.getRootNode());
		System.out.println();

		System.out.print("isAVL:");
		System.out.print(binaryTree.isAVL(binaryTree.getRootNode()));
		System.out.println();

		binaryTree.delete("A");
		binaryTree.Level(binaryTree.getRootNode());
		

	}

}
