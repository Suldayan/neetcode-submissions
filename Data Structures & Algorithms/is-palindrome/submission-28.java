class Solution {
    public boolean isPalindrome(String s) {
        int size = s.length();

        int i = 0;
        int j = size - 1;

        while (i < j) {
            if (Character.isLetterOrDigit(s.charAt(j)) && Character.isLetterOrDigit(s.charAt(i))) {
                if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                    System.out.println("J and I are not equal");
                    return false;
                }
            } 

            if (!Character.isLetterOrDigit(s.charAt(j))) {
                System.out.println(String.format("J is not a letter: %c", s.charAt(j)));
                j--;
                continue;
            }

            if (!Character.isLetterOrDigit(s.charAt(i))) {
                System.out.println(String.format("I is not a letter: %c", s.charAt(i)));
                i++;
                continue;
            }

            i++;
            j--;
        }

        return true;
    }
}
