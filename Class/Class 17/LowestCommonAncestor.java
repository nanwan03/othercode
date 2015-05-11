import java.util.*;

class TreeNode {

	/*
	 * When using the pre-order array to represent the tree,
	 * this is for null node.
	 */
	static final String NULL_NODE = "#";

	/*
	 * A TreeNode contains an integer value, a reference to root of left subtree
	 * and a reference to root of right subtree.
	 */
	public int value;
	public TreeNode left;
	public TreeNode right;

	/*
	 * TreeNode constructor.
	 */
	public TreeNode(int value) {
		this.value = value;
	}

	/**
	 * Construct the binary tree using pre-order traversal sequence.
	 * 
	 * Note: the null node will be represented by a special value "#".
	 * 
	 * If null node is ignored in the pre-order traversal sequence,
	 * the constructed binary tree would not be UNIQUE.
	 * 
	 * Example:
	 *             2
	 *         /       \
	 *        1         3
	 *      /   \     /     \
	 *    null null null  null
	 * 
	 * The pre-order traversal sequence is:
	 * {"2", "1", "#", "#", "3", "#", "#"}
	 * Using the above sequence we can reconstruct the binary tree.
	 * 
	 * @param preOrder
	 *            the preOrder traversal sequence
	 * @return the root of the constructed binary tree
	 */
	public static TreeNode reConstruct(String[] preOrder) {
		if (preOrder == null || preOrder.length == 0) {
			return null;
		}
		return reConstruct(preOrder, 0).node;
	}

	/*
	 * The real implementation of re-construction from preOrder traverse.
	 */
	private static Result reConstruct(String[] preOrder, int left) {
		if (preOrder[left].equals(NULL_NODE)) {
			return new Result(left + 1, null);
		}
		TreeNode root = new TreeNode(Integer.parseInt(preOrder[left]));
		Result leftResult = reConstruct(preOrder, left + 1);
		root.left = leftResult.node;
		Result rightResult = reConstruct(preOrder, leftResult.index);
		root.right = rightResult.node;
		rightResult.node = root;
		return rightResult;
	}

	/*
	 * Helper class for storing the intermediate information used in
	 * reConstruct(String[] preOrder, int left) method.
	 */
	private static class Result {
		int index;
		TreeNode node;

		Result(int index, TreeNode node) {
			this.index = index;
			this.node = node;
		}
	}
}

/**
 * Lowest Common Ancestor of 2 nodes.
 * Assumption: the provided 2 nodes are in the tree.
 * 1). without parent reference.
 * 2). with parent reference. 
 */
public class LowestCommonAncestor {

	static class PTreeNode {
		int value;
		PTreeNode left;
		PTreeNode right;
		PTreeNode parent;
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
		if (root == null) {
			return null;
		}
		if (root == node1 || root == node2) {
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left, node1, node2);
		TreeNode right = lowestCommonAncestor(root.right, node1, node2);
		if (left != null && right != null) {
			return root;
		}
		return left == null ? right : left;
	}

	// lowest common ancestor for k nodes, assuming all the k nodes are in the tree.
	public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
		assert nodes.size() >= 2;
		if (root == null) {
			return null;
		}
		for (TreeNode node : nodes) {
			if (root == node) {
				return root;
			}
		}
		TreeNode left = lowestCommonAncestor(root.left, nodes);
		TreeNode right = lowestCommonAncestor(root.right, nodes);
		if (left != null && right != null) {
			return root;
		}
		return left == null ? right : left;
	}
	
	public PTreeNode lowestCommonAncestor(PTreeNode node1, PTreeNode node2) {
		assert node1 != null && node2 != null;
		int len1 = length(node1);
		int len2 = length(node2);
		return mergeNode(node1, node2, len1 - len2);
	}
	
	private PTreeNode mergeNode(PTreeNode node1, PTreeNode node2, int lenDiff) {
		if (lenDiff < 0) {
			return mergeNode(node2, node1, -lenDiff);
		}
		while (lenDiff > 0) {
			node1 = node1.parent;
			lenDiff--;
		}
		while (node1 != node2) {
			node1 = node1.parent;
			node2 = node2.parent;
		}
		return node1;
	}
	
	private int length(PTreeNode node) {
		int length = 0;
		while (node != null) {
			node = node.parent;
			length++;
		}
		return length;
	}

	public static void main(String[] args) {
		LowestCommonAncestor solution = new LowestCommonAncestor();
		
		/*
		 *         1
		 *      2      3   
		 *   4    5
		 *  6   
		 */
		TreeNode root = TreeNode.reConstruct(new String[] {"1", "2", "4", "6", "#", "#", "#",
				"5", "#", "#", "3", "#", "#"});
		System.out.println(solution.lowestCommonAncestor(root, root.left.left.left, root.left.right));
		System.out.println(solution.lowestCommonAncestor(root, root.left.left.left, root.right));
		System.out.println(solution.lowestCommonAncestor(root, root.left.left.left, root.left));
	}
}
