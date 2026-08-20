class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        final int length = nums.length;

        for (int i = 0; i < length; i++) {
            set.add(nums[i]);
        }

        int curr = 1;
        int max = 0;
        for (int i = 0; i < length; i++) {
            if (!set.contains(nums[i] - 1)) {
                Integer currentNum = nums[i];
                curr = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    curr++;
                }

                max = (max > curr) ? max : curr;
            } 
        }

        return max;
    }
}
