class Solution {
    public int trap(int[] height) {
        final int size = height.length - 1;

        if (size == 0) {
            return 0;
        }
        
        int i = 0;
        int j = size;
        int area = 0;

        int leftMax = height[0];
        int rightMax = height[size];

        while (i < j) {
            final int leftHeight = height[i];
            final int rightHeight = height[j];

            if (leftHeight > leftMax) {
                leftMax = leftHeight;
            } 

            if (rightHeight > rightMax) {
                rightMax = rightHeight;
            } 

            if (leftMax >= rightMax) {
                j--;
                area += rightMax - rightHeight;
            } else {
                i++;
                area += leftMax - leftHeight;
            }
        }

        return area;
    }
}
