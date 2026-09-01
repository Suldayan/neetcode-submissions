class Solution {
    private void makeSubset(
        List<List<Integer>> result, 
        final int[] nums, 
        List<Integer> subset,
        int index) 
    {
        result.add(new ArrayList<>(subset));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            subset.add(nums[i]);
            makeSubset(result, nums, subset, i + 1);
            subset.remove(subset.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        makeSubset(result, nums, new ArrayList<>(), 0);

        return result;
    }
}
