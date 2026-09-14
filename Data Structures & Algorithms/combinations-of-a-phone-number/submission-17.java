class Solution {
    private final String[] NUM_TO_DIGIT = { 
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    private void createCombination(
        List<String> result,
        String[] mapping,
        StringBuilder combo,
        int index
    ) {
        if (index == mapping.length) {
            result.add(combo.toString());
            return;
        }

        final String s = mapping[index];
        for (int j = 0; j < s.length(); j++) {
            combo.append(s.charAt(j));
            createCombination(result, mapping, combo, index + 1);
            combo.deleteCharAt(combo.length() - 1);
            
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        String[] mapping = new String[digits.length()];

        for (int i = 0; i < digits.length(); i++) {
            final int n = digits.charAt(i) - '0';
            mapping[i] = NUM_TO_DIGIT[n];
        }

        createCombination(result, mapping, new StringBuilder(""), 0);
        return result;
    }
}
