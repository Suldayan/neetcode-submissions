class Solution {
    private HashSet<Integer> visited = new HashSet<>();

    private void traverseComponent(
        List<List<Integer>> adj,
        int curr,
        int components
    ) {
        visited.add(curr);
        for (final int neighbor : adj.get(curr)) {
            if (!visited.contains(neighbor)) {
                traverseComponent(adj, neighbor, components);
            }
        }
    }

    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (final int[] edge : edges) {
            final int parent = edge[0];
            final int child = edge[1];

            adj.get(parent).add(child);
            adj.get(child).add(parent);
        }

        int components = 0;
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                traverseComponent(adj, i, components);
                components++;
            }
        }

        return components;
    }
}
