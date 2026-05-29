class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int size = nums.length;

        // 1. Map counts
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            int currentCount = freq.getOrDefault(num, 0);
            freq.put(num, currentCount + 1);
        }

        // 2. Initialize Buckets
        List<List<Integer>> buckets = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            buckets.add(new ArrayList<>());
        }

        // 3. Put keys into buckets based on frequency index (0-indexed adjustment)
        freq.forEach((key, value) -> {
            buckets.get(value - 1).add(key);
        });

        // 4. Gather top k outputs
        int[] output = new int[k];
        int j = 0;
        int bucketSize = buckets.size() - 1;
        
        // Loop backwards all the way to 0 to safely search all frequencies
        for (int i = bucketSize; i >= 0; i--) {
            // Enhanced for-each loop bypasses the manual indexing typo bugs!
            for (int num : buckets.get(i)) {
                output[j] = num;  
                j++;              
                
                if (j == k) return output; 
            }
        }

        return output;
    }
}