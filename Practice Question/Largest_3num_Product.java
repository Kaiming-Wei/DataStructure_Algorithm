import java.util.Arrays;

public class Largest_3num_Product {


    // Find largest product of 3 numbers in an array
    /* 2 types of the array
        1. array contains only positive numbers
            find largest 3 number
        2. array contains positive and negative numbers
            find smallest 2 negative number and largest positive number
    */

    // using sort, O(NlogN)
    public static int product1(int[] num){
        Arrays.sort(num);
        int l = num.length;
        return Math.max(   (num[0] * num[1] * num[l-1]), (num[l-1] * num[l-2] * num[l-3])   );
    }

    // O(N)
    public static int product2(int[] num){
        int smallest = Integer.MAX_VALUE,
                second_small = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE,
                second_large = Integer.MIN_VALUE,
                third_large = Integer.MIN_VALUE;

        for(int x : num){
            // find 2 smallest integers
            if(x < smallest){
                second_small = smallest;
                smallest = x;
            }else if(x < second_small){
                second_small = x;
            }

            // find 3 largest integers
            if(x > largest){
                third_large = second_large;
                second_large = largest;
                largest = x;
            }else if(x > second_large){
                third_large = second_large;
                second_large = x;
            }else if(x > third_large){
                third_large = x;
            }
        }

        return Math.max(  (smallest * second_small * largest), (largest * second_large * third_large)  );

    }

    public static void main(String[] args) {
        int num[] = new int[]{-1,-20,3,4,5};

        System.out.println(product1(num));
    }
}
