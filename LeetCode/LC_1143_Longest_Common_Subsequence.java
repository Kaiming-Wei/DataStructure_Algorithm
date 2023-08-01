class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] c1 = text1.toCharArray();
        char[] c2 = text2.toCharArray();
        int[][] dp = new int[c1.length+1][c2.length+1];
        dpway(c1,c2,dp);
        return dp[0][0];
    }
    // recursive solution
    // public String process(char[] c1, char[] c2, int i, int j){
    //     String str = "";
    //     if(i == c1.length || j == c2.length){
    //         return "";
    //     }else if(c1[i] == c2[j]){
    //         str += c1[i] + process(c1, c2, ++i, ++j);      
    //     }else{
    //         String s1 = process(c1, c2, ++i, j);
    //         String s2 = process(c1, c2, i, ++j);
    //         if(s1.length() > s2.length()){
    //             str += s1;
    //         } else if(s1.length() == s2.length()){
    //             int s1sum = 0, s2sum = 0;
    //             char[] s1ch = s1.toCharArray();
    //             char[] s2ch = s2.toCharArray();
    //             for(int k = 0; k < s1ch.length; k++){
    //                 s1sum += s1ch[k];
    //                 s2sum += s2ch[k];
    //             }
    //             str = s1sum > s2sum ? s1 : s2;
    //         }
    //         else{
    //             str += s2;
    //         }
    //     }
    //     return str;
    // }

    public void dpway(char[] c1, char[] c2, int[][] dp) {
        for(int i = c1.length-1 ; i>=0 ; i--){
            for(int j = c2.length-1; j >= 0; j--){
                if(c1[i] == c2[j]){
                    dp[i][j] = 1 + dp[i+1][j+1];
                }else{
                    int s1 = dp[i+1][j];
                    int s2 = dp[i][j+1];
                    if(s1 > s2){
                        dp[i][j] = s1;
                    }else{
                        dp[i][j] = s2;
                    }
                }
            }
        }
    }
}
