import java.util.*;

class Solution {
    public boolean gcdSort(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        UnionFind uf = new UnionFind(max + 1);

        // Step 1: Connect numbers with their prime factors
        for (int num : nums) {
            int x = num;
            for (int i = 2; i * i <= x; i++) {
                if (x % i == 0) {
                    uf.union(num, i);
                    while (x % i == 0) {
                        x /= i;
                    }
                }
            }
            if (x > 1) {
                uf.union(num, x);
            }
        }

        // Step 2: Sort array
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        // Step 3: Check if swapping is possible
        for (int i = 0; i < nums.length; i++) {
            if (uf.find(nums[i]) != uf.find(sorted[i])) {
                return false;
            }
        }

        return true;
    }
}

class UnionFind {
    int[] parent;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Path compression
        }
        return parent[x];
    }

    public void union(int a, int b) {
        parent[find(a)] = find(b);
    }
}
