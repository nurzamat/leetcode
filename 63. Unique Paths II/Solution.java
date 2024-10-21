class Solution {
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        return uniqueSum(0, 0, obstacleGrid, dp, m, n);
    }

    private int uniqueSum(int i, int j, int[][] obstacleGrid, int[][] dp, int m, int n){
         if(i >= m || j>= n)
           return 0;
         if(obstacleGrid[i][j] == 1)
            return 0;
         if(i == m-1 && j == n-1)
            return 1;
        if(dp[i][j] > 0)
           return dp[i][j];
        int right = uniqueSum(i, j+1, obstacleGrid, dp, m, n);
        int down = uniqueSum(i+1, j, obstacleGrid, dp, m, n);
        int result = right + down;
        dp[i][j] = result;
        return result;
    }
}