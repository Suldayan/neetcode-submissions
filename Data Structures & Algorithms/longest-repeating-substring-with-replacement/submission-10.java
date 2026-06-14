class Solution {
    public int characterReplacement(String s, int k) {
        final int size = s.length();
        int[] counts = new int[26];

        int maxFreq = 0;
        int maxLength = 0;

        int j = 0;
        for (int i = 0; i < size; i++) {
            char c = s.charAt(i);
            int windowLength = i - j + 1;

            counts[c - 'A']++;
            maxFreq = Math.max(maxFreq, counts[c - 'A']);

            while ((windowLength - maxFreq) > k) {
                c = s.charAt(j);
                counts[c - 'A']--;

                j++;
                windowLength = i - j + 1;  
            }

            maxLength = Math.max(maxLength, i - j + 1);
        }

        return maxLength;
    }
}
