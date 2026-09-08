class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        HashSet<Character> set = new HashSet<>();

        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length() && set.contains(s.charAt(i))) {
                set.remove(s.charAt(j));
                j++;
            }
            
            set.add(s.charAt(i));
            maxLength = Math.max(maxLength, i - j + 1);
        }

        return maxLength;
    }
}
