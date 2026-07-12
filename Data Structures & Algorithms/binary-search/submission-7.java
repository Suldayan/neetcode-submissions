class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;


        while (left <= right) {
            final int curr = left + (right - left) / 2;

            if (nums[curr] == target) {
                return curr;
            } 
            else if (nums[curr] > target) {
                right = curr - 1;
            } else {
                left = curr + 1;
            }
        }

        return -1;
    }
}
