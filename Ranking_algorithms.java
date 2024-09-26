
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class Ranking_algorithms {
    public static void main(String[] args) {

        System.out.println("Enter the size of the array: ");
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        sc.close();

        int array[] = generateRandomArray(l);

        int merge_arrcopy[] = Arrays.copyOf(array, l);
        int heap_arrcopy[] = Arrays.copyOf(array, l);
        int inplacequick_arrcopy[] = Arrays.copyOf(array, l);
        int modifiedquick_arrcopy[] = Arrays.copyOf(array, l);

        //Calling insertion sort function
        System.out.println("Insertion sort");
        long insertion_startTime = System.nanoTime();
        
        InsertionSort(array);
        
        long insertion_endTime = System.nanoTime();
        System.out.println("Execution time: "+(insertion_endTime-insertion_startTime));

        //Calling merge sort function
        System.out.println("Merge sort");
        long merge_startTime = System.nanoTime();
        
        MergeSort(merge_arrcopy,0,merge_arrcopy.length-1);
        
        long merge_endTime = System.nanoTime();
        System.out.println("Execution time: "+(merge_endTime-merge_startTime));

        //Calling heap sort function
        try {
            // Your array generation and sorting calls
            System.out.println("Heap sort");
            long heap_startTime = System.nanoTime();
            
            // Call HeapSort
            HeapSort(heap_arrcopy);
            
            long heap_endTime = System.nanoTime();
            System.out.println("Execution time: " + (heap_endTime - heap_startTime));
    
        } catch (Exception e) {
            System.out.println("An error occurred during Heap Sort: " + e.getMessage());
        }
        //Calling In place quick sort function
        System.out.println("In place quick sort");
        long IPQuick_startTime = System.nanoTime();
        InPlaceQuickSort(inplacequick_arrcopy, 0, inplacequick_arrcopy.length-1);
        long IPQuick_endTime = System.nanoTime();
        System.out.println("Execution time: "+(IPQuick_endTime-IPQuick_startTime));

        //Calling Modified quick sort function
        System.out.println("Modified quick  sort");
        long modQuick_startTime = System.nanoTime();
        
        ModifiedQuickSort(modifiedquick_arrcopy,0,modifiedquick_arrcopy.length-1);
        
        long modQuick_endTime = System.nanoTime();
        System.out.println("Execution time: "+(modQuick_endTime-modQuick_startTime));
    }

    //Insertion Sort implementation
    public static void InsertionSort(int arr[]){
        int n = arr.length;
        for(int i=0;i<=n-1;i++){
            int j=i;
            while(j>0 && arr[j-1] > arr[j]){
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }

    //Merge Sort implementation
    public static void MergeSort(int arr[], int low, int high){
        if (low<high){
            int mid = (low+high)/2;
            MergeSort(arr,low,mid);
            MergeSort(arr, mid+1, high);
            Merge(arr,low,mid,high);
        }
    }

    //Merge function
    public static void Merge(int[] arr, int low, int mid, int high){
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid+1;

        while(left<=mid && right<=high){
            if(arr[left] <=arr[right]){
                temp.add(arr[left]);
                left++;
            }
            else{
                temp.add(arr[right]);
                right++;
            }
        }
        while (left<=mid){
            temp.add(arr[left]);
            left++;
        }
        while (right<=high){
            temp.add(arr[right]);
            right++;
        }
        for(int i=low;i<=high;i++){
            arr[i] = temp.get(i-low);
        }
    }

    //Heap Sort implementation
    public static void HeapSort(int[] arr) throws Exception {
        Heap<Integer> heap = new Heap<>();

        for (int value : arr) {
            heap.insert(value);
        }
    
        for (int i = 0; i < arr.length; i++) {
            arr[i] = heap.remove();
        }
    }
        
    static class Heap<T extends Comparable<T>> {
        private Vector<T> list;

        public Heap() {
            list = new Vector<>();
        }

        private void swap(int first, int second) {
            T temp = list.get(first);
            list.set(first, list.get(second));
            list.set(second, temp);
        }

        private int parent(int index) {
            return (index - 1) / 2;
        }

        private int left(int index) {
            return index * 2 + 1;
        }

        private int right(int index) {
            return index * 2 + 2;
        }

        public void insert(T value) {
            list.add(value);
            upheap(list.size() - 1);
        }

        private void upheap(int index) {
            if (index == 0) {
                return;
            }
            int p = parent(index);
            if (list.get(index).compareTo(list.get(p)) < 0) {
                swap(index, p);
                upheap(p);
            }
        }

        public T remove() throws Exception {
            if (list.isEmpty()) {
                throw new Exception("Removing from an empty heap!");
            }

            T temp = list.get(0); 

            T last = list.remove(list.size() - 1);
            if (!list.isEmpty()) {
                list.set(0, last); 
                downheap(0); 
            }

            return temp; 
        }

        private void downheap(int index) {
            int min = index;
            int left = left(index);
            int right = right(index);

            if (left < list.size() && list.get(min).compareTo(list.get(left)) > 0) {
                min = left;
            }

            if (right < list.size() && list.get(min).compareTo(list.get(right)) > 0) {
                min = right;
            }

            if (min != index) {
                swap(min, index);
                downheap(min);
            }
        }
    }

    //In Place Quick Sort implementation
    public static void InPlaceQuickSort(int arr[], int l, int h){
        if(l < h){
            int pivot = partition(l,h,arr);
            InPlaceQuickSort(arr, l, pivot-1);
            InPlaceQuickSort(arr, pivot+1, h);
        }
    }

    //partition function for in place quick sort
    public static int partition(int l, int h, int[] arr){
        int pivot = arr[h];
        int i = (l-1);
        for(int j=l; j<h; j++){
            if(arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[h];
        arr[h] = temp;
        return i+1;
    }

    public static void swap(int a, int b){
        int temp = a;
        a = b;
        b = temp;
    }

    //Modified Quick Sort implenentation
    public static void ModifiedQuickSort(int[] arr, int low, int high) {
        if (high - low + 1 <= 8) {
            // Use insertion sort for small sub-problems (size <= 8)
            insertionSort_ModQuick(arr, low, high);
        } else {
            // Use median-of-three to choose the pivot
            int pivotIndex = median(arr, low, high);
            int pivotNewIndex = modifiedpartition(arr, low, high, pivotIndex);
            
            // Recursively apply Quicksort to left and right partitions
            ModifiedQuickSort(arr, low, pivotNewIndex - 1);
            ModifiedQuickSort(arr, pivotNewIndex + 1, high);
        }
    }

    //function to find the median of three
    public static int median(int[] arr, int low, int high) {
        int mid = low + (high - low) / 2;
        
        if (arr[low] > arr[mid]) {
            mod_swap(arr, low, mid);
        }
        if (arr[low] > arr[high]) {
            mod_swap(arr, low, high);
        }
        if (arr[mid] > arr[high]) {
            mod_swap(arr, mid, high);
        }
        
        // Return the index of the median (which is now at mid)
        return mid;
    }
    public static void mod_swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    //partition function for modified quicksort
    public static int modifiedpartition(int[] arr, int low, int high, int pivotIndex) {
        int pivot = arr[pivotIndex];
        mod_swap(arr, pivotIndex, high); // Move pivot to the end
        int i = low;
        
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                mod_swap(arr, i, j);
                i++;
            }
        }
        mod_swap(arr, i, high); // Move pivot to its final place
        return i;
    }

    //insertion sort function for modified quick sort
    public static void insertionSort_ModQuick(int[] arr, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= low && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    //function to generate array with random integers
    public static int[] generateRandomArray(int size) {
        java.util.Random random = new java.util.Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(size);
        }
        return arr;
    }   

}
