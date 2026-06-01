class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> freq = new HashSet<>();
        final int size = nums.length;
        int maxSequence = 0;

        // Initial pass to populate the hashset
        for (int i = 0; i < size; i++) {
            freq.add(nums[i]);
        }

        // Iterate through nums again but compare against the hashset
        for (int i = 0; i < size; i++) {
            int currentSequence = 0;
            int currNum = nums[i];

            if (!freq.contains(currNum - 1)) {
                System.out.println("Found a start");
                currentSequence++;

                while (freq.contains(currNum + 1)) {
                    currNum++;
                    currentSequence++;
                }
            } 

            if (currentSequence > maxSequence) {
                maxSequence = currentSequence;
            }
        }

        return maxSequence;
    }
}
