class Solution {
    private HashSet<Integer> visited = new HashSet<>();

    private boolean hasCycle(List<List<Integer>> adj, int curr, int parent) {
        visited.add(curr);

        boolean isCycle;
        for (final int neighbor : adj.get(curr)) {
            if (neighbor == parent) {
                continue;
            }

            if (visited.contains(neighbor)) {
                return true;
            }

            if (hasCycle(adj, neighbor, curr)) {
                return true;
            }
        }

        return false;
    }

    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (final int[] pair : edges) {
            final int parent = pair[0];
            final int child = pair[1];

            adj.get(parent).add(child);
            adj.get(child).add(parent);
        }

        if (hasCycle(adj, 0, -1)) {
            return false;
        }

        return visited.size() == n;
    }
}
