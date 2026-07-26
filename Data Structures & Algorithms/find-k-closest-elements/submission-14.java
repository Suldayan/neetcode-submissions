class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            result.add(arr[i]);
            System.out.println(String.format("Initializing with: %d", arr[i]));
        }

        int j = 0;
        for (int i = k; i < arr.length; i++) {
            final int a = arr[i];
            final int b = arr[j];

            if (Math.abs(a - x) < Math.abs(b - x) || Math.abs(a - x) == Math.abs(b - x) && a < b) {
                System.out.println(String.format("Removing: %d, Adding: %d", result.get(0), a));
                result.remove(0);
                result.add(a);
                j++;
            }
        }

        return result;
    }
}