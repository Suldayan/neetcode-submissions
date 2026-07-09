class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;

        while (i < j) {
            final int currentSum = numbers[i] + numbers[j];
            if (currentSum > target) {
                j--;
            }

            if (currentSum < target) {
                i++;
            }

            if (currentSum == target) {
                return new int[]{i + 1, j + 1};
            }
        }

        return new int[]{i + 1, j + 1};
    }
}
