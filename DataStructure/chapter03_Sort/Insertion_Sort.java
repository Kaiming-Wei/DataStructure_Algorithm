package chapter03_Sort;

public class Insertion_Sort {
    public static void swap(int[] arr, int a, int b){
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }

    public static void insertion_Sort(int[] arr){
        for(int i = 1; i < arr.length; i++){

            for(int j = i; j>0 && arr[j-1]>arr[j]; j--){
                swap(arr, j, j-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,3,1,6,7};
        insertion_Sort(arr);
        for(int num : arr){
            System.out.print(num + " ");
        }
    }
}
