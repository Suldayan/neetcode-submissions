class Solution {
    private void makeCombination(
        List<List<Integer>> result,
        List<Integer> combination,
        final int[] nums, 
        final int target, 
        int currentSum,
        int index) 
    {
        if (currentSum == target) {
            result.add(new ArrayList<>(combination));
            return;   
        } 

        if (currentSum > target) {
            return;
        }
    
        for (int i = index; i < nums.length; i++) {     
            combination.add(nums[i]);
            makeCombination(result, combination, nums, target, currentSum + nums[i], i);
            combination.remove(combination.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        makeCombination(result, new ArrayList<>(), nums, target, 0, 0);
        return result;
    }
}
