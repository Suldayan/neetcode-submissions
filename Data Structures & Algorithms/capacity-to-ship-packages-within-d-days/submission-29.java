class Solution {
    private int sumOfWeights(final int[] weights) {
        int sum = 0;
        for (final int weight : weights) {
            sum += weight;
        }

        return sum;
    }

    private int getMax(final int[] weights) {
        int max = weights[0];
        for (final int weight : weights) {
            max = (weight > max) ? weight : max;
        }

        return max;
    }

    public int shipWithinDays(int[] weights, int days) {
        final int maxWeight = sumOfWeights(weights);
        int left = getMax(weights);
        int right = maxWeight;
        int leastWeight = maxWeight;

        while (left <= right) {
            final int mid = left + (right - left) / 2;

            int sum = 0;
            int testDays = 0;
            for (final int weight : weights) {
                if (sum + weight > mid) {
                    testDays++;
                    sum = weight;
                } else {
                    sum += weight;
                }
            }
            testDays++;

            if (testDays <= days) {
                leastWeight = (leastWeight < mid) ? leastWeight : mid;
                right = mid - 1;
            } else if (testDays > days) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return (maxWeight == leastWeight) ? maxWeight : leastWeight;
    }
}