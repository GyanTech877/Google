/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

N Queens: Example 1

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens’ placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
*/

public class Solution {
    public ArrayList<ArrayList<String>> solveNQueens(int a) {
        char[][] board = new char[a][a];
        for(int i=0;i<a;i++){
            for(int j=0;j<a;j++){
                board[i][j]='.';
            }
        }
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        backtrack(board,result,0,a);
        return result;
    }
    private void backtrack(char[][] board,ArrayList<ArrayList<String>> result,int col,int N){
        
        if(col==N){
            addToResult(result,board,N);
            return;
        }
        for(int i=0;i<N;i++){
            if(isSafe(board,i,col,N)){
                board[i][col]='Q';
                backtrack(board,result,col+1,N);
                board[i][col]='.';
            }
        }
    }
    private void addToResult(ArrayList<ArrayList<String>> result,char[][] board,int N){
        ArrayList<String> res = new ArrayList<>();
        for(int i=0;i<N;i++){
            StringBuilder curr = new StringBuilder();
            for(int j=0;j<N;j++){
                curr.append(board[i][j]);
            }
            res.add(curr.toString().trim());
        }
        result.add(res);
    }
    private boolean isSafe(char[][] board,int row,int col,int N){
        int i,j;
        for(j=0;j<N;j++){
            if(board[row][j]=='Q') return false;
        }
        for(i=row,j=col; i>=0 && j>=0;i--,j--){
             if(board[i][j]=='Q') return false;
        }
        for(i=row,j=col; i<N && j>=0;i++,j--){
             if(board[i][j]=='Q') return false;
        }
        return true;
    }
}
