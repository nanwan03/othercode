import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean canFit(String[] guests) {
        if (guests == null || guests.length == 1) {
            return true;
        }
        String[] table = new String[guests.length];
        boolean[] visited = new boolean[guests.length];
        return helper(guests, table, visited, 0);
    }
    private boolean helper(String[] guests, String[] table, boolean[] visited, int index) {
        if (index == table.length - 1) {
            for (int i = 0; i < guests.length; ++i) {
                if (!visited[i]) {
                    String guest = guests[i];
                    String prev = table[index - 1];
                    String next = table[0];
                    if (guest.charAt(0) == prev.charAt(prev.length() - 1) && guest.charAt(guest.length() - 1) == next.charAt(0)) {
                        return true;
                    }
                }
            }
            return false;
        }
        for (int i = 0; i < guests.length; ++i) {
            String guest = guests[i];
            if (index == 0) {
                table[index] = guest;
                visited[i] = true;
                boolean flag = helper(guests, table, visited, index + 1);
                if (flag) {
                    return true;
                }
                visited[i] = false;
                table[index] = null;
            } else {
                String prev = table[index - 1];
                if (prev.charAt(prev.length() - 1) == guest.charAt(0)) {
                    table[index] = guest;
                    visited[i] = true;
                    boolean flag = helper(guests, table, visited, index + 1);
                    if (flag) {
                        return true;
                    }
                    visited[i] = false;
                    table[index] = null;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(new Solution().canFit(new String[]{"ALICE", "CHARLES", "ERIC", "SOPHIAB"}));
    }
}

