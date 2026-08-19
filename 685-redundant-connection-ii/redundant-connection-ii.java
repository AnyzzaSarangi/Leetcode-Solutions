class Solution {
    int[] parent;
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        int[] candidate1 = null;
        int[] candidate2 = null;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (parent[v] != v) {
                candidate1 = new int[]{parent[v], v};
                candidate2 = new int[]{u, v};
            } else {
                parent[v] = u;
            }
        }
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            if (candidate2 != null &&
                edge[0] == candidate2[0] &&
                edge[1] == candidate2[1]) {
                continue;
            }
            int u = edge[0];
            int v = edge[1];
            int rootU = find(u);
            int rootV = find(v);
            if (rootU == rootV) {
                if (candidate1 != null) {
                    return candidate1;
                }
                return edge;
            }
            parent[rootV] = rootU;
        }
        return candidate2;
    }
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}