import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4};
        int[][] queries = {{3,1},{1,3},{5,6}};
        Solution sol = new Solution();
        for (int maximizeXor : sol.maximizeXor(nums, queries)) {
            System.out.println(maximizeXor);
        };
    }
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int[][] tempQ = new int[queries.length][(queries[0].length) + 1];

        for (int i = 0; i < queries.length; i++) {
            int[] temp = new int[3];
            int[] arr = queries[i];
            for (int j = 0; j < 2; j++) {
                temp[j] = arr[j];
            }
            temp[2] = i;
            tempQ[i] = temp;
        }

        Arrays.sort(tempQ, (a, b) -> Integer.compare(a[1], b[1]));

        Trie trie = new Trie();
        int arrPtr = 0;
        int[] ans = new int[queries.length];

        for (int i = 0; i < tempQ.length; i++) {
            int mi = tempQ[i][1];
            int xi = tempQ[i][0];
            // Insert into trie
            while (arrPtr < nums.length && nums[arrPtr] <= mi) {
                trie.insert(nums[arrPtr]);
                arrPtr++;
            }
            // Calculate the max XOR
            ans[tempQ[i][2]] = trie.maxXor(xi);
        }
        return ans;
    }
}

class Trie {
    Node root;

    Trie() {
        this.root = new Node();
    }

    public void insert(int num) {
        Node curr = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >>> i) & 1;
            if (curr.bits[bit] == null) {
                curr.bits[bit] = new Node();
            }
            curr = curr.bits[bit];
        }
    }

    public int maxXor(int num) {
        int maxXor = 0;
        Node curr = this.root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >>> i) & 1;
            int xorBit = bit ^ 1;
            if (curr.bits[xorBit] != null) {
                maxXor |= (1 << i);  
                curr = curr.bits[xorBit];
            } else {
                maxXor = maxXor | bit;
                curr = curr.bits[bit];
            }
        }
        return maxXor;
    }
}

class Node {
    Node[] bits;

    Node() {
        this.bits = new Node[2];
    }
}