class Solution {
    private void formParenthesis(
        final int n, 
        List<String> result,
        String parenthesis,
        int openedCount,
        int closedCount) 
    {
        if (openedCount + closedCount == n * 2) {
            result.add(parenthesis);
            return;
        }

        if (openedCount < n) {
            formParenthesis(n, result, parenthesis + "(", openedCount + 1, closedCount);
        }

        if (closedCount < openedCount) {
            formParenthesis(n, result, parenthesis + ")", openedCount, closedCount + 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        formParenthesis(n, result, "", 0, 0);
        return result;
    }
}