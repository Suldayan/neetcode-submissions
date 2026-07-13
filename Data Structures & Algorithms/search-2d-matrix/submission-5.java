class Solution {
    private boolean binarySearch(final int[] array, final int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            final int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return true;
            }
            else if (array[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        final int numColumns = matrix[0].length - 1;                                                           
        int left = 0;
        int right = matrix.length - 1;

        while (left <= right) {
            final int mid = left + (right - left) / 2;
            final int[] array = matrix[mid];

            int max = array[numColumns];

            if (array[0] <= target && target <= max) {
                return binarySearch(array, target);
            }
            else if (target < array[0]) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return false;
    }
}
