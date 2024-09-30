# Sorting Algorithm Implementations

This repository contains multiple Java programs that implement and compare the performance of different sorting algorithms. The main goal is to analyze the behavior of various sorting methods under different scenarios, including randomized arrays, reverse-sorted arrays, and already sorted arrays.

## Programs Included

1. **Ranking_algorithms.java**: Implements and ranks sorting algorithms, including optimized or modified quicksort, insertion sort, and median-of-three quicksort.
2. **Reverse_Sorted_Sorting.java**: Tests the performance of sorting algorithms on reverse-sorted arrays.
3. **Sorted_Array.java**: Tests sorting algorithms on pre-sorted arrays to evaluate their best-case performance.

## Features

- **Random Array Generation**: Generates arrays filled with random integers for testing purposes.
- **Sorting Algorithms**: Includes various sorting algorithms such as:
  - **Insertion Sort**
  - **Merge Sort**
  - **Heap Sort**
  - **Quick Sort**
  - **Optimized Quick Sort with Median-of-Three Pivoting**
  - **Modified Quick Sort with Insertion Sort for small arrays**
- **Performance Analysis**: Each program measures and displays the execution time for each sorting algorithm.

## Usage

1. Clone or download the repository.
2. Open the `.java` files in your favorite Java IDE.
3. Run each program to test sorting on different array types (random, reverse-sorted, sorted).
4. Enter the array size when prompted.

### Input

Each program will prompt you to specify the size of the array to be sorted.

Enter the size of the array:
50000

### Output

The program will output the execution time of each sorting algorithm in nanoseconds for the given input array.

Enter the size of the array:
100000

<-- Insertion Sort -->

Time taken for execution: 5661709900

<-- Merge Sort -->

Time taken for execution: 16705000

<-- Heap Sort -->

Time taken for execution: 21961800

<-- In place Quick Sort -->

Time taken for execution: 12089900

<-- Optimised Quick Sort -->

Time taken for execution: 17688200

## Sorting Algorithms Explained

### Insertion Sort

A straightforward, comparison-based technique that incrementally constructs a sorted array by processing one element at a time. Ideal for smaller datasets or nearly sorted input.

### Merge Sort

An algorithm based on the divide-and-conquer paradigm, which recursively breaks the array into sub-arrays, sorts them, and then combines the sorted sub-arrays back together.

### Heap Sort

A sorting algorithm that leverages a binary heap structure to organize elements through comparisons and extract the sorted sequence.

### Quick Sort

A divide-and-conquer method that selects a pivot element and partitions the array into two segments based on the pivot, recursively sorting both parts.

### Optimized Quick Sort with Median-of-Three Pivoting

An enhanced variant of Quick Sort, where the pivot is chosen as the median of the first, middle, and last array elements, minimizing the chances of worst-case performance.

### Modified Quick Sort with Insertion Sort

A hybrid approach where Quick Sort is employed, but switches to Insertion Sort for smaller segments to improve efficiency on limited-sized datasets.

## Files Overview

### Ranking_algorithms.java

- This file includes the ranking and comparison of different sorting algorithms based on their execution times.
- Optimized sorting techniques like the median-of-three pivot quicksort are implemented here.

### Reverse_Sorted_Sorting.java

- Focuses on analyzing the performance of sorting algorithms on reverse-sorted arrays (worst-case scenario for many sorting algorithms).

### Sorted_Array.java

- Tests the performance of sorting algorithms on already sorted arrays to measure best-case efficiency.

## How to Run

1. Ensure you have JDK installed.
2. Compile the Java files:
   ```bash
   javac Ranking_algorithms.java Reverse_Sorted_Sorting.java Sorted_Array.java
   ```
3. Run the Java programs:
   
   java Ranking_algorithms
   
   java Reverse_Sorted_Sorting
   
   java Sorted_Array
