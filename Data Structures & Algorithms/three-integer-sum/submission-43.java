class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> output = new ArrayList<>();
        HashSet<List<Integer>> subSet = new HashSet<>();

        Arrays.sort(nums);       
        for (int i = 0; i < n - 1; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k && j < n - 1) {
                int currentSum = nums[i] + nums[j] + nums[k];

                if (currentSum == 0) {
                    if (!subSet.add(List.of(nums[i], nums[j], nums[k]))) {
                        j++;
                        k--;
                        continue;
                    }

                    output.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if (currentSum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return output;
    }
}
