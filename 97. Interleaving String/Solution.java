class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        char[] arr3 = s3.toCharArray();
	    if(arr1.length+arr2.length != arr3.length)
           return false;
        
        Integer[][] dp = new Integer[arr1.length][arr2.length];
        return check(0, 0, 0, arr1, arr2, arr3, dp);
    }

    public boolean check(int i1, int i2, int i3, char[] arr1, char[] arr2, char[] arr3, Integer[][] dp){
        if(i3 >= arr3.length)
          return true;

            Integer val = getFromDp(i1, i2, dp);
            if(val != null){
                return val==1;
            }        
            char ch = arr3[i3];
            boolean b1 = false;
            boolean b2 = false;
            if(i1<arr1.length && ch == arr1[i1]){
                  b1 = check(i1+1, i2, i3+1, arr1, arr2, arr3, dp);
                  setToDp(i1+1, i2, dp, b1);
                  if(b1)
                    return true;
            }

            if(i2<arr2.length && ch == arr2[i2]){
                  b2 = check(i1, i2+1, i3+1, arr1, arr2, arr3, dp);
                  setToDp(i1, i2+1, dp, b2);
                  if(b2)
                    return true;
            }

            return false;
	}

    private Integer getFromDp(int i, int j, Integer[][] dp){
       if(i<dp.length && j<dp[0].length){
          return dp[i][j];
       }
       return null;
    }

    private void setToDp(int i, int j, Integer[][] dp, boolean value){
       if(i<dp.length && j<dp[0].length){
          if(value)
            dp[i][j] = 1;
          else dp[i][j] = 0;
       }
    }
}
