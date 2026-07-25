class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();

        int j = 0;
        int count = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            final Character c = s.charAt(i);
            
            while (set.add(c) == false) {
                set.remove(s.charAt(j));
                j++;
                count--;
            }

            set.add(c);
            count = i - j + 1;
            max = (count > max) ? count : max;
        }

        return max;
    }
}
