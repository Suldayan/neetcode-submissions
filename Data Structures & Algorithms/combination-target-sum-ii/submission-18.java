class Solution {
    private void buildCombination(
        List<List<Integer>> result, 
        final int[] candidates,
        List<Integer> candidate, 
        int currentSum,
        final int target,
        int index) 
    {
        if (currentSum == target) {
            result.add(new ArrayList<>(candidate));
            return;
        }

        if (currentSum > target) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            candidate.add(candidates[i]);
            buildCombination(result, candidates, candidate, currentSum + candidates[i], target, i + 1);
            candidate.remove(candidate.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);

        buildCombination(result, candidates, new ArrayList<>(), 0, target, 0);
        return result;
    }
}
