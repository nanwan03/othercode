public class Solution {
  public boolean validPostOrder(int[] post) {
	    // Write your solution here.
	    if (post == null || post.length == 0) {
	      return true;
	    }
	    return buildBST(post, 0, post.length - 1);
	  }
	  private boolean buildBST(int[] post, int left, int right) {
	    if (left >= right) {
	      return true;
	    }
	    int nextSmaller = findNext(post, left, right - 1, post[right]);
	    if (checkLeft(post, left, nextSmaller, post[right]) && checkRight(post, nextSmaller + 1, right - 1, post[right])) {
	      return buildBST(post, left, nextSmaller) && buildBST(post, nextSmaller + 1, right - 1);
	    } else {
	      return false;
	    }
	  }
	  private int findNext(int[] post, int left, int right, int target) {
	    while (left <= right && post[right] >= target) {
	      right--;
	    }
	    return right;
	  }
	  private boolean checkLeft(int[] post, int left, int right, int target) {
	    for (int i = left; i <= right; ++i) {
	      if (post[i] >= target) {
	        return false;
	      }
	    }
	    return true;
	  }
	  private boolean checkRight(int[] post, int left, int right, int target) {
	    for (int i = left; i <= right; ++i) {
	      if (post[i] <= target) {
	        return false;
	      }
	    }
	    return true;
	  }
}
