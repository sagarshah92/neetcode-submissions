class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        Map<String, Set<Character>> map = new HashMap<>();

        for (int row = 0; row < board.length; row++){
            for (int col =0; col<board[0].length; col++){
                if (!Character.isDigit(board[row][col])){
                    continue;
                }
                // small grid check
                String gridId = getGridNumber(row, col);
                
                map.putIfAbsent("R"+row, new HashSet<>());
                map.putIfAbsent("C"+col, new HashSet<>());
                map.putIfAbsent("G"+gridId, new HashSet<>());

                // row check
                if ( map.get("R"+row).contains(board[row][col])){
                    return false;
                }
                // col check
                if (map.get("C"+col).contains(board[row][col])){
                    return false;
                }
                
                if (map.get("G"+gridId).contains(board[row][col])){
                    return false;
                }
                map.get("R"+row).add(board[row][col]);
                map.get("C"+col).add(board[row][col]);
                map.get("G"+gridId).add(board[row][col]);
                
            }
        }
        return true;
    }

    public String getGridNumber(int row, int col){
        StringBuilder sb = new StringBuilder();

        // for row
        if (row>=0 && row<=2){
            sb.append("0");
        } else if (row>2 && row<=5){
            sb.append("1");
        } else {
            sb.append("3");
        }

        // for Col
        if (col>=0 && col<=2){
            sb.append("0");
        } else if (col>2 && col<=5){
            sb.append("1");
        } else {
            sb.append("3");
        }

        return sb.toString();
    }
}
