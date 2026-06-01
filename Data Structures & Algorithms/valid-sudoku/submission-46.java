class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<HashSet<Character>> rowFreq = new ArrayList<>();
        List<HashSet<Character>> colFreq = new ArrayList<>();
        List<HashSet<Character>> boxFreq = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            rowFreq.add(new HashSet<>());
            colFreq.add(new HashSet<>());
            boxFreq.add(new HashSet<>());
        }

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                int boxIndex = (r / 3) * 3 + (c / 3);
                final Character num = board[r][c];

                if (num != '.') {
                    if (!boxFreq.get(boxIndex).add(num) || 
                        !colFreq.get(c).add(num) || 
                        !rowFreq.get(r).add(num)) {
                            return false;
                    }
                }
                
                rowFreq.get(r).add(num);
                colFreq.get(c).add(num);
                boxFreq.get(boxIndex).add(num);
            }
        }

        return true;
    }
}
