import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Reverse_Sorted_Sorting{
public static void main(String[] args) {

System.out.println("\nEnter the size of the array: ");
Scanner input  = new Scanner(System.in);
int sizeOfArray  = input .nextInt();
input .close();
int array[] = IntStream.range(1,sizeOfArray+1).toArray();

reverseArray(array);



int merge_arrcopy[] = Arrays.copyOf(array, sizeOfArray  );
int heap_arrcopy[] = Arrays.copyOf(array, sizeOfArray );
int inplacequick_arrcopy[] = Arrays.copyOf(array, sizeOfArray );
int modifiedquick_arrcopy[] = Arrays.copyOf(array, sizeOfArray );

//Calling insertion sort function
System.out.println("<-- Insertion Sort -->");
long insertion_startTime = System.nanoTime();

InsertionSort(array);

long insertion_endTime = System.nanoTime();
System.out.println("    Time taken for execution: "+(insertion_endTime-insertion_startTime));

//Calling merge sort function
System.out.println("<-- Merge Sort -->");
long merge_startTime = System.nanoTime();

performMergeSort(merge_arrcopy,0,merge_arrcopy.length-1);

long merge_endTime = System.nanoTime();
System.out.println("    Time taken for execution: "+(merge_endTime-merge_startTime));

//Calling heap sort function
try {
    // Your array generation and  calls
    System.out.println("<-- Heap Sort -->");
    long heap_StartTime = System.nanoTime();
    
    // Call HeapSort
    HeapSort(heap_arrcopy);
    
    long heap_EndTime = System.nanoTime();
    System.out.println("    Time taken for execution: " + (heap_EndTime - heap_StartTime));

} catch (Exception e) {
    System.out.println("An error occurred during the Heap Sort process: " + e.getMessage());
}

//Calling In place quick sort function
System.out.println("<-- In place Quick Sort -->");
long IPQuick_startTime = System.nanoTime();
InPlaceQuickSort(inplacequick_arrcopy, 0, inplacequick_arrcopy.length-1);
long IPQuick_endTime = System.nanoTime();
System.out.println("    Time taken for execution: "+(IPQuick_endTime-IPQuick_startTime));

//Calling Modified quick sort function
System.out.println("<-- Optimised Quick  Sort -->");
long modQuick_startTime = System.nanoTime();

OptimisedQuickSort(modifiedquick_arrcopy,0,modifiedquick_arrcopy.length-1);

long modQuick_endTime = System.nanoTime();
System.out.println("    Time taken for execution: "+(modQuick_endTime-modQuick_startTime));
}

//function to reverse the sorted array

static void reverseArray(int[] arr) {

int start = 0;

int end = arr.length - 1;

while (start < end) {
  int temp = arr[start];
  arr[start] = arr[end];
  arr[end] = temp;
  start++;
  end--;
}
}

//Insertion Sort implementation
public static void InsertionSort(int[] arr) {
    int length = arr.length;
    
    for (int indexVal = 1; indexVal < length; indexVal++) {
    int elementToInsert = arr[indexVal];
    int pos = indexVal - 1;

    // Move elements of arr[0..i-1], that are greater than key,
    // to one position ahead of their current position
    while (pos >= 0 && arr[pos] > elementToInsert) {
        arr[pos + 1] = arr[pos];
        pos--;
    }
    arr[pos + 1] = elementToInsert;
}
}


// Merge Sort function
public static void performMergeSort(int[] arr, int low, int high) {
if (low < high) {
int midpoint = low + (high - low) / 2;
performMergeSort(arr, low, midpoint);          // Sort the left half
performMergeSort(arr, midpoint + 1, high);     // Sort the right half
mergeArrays(arr, low, midpoint, high);        // Merge the two halves
}
}

// Merge function using a temporary array
public static void mergeArrays(int[] arr, int first, int middle, int last) {
int index1 = middle - first + 1;
int index2 = last - middle;
int[] leftHalf = new int[index1];
int[] rightHalf  = new int[index2];
for (int index = 0; index < index1; index++) {
leftHalf[index] = arr[first + index];
}
for (int j = 0; j < index2; j++) {
rightHalf[j] = arr[middle + 1 + j];
}

// Merge the two halves back into the original array
int leftPos  = 0, rightPos  = 0, mergedIndex = first;
while (leftPos  < index1 && rightPos  < index2) {
if (leftHalf[leftPos ] <= rightHalf[rightPos ]) {                
    arr[mergedIndex] = leftHalf[leftPos ];
    leftPos ++;
} else {
    arr[mergedIndex] = rightHalf[rightPos ];
    rightPos ++;
}
mergedIndex++;
}
while (leftPos  < index1) {
arr[mergedIndex] = leftHalf[leftPos ];
leftPos ++;
mergedIndex++;
}
while (rightPos  < index2) {
arr[mergedIndex] = rightHalf[rightPos ];
rightPos ++;
mergedIndex++;
}
}

// Heap Sort implementation
public static void HeapSort(int[] arr) {
    int length = arr.length;
    for (int posValue = length / 2 - 1; posValue >= 0; posValue--) {
        buildHeap(arr, length, posValue);
}
for (int indexValue1 = length - 1; indexValue1 >= 0; indexValue1--) {
    exchange(arr, 0, indexValue1);
    buildHeap(arr, indexValue1, 0);
}
}

// Function to maintain max-heap property
private static void buildHeap(int[] arr, int size, int i) {
int largest = i;  // Initialize largest as root
int left = 2 * i + 1;  // Left child index
int right = 2 * i + 2;  // Right child index
if (left < size && arr[left] > arr[largest]) {
    largest = left;
}
if (right < size && arr[right] > arr[largest]) {
    largest = right;
}
if (largest != i) {
    exchange(arr, i, largest);
    buildHeap(arr, size, largest);  // Recursively heapify the affected subtree
}
}   

// Helper method to exchange two elements in the array
private static void exchange(int[] arr, int firstVal, int secondVal) {

int temp = arr[firstVal];
arr[firstVal] = arr[secondVal];
arr[secondVal] = temp;
}

//In Place Quick Sort implementation
public static void InPlaceQuickSort(int arr[], int low, int high ){
    while (low < high) {
        int pivot = partition(arr, low, high);
        if (pivot - low < high - pivot) {
            InPlaceQuickSort(arr, low, pivot - 1);
            low = pivot + 1;
        } else {
            InPlaceQuickSort(arr, pivot + 1, high);
            high = pivot - 1;
        }
    }
}

// Partition function for in-place QuickSort
public static int partition(int[] arr, int l, int h) {
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


//Optimised Quick Sort implenentation
public static void OptimisedQuickSort(int[] arr, int low, int high) {
if (high - low + 1 <= 8) {
    // Use insertion sort for small sub-problems (size <= 8)
    enhancedQuickInsertionSort(arr, low, high);
} else {
    // Use median-of-three to choose the pivot
    int pivotIndex = MedianOfThreeNumbers(arr, low, high);
    int pivotNewIndex = optimisedpartition(arr, low, high, pivotIndex);
    
    // Recursively apply Quicksort to left and right partitions
    OptimisedQuickSort(arr, low, pivotNewIndex - 1);
    OptimisedQuickSort(arr, pivotNewIndex + 1, high);
}
}

//function to find the median of three
public static int MedianOfThreeNumbers(int[] arr, int front, int rear) {
int middle = front + (rear - front) / 2;

if (arr[front] > arr[middle]) {
    opt_swap(arr, front, middle);
}
if (arr[front] > arr[rear]) {
    opt_swap(arr, front, rear);
}
if (arr[middle] > arr[rear]) {
    opt_swap(arr, middle, rear);
}

// Return the index of the median (which is now at mid)
return middle;
}
public static void opt_swap(int[] arr, int i, int j) {
int temp = arr[i];
arr[i] = arr[j];
arr[j] = temp;
}
//partition function for optimised quicksort
public static int optimisedpartition(int[] arr, int low, int high, int pivotIndex) {
int pivot = arr[pivotIndex];
opt_swap(arr, pivotIndex, high); // Move pivot to the end
int i = low;

for (int currentIndex  = low; currentIndex  < high; currentIndex ++) {
    if (arr[currentIndex ] < pivot) {
        opt_swap(arr, i, currentIndex );
        i++;
    }
}
opt_swap(arr, i, high); // Move pivot to its final place
return i;
}

//insertion sort function for modified quick sort
public static void enhancedQuickInsertionSort(int[] arr, int begin, int finish) {
for (int currentVal = begin + 1; currentVal <= finish; currentVal++) {
    int currentNumber = arr[currentVal];
    int j = currentVal - 1;
    while (j >= begin && arr[j] > currentNumber) {
        arr[j + 1] = arr[j];
        j--;
    }
    arr[j + 1] = currentNumber;
}
}

}




