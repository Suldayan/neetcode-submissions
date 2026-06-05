class Solution {
    public int maxArea(int[] heights) {
        int i = 0;
        int j = heights.length - 1;
        int maxArea = 0;
        int currentArea = 0;

        while (i < j) {
            int length = Math.min(heights[i], heights[j]);
            int width = j - i;
            currentArea = length * width;

            if (currentArea > maxArea) {
                maxArea = currentArea;
            }

            if (heights[i] > heights[j]) {
                j--;
            } else {
                i++;
            }
        }

        return maxArea;
    }
}
