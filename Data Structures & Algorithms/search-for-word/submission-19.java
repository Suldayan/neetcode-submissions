class Solution {
    private boolean findWord(
        final char[][] board,
        final String word,
        final int i,
        final int j,
        final int index
    ) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        final char temp = board[i][j];
        board[i][j] = '#';

        final boolean isExist = 
            findWord(board, word, i + 1, j, index + 1) ||
            findWord(board, word, i, j + 1, index + 1) ||
            findWord(board, word, i - 1, j, index + 1) ||
            findWord(board, word, i, j - 1, index + 1);

        board[i][j] = temp;

        return isExist;
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && findWord(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }
}
