package Solution;

public class Solution6 {

	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}

	public int TreeDepth(TreeNode root) {
		if (root == null)
			return 0;
		int L = TreeDepth(root.left);
		int R = TreeDepth(root.right);
		return L >= R ? ++L : ++R;
	}
}
