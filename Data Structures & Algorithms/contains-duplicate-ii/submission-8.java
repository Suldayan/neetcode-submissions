class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        final int size = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < size; i++) {
            final int num = nums[i];
            if (map.containsKey(num) == false) {
                map.put(num, i);
            } else {
                if (Math.abs(i - map.get(num)) <= k) {
                    return true;
                }

                map.put(num, i);
            }
        }

        return false;
    }
}