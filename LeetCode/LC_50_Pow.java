class Solution {
    public double myPow(double x, int n) {
        int sign = n;
        if(sign < 0){
            sign *=-1;
        }
        double ans = calculator(x, sign);
        System.out.println(ans);
        if(n >= 0){
            return ans;
        }else{
            return 1/ans;
        }
    }

    public double calculator(double x, int n){
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return x;
        }
        double ans = calculator(x,  n/2);
        if(n % 2 == 0){
            return ans * ans;
        }else{
            return x * ans * ans;
        }
    }
}
