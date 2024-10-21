class Solution {
    public String longestPalindrome(String s) {
        if(s == null)
           return null;
        char[] arr = s.toCharArray();
        int length = arr.length;

        if(length == 1)
           return s;
        if(length == 2 && arr[0]==arr[1])
           return s;
        int[][] dp = new int[length][length];

        // fill dp
        for(int i=1; i<length-1; i++){
          if(arr[i-1] == arr[i+1])
             dp[i-1][i+1] = 1;
          if(arr[i] == arr[i+1])
             dp[i][i+1] = 1;
          if(arr[i] == arr[i-1])
             dp[i-1][i] = 1;
        }

        // process dp
        for(int i=0; i<length; i++){
            for(int j=0; j<length; j++){
               if(dp[i][j] == 1){
                  for(int k=1; k<length; k++){
                      if(j+k < length && i-k>=0 && arr[j+k] == arr[i-k])
                         dp[i-1][j+k] = 1;
                      else break;
                  }
               }
            }
        }
        int start = 0;
        int end = 0;
        for(int i=0; i<length; i++){
            for(int j=0; j<length; j++){
               if(dp[i][j] == 1 && j-i>end-start){
                  start = i;
                  end = j;
               }
            }
        }

        return s.substring(start, end+1);
    }

    
}