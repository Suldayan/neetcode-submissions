class Solution {
    public int findMin(int[] nums) {
        final int length = nums.length - 1;

        int left = 0;
        int right = length;

        int min = nums[0];
        while (left < right) {
            final int mid = left + (right - left) / 2;

            if (nums[mid] < min) {
                min = nums[mid];
            }

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } 
            else {
                right = mid;
            }
        }

        if (nums[left] < min) {
            return nums[left];
        }

        return min;
    }
}
