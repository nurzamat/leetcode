
public class Solution {

    public int maximalSquare(char[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        //edge case
        if(m ==1 && n == 1){
           return matrix[0][0] == '1' ? 1 : 0;
        }
        if(m == 1){
           for(char ch: matrix[0]){
               if(ch == '1')
                  return 1;
           }
           return 0;   
        }
    
        if(n == 1){
            for(int i=0; i<m; i++){
                if(matrix[i][0] == '1')
                  return 1;
            }
            return 0;
        }
           

        int[][] dp = new int[m][n];

        int max = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
               if(matrix[i][j]=='1'){
                  if(dp[i][j] == 0)
                     dp[i][j] = 1;
                  if(i-1>=0 && j-1>=0){
                    int up = dp[i-1][j];
                    int left = dp[i][j-1];
                    int diag = dp[i-1][j-1];
                    dp[i][j] = Math.min(Math.min(up, left), diag) + 1; 
                  }
                  if(dp[i][j] > max)
                    max = dp[i][j]; 
               }                         
            }
        }

        return max * max;
    }
}
