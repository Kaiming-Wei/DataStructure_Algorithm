public class FibNumber {
    // Find nth Fibonacci number



    // 1.0 recursive solution
    // O(2^N)
    public static int fib1(int n){
        if(n == 1){
            return 0;
        }
        if(n == 2){
            return 1;
        }
        return fib1(n-1) + fib1(n-2);
    }


    // 2.0
    // an improvement for the recursive solution
    // we save the fibonacci numbers into an array
    // so each fib num only calculate once --> O(N), space C. = O(N)
    public static int fib2(int n){
        int[] fib = new int[n + 2]; // ignore the index[0], index[1] = 1st fib number, index[2] = 2nd fib number...
        return process(fib, n);
    }
    private static int process(int[] fib, int n){
        if(n == 1){
            return 0;
        }
        if(n == 2){
            return 1;
        }
        if(fib[n+1] != 0){
            return fib[n+1];
        }
        fib[n+1] = process(fib, n-1) + process(fib, n-2);
        return fib[n+1];
    }




    // 3.0 double pointer --> O(N)
    public static int fib3(int n){
        if(n == 1){
            return 0;
        }
        if(n == 2){
            return 1;
        }
        int first = 0,
                second = 1;
        for(int i = 3; i <= n; i++){
            int ans = first + second;
            first = second;
            second = ans;
        }
        return second;
    }


    // test
    public static void main(String[] args) {
        System.out.println(fib1(11));
        System.out.println(fib2(11));
        System.out.println(fib3(11));
    }
}
