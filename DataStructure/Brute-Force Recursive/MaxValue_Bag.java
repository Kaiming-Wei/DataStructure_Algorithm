public class MaxValue_Bag {
  // Giving 2 arrays, weight and value, each represent an object's weight and value
  // giving a bag that has a size
  // return max value of the bag 
  
  
  // recursive from left to right
  // for each object, selected or not-selected
    public static int maxValue(int[] weight, int[] value, int bagsize){
        return process(weight, value, bagsize, 0, 0);
    }
    private static int process(int[] weight, int[] value, int bagsize, int i, int bag){
        if (i == value.length){
            return 0;
        }
        if(weight[i] + bag <= bagsize){
            int selected = value[i] + process(weight, value, bagsize, i+1, bag+weight[i]);
            int not_selected = process(weight, value, bagsize, i+1, bag);
            return Math.max(selected,not_selected);
        }
        return process(weight, value, bagsize, i+1, bag);
    }
  
  
  // dp 
      public static int dpways(int[] weight, int[] value, int bag){
        int N = weight.length;
        int[][] dp = new int[bag+1][N+1];
        
        //init
        for(int i = 0; i < bag+1; i++){
            dp[i][N] = 0;
        }
        
        for(int index = N-1; index >= 0; index--){
            for(int rest = 0; rest <= bag; rest++){
                if(weight[index] <= rest){
                    int selected = value[index] + dp[ rest - weight[index] ][index+1]; //process(weight, value, rest - weight[index], index+1);
                    int not_selected = dp[rest][index+1];//process(weight, value, rest - weight[index], index+1);
                    dp[rest][index] =  Math.max(selected, not_selected);
                }else{
                    dp[rest][index] = dp[rest][index+1];
                }
            }
        }
        
        return dp[bag][0];
    }
    
    // test
    public static void main(String args[]) {
      int[] weight = new int[]{1,2,3}; 
      int[] value = new int[]{1,52,50}; 
      System.out.println(maxValue(weight, value, 3)); // 53
    }
}
