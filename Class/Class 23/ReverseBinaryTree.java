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
	
	public static List<Integer> preOrder(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		preOrder(root, result);
		return result;
	}

	private static void preOrder(TreeNode root, List<Integer> result) {
		if (root == null) {
			return;
		}
		result.add(root.value);
		preOrder(root.left, result);
		preOrder(root.right, result);
	}
}

/**
 * Given a binary tree where all the right nodes are leaf nodes,
 * flip it upside down and turn it into a tree with left leaf nodes.
 * For example, turn these:
 *       1                4
 *     /   \            /   \
 *    2     3   -->    2     5
 *  /  \              / \
 * 4    5            1   3
 */
public class ReverseBinaryTree {

	public TreeNode reverse(TreeNode root) {
		if (root == null || root.left == null) {
			return root;
		}
		TreeNode newRoot = reverse(root.left);
		root.left.left = root;
		root.left.right = root.right;
		root.left = null;
		root.right = null;
		return newRoot;
	}
	
	public TreeNode reverseIterative(TreeNode root) {
		TreeNode prev = null;
		TreeNode prevRight = null;
		while (root != null) {
			TreeNode next = root.left;
			TreeNode curRight = root.right;
			root.left = prev;
			root.right = prevRight;
			prev = root;
			prevRight = curRight;
			root = next;
		}
		return prev;
	}
	
	public static void main(String[] args) {
		ReverseBinaryTree solution = new ReverseBinaryTree();
		
		TreeNode root = null;
		System.out.println(solution.reverse(root));
		System.out.println(solution.reverseIterative(root));
		
		root = TreeNode.reConstruct(new String[] {"1", "2", "4", "#", "#",
				"5", "#", "#", "3", "#", "#"});
		TreeNode.preOrder(solution.reverse(root));
		System.out.println();
		root = TreeNode.reConstruct(new String[] {"1", "2", "4", "#", "#",
				"5", "#", "#", "3", "#", "#"});
		TreeNode.preOrder(solution.reverseIterative(root));
		System.out.println();
	}
}
