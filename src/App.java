public class App {
    
    public static int[][] exampleVariableOne = new int[10][5];
    // returns the length of the rows in the array
    public static int lengthOne = exampleVariableOne.length;
    // returns the length of the columns in the array
    public static int lengthTwo = exampleVariableOne[0].length;
      
    public static void main(String[] args) throws Exception {
        //System.out.println(lengthOne);
        //System.out.println(lengthTwo);

        int[][] grid = {{1,3,1}, {1,5,1}, {4,2,1}};
        //grid =[[9,1,4,8]]

        Solution solution = new Solution();
        System.out.println(solution.minPathSum(grid));
    }
}
