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
 * Given a binary tree in which each node element contains a number.
 * Find the maximum possible sum from one leaf node to another.
 */
public class MaxSum {

	static class Result {
		int maxSum;
		int maxSingle;
		Result(int maxSum, int maxSingle) {
			this.maxSum = maxSum;
			this.maxSingle = maxSingle;
		}
	}
	
	public int maxSum(TreeNode root) {
		assert root != null;
		return maxSumHelper(root).maxSum;
	}
	
	private Result maxSumHelper(TreeNode root) {
		if (root.left == null && root.right == null) {
			return new Result(Integer.MIN_VALUE, root.value);
		} else if (root.left == null) {
			Result result = maxSumHelper(root.right);
			result.maxSingle += root.value;
			return result;
		} else if (root.right == null) {
			Result result = maxSumHelper(root.left);
			result.maxSingle += root.value;
			return result;
		} else {
			Result leftResult = maxSumHelper(root.left);
			Result rightResult = maxSumHelper(root.right);
			int maxSum = root.value + leftResult.maxSingle + rightResult.maxSingle;
			leftResult.maxSingle = Math.max(leftResult.maxSingle, rightResult.maxSingle) + root.value;
			leftResult.maxSum = Math.max(Math.max(leftResult.maxSum, rightResult.maxSum), maxSum);
			return leftResult;
		}
	}
	
	public static void main(String[] args) {
		MaxSum solution = new MaxSum();
		
		TreeNode root = TreeNode.reConstruct(new String[] {"-8", "4", "#", "#", "2", "1", "#", "#",
				"1", "#", "#"});
		System.out.println(solution.maxSum(root));
		
		root = TreeNode.reConstruct(new String[] {"10", "#", "1", "#", "6", "#", "#"});
		System.out.println(solution.maxSum(root));
		
		root = TreeNode.reConstruct(new String[] {"2", "-11", "#", "#", "6", "#", "-2", "#", "#"});
		System.out.println(solution.maxSum(root));
		
		root = TreeNode.reConstruct(new String[] {"-15", "5", "-8", "#", "#", "1", "#", "#", "6", "3",
				"#", "#", "9", "#", "0", "4", "#", "#", "-1", "10", "#", "#", "#"});
		System.out.println(solution.maxSum(root));
	}
}
