class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] output = {0, 0};

        for (int i = 0; i < numbers.length; i++) {
            final int compliment = target - numbers[i];
            final int index = Arrays.binarySearch(numbers, compliment);

            if (index >= 0) {
                System.out.println(String.format("Found c: %d at i: %d", compliment, index));
                System.out.println(String.format("%d + %d = %d", compliment, numbers[i], target));
                if (index > i) {
                    output[0] = i + 1;
                    output[1] = index + 1;
                } else {
                    output[0] = index + 1;
                    output[1] = i + 1;                  
                }
            }
        }

        return output;
    }
}
