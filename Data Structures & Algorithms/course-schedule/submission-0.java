class Solution {
    private HashSet<Integer> visited = new HashSet<>();
    private HashSet<Integer> visiting = new HashSet<>();

    private boolean hasCycle(
        List<List<Integer>> adj,
        int course) 
    {
        if (visiting.contains(course)) {
            return true;
        }

        if (visited.contains(course)) {
            return false;
        }

        visiting.add(course);
        for (int nextCourse : adj.get(course)) {
            if (hasCycle(adj, nextCourse)) {
                return true;
            }
        }

        visiting.remove(course);
        visited.add(course);

        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (final int[] pair : prerequisites) {
            final int course = pair[0];
            final int prereq = pair[1];

            adj.get(course).add(prereq);
        }

        for (int course = 0; course < numCourses; course++) {
            if (hasCycle(adj, course)) {
                return false;
            }
        }

        return true;
    }
}
