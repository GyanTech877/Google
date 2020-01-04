/*
Determine if a Sudoku is valid, according to: http://sudoku.com.au/TheRules.aspx

The Sudoku board could be partially filled, where empty cells are filled with the character ‘.’.



The input corresponding to the above configuration :

["53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"]
A partially filled sudoku which is valid.

 Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
Return 0 / 1 ( 0 for false, 1 for true ) for this problem
*/

public class Solution {
    public int isValidSudoku(final String[] A) {
        if(A==null || A.length ==0) return 0;
        char[][] input = new char[9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                input[i][j]=A[i].charAt(j);
            }
        }
        for(int i=0;i<9;i++) {
            Set<Character> rowSet = new HashSet<>();
            Set<Character> columnSet = new HashSet<>();
            Set<Character> cubeSet = new HashSet<>();
            int row = 3 * (i/3);
            int column = 3 * (i%3);
            
            for(int j=0;j<9;j++){
                if(input[i][j]!='.' && !rowSet.add(input[i][j])) return 0;
                if(input[j][i]!='.' && !columnSet.add(input[j][i])) return 0;
                if(input[row+j/3][column+j%3]!='.' && !cubeSet.add(input[row+j/3][column+j%3])) return 0;
            }
        }
        return 1;
    }
}
