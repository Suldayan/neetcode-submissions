class Solution {
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private void findPartitions(
        List<List<String>> result, 
        String s, 
        List<String> p, 
        int index) 
    {
        if (index == s.length()) {
            result.add(new ArrayList<>(p));
            return;
        }

        for (int i = index + 1; i <= s.length(); i++) {
            if (isPalindrome(s, index, i - 1)) {
                p.add(s.substring(index, i));
                findPartitions(result, s, p, i);
                p.remove(p.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        
        findPartitions(result, s, new ArrayList<>(), 0);
        return result;
    }
}
