public class PrimeNumber {
    // Giving an integer n
    // Find how many prime numbers are between 0~n


    // 1. BF solution
    // iteration --> O(n^2)
    public static int prime1(int n){
        int count = 0;
        for(int i = 2; i <= n; i++){
            if(isPrime(i)){
                count++;
            }
        }
        return count;
    }

    private static boolean isPrime(int n){
        for(int i = 2; i < n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }


    // 2.solution
    // We know that for each non-prime number, it's factor must include a prime,
    // so we take each prime number we found and do the multiplication, and marks every result as non-prime
    public static int prime2(int n){
        boolean[] non_prime = new boolean[n + 1];
        int count = 0;
        for(int i = 2; i <= n; i++){
            if(non_prime[i] == false){
                count++;
                for(int j = i * i; j <= n; j += i){
                    non_prime[j] = true;
                }
            }
        }
        return count;
    }

    //test
    public static void main(String[] args) {
        System.out.println(prime1(100));
        System.out.println(prime2(100));
    }
}
