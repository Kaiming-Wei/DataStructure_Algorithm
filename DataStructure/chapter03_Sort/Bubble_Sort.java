package chapter03_Sort;

public class Bubble_Sort {
    public static void swap(int[] arr, int a, int b){
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }

    public static void Bubble_Sort(int[] arr){
        int n = arr.length-1;

        for(int i = 0; i <= n; i++){
            // 把 array 里面每个数字和它后面的那个比较， 如果大， 换位子，这样最后一个数字一定是最大的
            for(int j = 0; j < n; j++){
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                }
            }
            n--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,3,1,6,7};
        Bubble_Sort(arr);
        for(int num : arr){
            System.out.println(num);
        }
    }
}
