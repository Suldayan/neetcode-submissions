class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        var output = new ArrayList<List<String>>();
        var map = new HashMap<List<Integer>, List<String>>();

        for (String str : strs) {
            // Because we know that there are only lowercase letters, we can create an array
            // of size 25, a constant number, therefore making it constant space.
            List<Integer> charFreq = new ArrayList<>(Collections.nCopies(26, 0));
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                int index = c - 'a'; 
                charFreq.set(index, charFreq.get(index) + 1);
            }

            map.computeIfAbsent(charFreq, k -> new ArrayList<>())
                .add(str);
        }

        map.forEach((key, value) -> {
            output.add(value);
        });

        return output;
    }
}
