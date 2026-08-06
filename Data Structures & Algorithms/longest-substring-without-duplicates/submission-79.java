class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        HashSet<Character> set = new HashSet<>();

        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            final Character c = s.charAt(i);
            while (!set.add(c)) {
                set.remove(s.charAt(j));
                j++;
            }

            set.add(c);

            final int length = i - j + 1;
            result = (length > result) ? length : result;
        }

        return result;
    }
}
