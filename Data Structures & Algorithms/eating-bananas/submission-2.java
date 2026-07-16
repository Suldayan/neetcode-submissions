class Solution {
    private static int getMax(final int[] piles) {
        if (piles == null || piles.length == 0) {
            throw new IllegalArgumentException();
        }

        int max = piles[0];
        for (final int pile : piles) {
            if (pile > max) 
                max = pile;
        }

        return max;
    }

    public int minEatingSpeed(int[] piles, int h) {
        final int max = getMax(piles);

        int left = 1;
        int right = max;
        int k = max;

        while (left <= right) {
            final int mid = left + (right - left) / 2;

            long totalHours = 0;
            for (final int pile : piles) {
                int ceiling = (int) Math.ceil((double) pile / (double) mid);
                totalHours += ceiling;
            }

            if (totalHours <= h) {
                right = mid - 1;
                k = mid;        
            } else {
                left = mid + 1;
            }
        }

        return k;
    }
}
