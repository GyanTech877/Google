/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

You need to do this in place.

Note that if you end up using an additional array, you will only receive partial score.

Example:

If the array is

[
    [1, 2],
    [3, 4]
]
Then the rotated array becomes:

[
    [3, 1],
    [4, 2]
]
*/

class Solution {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length ==0) return;
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int end = m-1;
        while(start<end){
          for(int j=0;j<n;j++){
              int temp = matrix[start][j];
              matrix[start][j] = matrix[end][j];
              matrix[end][j] = temp;
            }
            start++;
            end--;
          }
         for(int i=0;i<m;i++){
            for(int j=i+1;j<n;j++){
              int temp = matrix[i][j];
              matrix[i][j] = matrix[j][i];
              matrix[j][i] = temp;
            }
         }
    }
}
