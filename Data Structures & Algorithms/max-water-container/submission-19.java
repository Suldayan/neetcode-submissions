class Solution {
    private int minHeight(int h1, int h2) {
        if (h1 > h2) 
            return h2;
        return h1;
    }

    public int maxArea(int[] heights) {
        int size = heights.length - 1;

        int i = 0;
        int j = size;
        int area = 0;
        
        while (i < j) {
            int width = j - i;
            int height = minHeight(heights[i], heights[j]); 
            int prevArea = width * height;

            if (heights[i] > heights[j]) {
                j--;
            }
            else {
                i++;
            }

            int tempHeight = minHeight(heights[i], heights[j]);
            int tempWidth = j - i;
            int currArea = tempHeight * tempWidth;

            if (currArea > prevArea && currArea > area) {
                area = currArea;
            } else if (prevArea > area) {
                area = prevArea;
            }
        }

        return area;
    }
}
