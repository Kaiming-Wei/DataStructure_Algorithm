package chapter03_Sort;

public class Selection_Sort {
    public static void swap(int[] arr, int a, int b){
        int tem = arr[a];
        arr[a] = arr[b];
        arr[b] = tem;
        // 这里用下面这个swap会出错，不知道为什么！
//        arr[a] = arr[a] ^ arr[b];
//        arr[b] = arr[a] ^ arr[b];
//        arr[a] = arr[a] ^ arr[b];
    }

    public static void Selection_Sort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int min = i;
            for(int j = i + 1; j < arr.length; j++){
                min = arr[j] < arr[min] ? j : min;
            }
            swap(arr, i, min);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,3,1,6,7};
        Selection_Sort(arr);
        for(int num : arr){
            System.out.print(num + " ");
        }
    }
}
