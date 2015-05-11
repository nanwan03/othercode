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
 * Binary Search Tree related questions.
 * 1). find closest number to target.
 * 2). find the largest number smaller than target.
 * 3). delete value from BST.
 * 4). insert value in BST.
 * Assumption:
 * There is no duplicate values in BST.
 */
public class BST {

	public int findClosest(TreeNode root, int target) {
		assert root != null;
		int closest = root.value;
		while (root != null) {
			if (root.value == target) {
				return root.value;
			}
			if (Math.abs(root.value - target) < Math.abs(closest - target)) {
				closest = root.value;
			}
			if (root.value < target) {
				root = root.right;
			} else {
				root = root.left;
			}
		}
		return closest;
	}
	
	public int findLargestSmaller(TreeNode root, int target) {
		assert root != null;
		int largestSmaller = Integer.MIN_VALUE;
		while (root != null) {
			if (root.value >= target) {
				root = root.left;
			} else {
				largestSmaller = root.value;
				root = root.right;
			}
		}
		return largestSmaller;
	}
	
	public TreeNode remove(TreeNode root, int target) {
		if (root == null) {
			return null;
		}
		if (root.value > target) {
			root.left = remove(root.left, target);
			return root;
		} else if (root.value < target) {
			root.right = remove(root.right, target);
			return root;
		} else {
			if (root.right == null) {
				return root.left;
			} else if (root.left == null) {
				return root.right;
			} else if (root.right.left == null) {
				root.right.left = root.left;
				return root.right;
			} else {
				TreeNode newRoot = removeSmallest(root.right);
				newRoot.left = root.left;
				newRoot.right = root.right;
				return newRoot;
			}
		}
	}
	
	private TreeNode removeSmallest(TreeNode root) {
		assert root != null && root.left != null;
		while (root.left.left != null) {
			root = root.left;
		}
		TreeNode smallest = root.left;
		root.left = root.left.right;
		return smallest;
	}
	
	public boolean insert(TreeNode root, int value) {
		assert root != null;
		while (root.value != value) {
			if (root.value < value) {
				if (root.right == null) {
					root.right = new TreeNode(value);
					return true;
				} else {
					root = root.right;
				}
			} else {
				if (root.left == null) {
					root.left = new TreeNode(value);
					return true;
				} else {
					root = root.left;
				}
			}
		}
		return false;
	}
}
