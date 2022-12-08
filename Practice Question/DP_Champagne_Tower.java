public class DP_Champagne_Tower {

    // there is a champagne tower
    // total 100 levels
    // level 1 : 1 glass
    // level 2 : 2 glass
    // level 3 : 3 glass
    // ...

    // giving an integer amount of champagne pour into level 1
    // asking percentage of a particular glass
    // ex:
    // pour 5 glass of champagne into level 1 cup
    // what amount of champagne is in level 3, second cup


    // we know the extra amount of champagne will go to next level same cup# and cup#+1
    // ex:
    // the extra for level 1, glass 1 --> level 2, glass 1 and glass 2
    // level 3, glass 2 --> level 4, glass2, and glass 3

    public static double champagne_Tower(int pour, int level, int glass){
        if(glass > level){
            return 0.0;
        }

        // dp array
        // first[] --> level
        // second [] --> glass
        double[][] dp = new double[100][100];
        dp[0][0] = pour;
        // easier, since we start from 0
        level--;
        glass--;
        for(int curlevel = 0; curlevel<= level; curlevel++){
            for(int curglass = 0; curglass<=curlevel; curglass++){
                if(dp[curlevel][curglass] > 1){
                    double amount = (dp[curlevel][curglass] - 1) / 2;
                    dp[curlevel+1][curglass] += amount;
                    dp[curlevel+1][curglass+1] += amount;
                }
            }
        }


        if(dp[level][glass] >= 1){
            return 1;
        }else{
            return dp[level][glass];
        }
    }




    // test
    public static void main(String[] args) {
        System.out.println(champagne_Tower(5,1,1)); // level 1, glass 1, --> 1.0
        System.out.println(champagne_Tower(5,2,2)); // level 2, glass 1, --> 1.0
        System.out.println(champagne_Tower(5,3,3)); // level 3, glass 3, --> 0.5
        System.out.println(champagne_Tower(5,3,2)); // level 3, glass 2, --> 1.0
    }




}
