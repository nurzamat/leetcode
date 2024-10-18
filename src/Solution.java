public class Solution {

    /* 
    [1,3,1]
    [1,5,1]
    [4,2,1]
    */

    public int minPathSum(int[][] grid) {
        
        if(grid.length == 1 && grid[0].length == 1)
          return grid[0][0];

        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];

        int minPathSum = 0; 
        Integer val1 = null;
        Integer val2 = null;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
              val1 = null;
              val2 = null;
              
              if(i-1>=0)
                 val1 = dp[i-1][j] + grid[i][j];
              if(j-1>=0)
                 val2 = dp[i][j-1] + grid[i][j];
                   
              if(val1 != null && val2 != null)
                 dp[i][j] = Math.min(val1, val2);
              else if(val1 != null)
                 dp[i][j] = val1;
              else if(val2 != null)
                 dp[i][j] = val2;
                 
              minPathSum = dp[i][j];
            }
        }
           
        return minPathSum;
    }
}
