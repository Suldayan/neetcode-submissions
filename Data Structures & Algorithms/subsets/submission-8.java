class Solution {
    private void createSubset(
        List<List<Integer>> result, 
        List<Integer> subset,
        final int[] nums,
        int index) 
    {
        result.add(new ArrayList<>(subset));

        for (int i = index; i < nums.length; i++) {
            subset.add(nums[i]);
            createSubset(result, subset, nums, i + 1);
            subset.remove(subset.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        createSubset(result, new ArrayList<>(), nums, 0);
        return result;
    }
}
