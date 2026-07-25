class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> s1Map = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            final Character c = s1.charAt(i);
            s1Map.put(c, s1Map.getOrDefault(c, 0) + 1);
        }

        int j = 0;
        HashMap<Character, Integer> s2Map = new HashMap<>();
        for (int i = 0; i < s2.length(); i++) {
            final Character c = s2.charAt(i);  

            if (i - j + 1 > s1.length()) {
                final Character c2 = s2.charAt(j);

                s2Map.computeIfPresent(c2, (key, value) -> {
                    final int newValue = value - 1;
                    return newValue == 0 ? null : newValue;
                });
                
                j++;
            }

            s2Map.put(c, s2Map.getOrDefault(c, 0) + 1);
            if (s2Map.equals(s1Map)) {
                return true;
            }
        }

        return false;
    }
}
