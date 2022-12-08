public class DP_Who_Will_Win {

    // giving an array of integer
    // 2 plays can select from left or right
    // who will win the game


    // recursive
    // return the score difference between 2 players
    // player1 score - player2 score
    public static int who_will_win(int[] arr){
        return process(arr,0,arr.length-1);
    }
    private static int process(int[] arr, int left, int right){
        if(left == right){
            return arr[left];
        }
        int select_left_difference = arr[left] -  process(arr, left+1, right); // player2 selected score
        int select_right_difference = arr[right] - process(arr, left, right-1); // player2 selected score
        return Math.max(select_left_difference,select_right_difference);
    }




    // DP
    // using a 2D array to save the data,
    // therefore, no need using recursive stack
    public static int dP(int[] arr){
        int len = arr.length;

        // for this dp array
        // for ex: dp[0][1] == the max score difference between player1 and player2
        // if we need to find dp[1][3]
        // dp[1][3] = max ( arr[1] - dp[2][3] and arr[3] - dp[1][2] )
        int[][] dp = new int[len][len];
        // init
        // dp[1][1] = the difference is arr[1]
        for(int i = 0; i<len; i++){
            dp[i][i] = arr[i];
        }

        for(int left = len-1; left >= 0 ; left--){
            for(int right = left + 1; right < len; right++){
                int select_left_difference = arr[left] - dp[left+1][right];
                int select_right_difference = arr[right] - dp[left][right-1];
                dp[left][right] = Math.max(select_left_difference,select_right_difference);
            }
        }

        return dp[0][len-1];


    }



    //test
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,200,4,7}; // play 1
        int[] arr2 = new int[]{1,200,4,7}; // play 2

        if(dP(arr1) >= 0){
            System.out.println("Player1 wins the game");
        }else{
            System.out.println("Player2 wins the game");
        }
    }
}
