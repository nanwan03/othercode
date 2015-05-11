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
 * Reconstruct the Binary Tree, given the in-order and level-order
 * traversal sequences.
 * Assumption:
 * 1). there is no duplicate element in the tree.
 */
public class InOrderLevelOrder {

	public TreeNode fromInOrderLevelOrder(int[] inOrder, int[] levelOrder) {
		assert inOrder != null && levelOrder != null;
		assert inOrder.length == levelOrder.length;
		List<Integer> levelList = arrayToList(levelOrder);
		HashMap<Integer, Integer> inMap = arrayToMap(inOrder);
		return fromInOrderLevelOrder(inMap, levelList);
	}
	
	private HashMap<Integer, Integer> arrayToMap(int[] inOrder) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < inOrder.length; i++) {
			map.put(inOrder[i], i);
		}
		return map;
	}

	private List<Integer> arrayToList(int[] levelOrder) {
		List<Integer> list = new ArrayList<Integer>();
		for (int num : levelOrder) {
			list.add(num);
		}
		return list;
	}
	
	private TreeNode fromInOrderLevelOrder(HashMap<Integer, Integer> inMap,
List<Integer> levelList) {
		if (levelList.isEmpty()) {
			return null;
		}
		TreeNode root = new TreeNode(levelList.remove(0));
		int inIdx = inMap.get(root.value);
		List<Integer> leftSubTree = new ArrayList<Integer>();
		List<Integer> rightSubTree = new ArrayList<Integer>();
		for (int num : levelList) {
			if (inMap.get(num) < inIdx) {
				leftSubTree.add(num);
			} else {
				rightSubTree.add(num);
			}
		}
		root.left = fromInOrderLevelOrder(inMap, leftSubTree);
		root.right = fromInOrderLevelOrder(inMap, rightSubTree);
		return root;		
	}
	
	public static void main(String[] args) {
		InOrderLevelOrder solution = new InOrderLevelOrder();
		
		int[] inOrder = new int[0];
		int[] levelOrder = new int[0];
		printPreOrder(solution.fromInOrderLevelOrder(inOrder, levelOrder));
		System.out.println();
		
		inOrder = new int[] {1, 2};
		levelOrder = new int[] {2, 1};
		printPreOrder(solution.fromInOrderLevelOrder(inOrder, levelOrder));
		System.out.println();
		
		inOrder = new int[] {1, 2, 3};
		levelOrder = new int[] {1, 2, 3};
		printPreOrder(solution.fromInOrderLevelOrder(inOrder, levelOrder));
		System.out.println();

		inOrder = new int[] {1, 2, 3, 4, 5, 6, 7};
		levelOrder = new int[] {3, 2, 7, 1, 5, 4, 6};
		printPreOrder(solution.fromInOrderLevelOrder(inOrder, levelOrder));
		System.out.println();
	}
	
	public static void printPreOrder(TreeNode root) {
		if (root == null) {
			System.out.print("# ");
			return;
		}
		System.out.print(root.value + " ");
		printPreOrder(root.left);
		printPreOrder(root.right);
	}
}
