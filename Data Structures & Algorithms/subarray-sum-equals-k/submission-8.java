class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int output = 0;
        int currSum = 0;
        for (final int num : nums) {
            currSum += num;
            final int difference = currSum - k;
            if (difference == 0) {
                output++;
            }

            if (map.containsKey(difference)) {
                output += map.get(difference);
            } 

            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }

        return output;
    }
}