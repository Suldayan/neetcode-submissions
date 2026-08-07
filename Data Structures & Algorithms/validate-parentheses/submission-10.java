class Solution {
    private boolean isClosingBracket(final Character bracket) {
        return switch (bracket) {
            case ')', '}', ']' -> true;
            default -> false;
        };
    }

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            
            if (!isClosingBracket(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                final char openningBracket = stack.pop();
                if (openningBracket == '(' && c != ')') {
                    return false;
                }
                if (openningBracket == '[' && c != ']') {
                        return false;
                } 
                if (openningBracket == '{' && c != '}') {
                        return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
