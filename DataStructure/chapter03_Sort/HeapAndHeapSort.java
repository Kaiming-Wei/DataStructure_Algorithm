package chapter03_Sort;

public class HeapAndHeapSort {
    private int[] heap;
    private int heapsize = 0;
    private int arrsize = 0;
    private final int limit;

    public HeapAndHeapSort(int limit) {
        heap = new int[limit];
        this.limit = limit;
    }
    private int parent(int index){
        return (index-1)/2;
    }
    private int leftchild(int index){
        return (2*index)+1;
    }
    private int rightchild(int index){
        return leftchild(index)+1;
    }
    private boolean isLeaf(int index){
        if(rightchild(index) < heapsize || leftchild(index) < heapsize){
            return false;
        }else{
            return true;
        }
    }

    private void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public void push(int data){
        if(heapsize == limit){
            System.out.println("heap is full, can't push");
            return;
        }
        heap[heapsize] = data;
        heapInsert(heap, heapsize++);
        arrsize++;
    }

    public void heapInsert(int[] arr, int heapsize){
        while ( arr[parent(heapsize)] < arr[heapsize] ){
            swap(arr, parent(heapsize), heapsize);
            heapsize = parent(heapsize);
        }
    }

    public void heapify(int index){
        while (!isLeaf(index)){
            int large = leftchild(index);
            if(rightchild(index) < heapsize && heap[rightchild(index)] > heap[large]){
                large = rightchild(index);
            }
            if(heap[index] > heap[large]){
                large = index;
            }
            if(index == large){
                break;
            }
            swap(heap, index, large);
            index=large;
        }
    }

    public int pop(){
        int ans = heap[0];
        swap(heap, 0, --heapsize);
        heapify(0);
        arrsize--;
        return ans;
    }
    public void printHeap(){
        for(int i=0; i<heapsize;i++){
            System.out.print(heap[i]+"\t");
        }
        System.out.println();
    }
    public void print(){
        for(int i=0; i<arrsize;i++){
            System.out.print(heap[i]+"\t");
        }
        System.out.println();
    }

    public void heapSort(){
        while (heapsize != 0){
            swap(heap,0, --heapsize);
            heapify(0);
        }
    }


    public static void main(String[] args) {
        HeapAndHeapSort myheap = new HeapAndHeapSort(99);
        myheap.push(5);
        myheap.push(0);
        myheap.push(69);
        myheap.push(13);
        myheap.push(1);
        System.out.println(myheap.pop());
        myheap.printHeap();
        System.out.println("--------------");
        myheap.heapSort();
        myheap.print();
    }
}
