public class ArrangeCoins {
    // Giving nth coins
    // arrange them to different rows
    // each row much increase coin number by 1
    /*
        *
        **
        ***
        ****
     */

    // return the maximum number of rows


    // 1.0
    // by iteration
    public static int arrangeCoins1(int n){
        for(int i = 1; i <= n; i++){
            if(n - i <= i){
                return i;
            }
            n -= i;
        }
        return 0;
    }



    // 2.0
    // Binary Search
    // find exact row between 0 - n
    // if that row match exactly the coins, using (1+x)x / 2 = 1+2+3+4+....+x
    public static int arrangeCoins2(int n){
        int low = 0, high = n;
        while(low <= high){
            int mid = (high-low)/2 + low;
            int cost = (1+mid)*mid/2;
            if(cost == n){
                return mid;
            }
            if(cost < n){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return high;
    }



    // 3.0
    // we know that in x row, the total cost of coins = ((1+x)x) /2
    // n >= ((1+x)x) /2
    // 2n >= x + x^2
    // 2n - x >= x^2
    // by using Newton's method to solve the x
    // by Newton's method, for any x, (x+n/x)/2 will approach to exact answer
    // so we can use recursive get closer and closer to real answer
    public static int arrangeCoins3(int n){
        if(n == 0){
            return 0;
        }
        return (int)process(n,n);
    }
    private static double process(double row, int n){
        double ans = (row + (2*n-row)/row)/2;
        if(ans == row){
            return ans;
        }else{
            return process(ans, n);
        }
    }


    // test
    public static void main(String[] args) {
        System.out.println(arrangeCoins1(11));
        System.out.println(arrangeCoins2(11));
        System.out.println(arrangeCoins3(11));
    }
}
