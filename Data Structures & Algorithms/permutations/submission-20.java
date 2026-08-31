class Solution {
    private void findPerm(
        List<List<Integer>> result, 
        final int[] nums,
        List<Integer> subset,
        boolean[] isVisited) 
    {
        if (subset.size() == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (isVisited[i]) {
                continue;
            }

            isVisited[i] = true;
            subset.add(nums[i]);
            findPerm(result, nums, subset, isVisited);
            subset.remove(subset.size() - 1);
            isVisited[i] = false;
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] isVisited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            isVisited[i] = false;
        }

        findPerm(result, nums, new ArrayList<>(), isVisited);
        return result;
    }
}
