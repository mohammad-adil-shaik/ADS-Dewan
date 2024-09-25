import time
import random
import matplotlib.pyplot as plt

# Insertion Sort
def insertion_sort(arr):
    for i in range(1, len(arr)):
        key = arr[i]
        j = i - 1
        while j >= 0 and key < arr[j]:
            arr[j + 1] = arr[j]
            j -= 1
        arr[j + 1] = key

# Merge Sort
def merge_sort(arr):
    if len(arr) > 1:
        mid = len(arr) // 2
        left = arr[:mid]
        right = arr[mid:]

        merge_sort(left)
        merge_sort(right)

        i = j = k = 0

        while i < len(left) and j < len(right):
            if left[i] < right[j]:
                arr[k] = left[i]
                i += 1
            else:
                arr[k] = right[j]
                j += 1
            k += 1

        while i < len(left):
            arr[k] = left[i]
            i += 1
            k += 1

        while j < len(right):
            arr[k] = right[j]
            j += 1
            k += 1

# Heap Sort
def heapify(arr, n, i):
    largest = i
    left = 2 * i + 1
    right = 2 * i + 2

    if left < n and arr[i] < arr[left]:
        largest = left

    if right < n and arr[largest] < arr[right]:
        largest = right

    if largest != i:
        arr[i], arr[largest] = arr[largest], arr[i]
        heapify(arr, n, largest)

def heap_sort(arr):
    n = len(arr)

    for i in range(n // 2 - 1, -1, -1):
        heapify(arr, n, i)

    for i in range(n - 1, 0, -1):
        arr[i], arr[0] = arr[0], arr[i]
        heapify(arr, i, 0)

# Quicksort
def quicksort(arr, low, high):
    if low < high:
        pi = partition(arr, low, high)
        quicksort(arr, low, pi - 1)
        quicksort(arr, pi + 1, high)

def partition(arr, low, high):
    pivot = arr[high]
    i = low - 1
    for j in range(low, high):
        if arr[j] <= pivot:
            i += 1
            arr[i], arr[j] = arr[j], arr[i]
    arr[i + 1], arr[high] = arr[high], arr[i + 1]
    return i + 1

# Modified Quicksort (Median-of-three + insertion sort for small subproblems)
def modified_quicksort(arr, low, high):
    if high - low + 1 <= 10:
        insertion_sort(arr[low:high+1])
    else:
        if low < high:
            pi = median_of_three_partition(arr, low, high)
            modified_quicksort(arr, low, pi - 1)
            modified_quicksort(arr, pi + 1, high)

def median_of_three_partition(arr, low, high):
    mid = (low + high) // 2
    pivot = sorted([arr[low], arr[mid], arr[high]])[1]
    return partition(arr, low, high)

# Random data generation and performance measurement
def generate_data(size):
    return [random.randint(1, 100000) for _ in range(size)]

def measure_time(sort_function, arr):
    start_time = time.time()
    sort_function(arr)
    return time.time() - start_time

# Plotting function
def plot_results(input_sizes, timings, algorithms):
    for i, time_data in enumerate(timings):
        plt.plot(input_sizes, time_data, label=algorithms[i])
    plt.xlabel('Input size')
    plt.ylabel('Time (seconds)')
    plt.title('Sorting Algorithm Performance Comparison')
    plt.legend()
    plt.show()

# Main execution
input_sizes = [1000, 2000, 5000, 10000, 20000, 50000, 100000]
algorithms = ['Insertion Sort', 'Merge Sort', 'Heap Sort', 'Quick Sort', 'Modified Quick Sort']
timings = []

for size in input_sizes:
    data = generate_data(size)
    
    # Measure each algorithm
    timings.append([measure_time(insertion_sort, data.copy()),
                    measure_time(merge_sort, data.copy()),
                    measure_time(heap_sort, data.copy()),
                    measure_time(lambda arr: quicksort(arr, 0, len(arr)-1), data.copy()),
                    measure_time(lambda arr: modified_quicksort(arr, 0, len(arr)-1), data.copy())])

# Plot results
plot_results(input_sizes, timings, algorithms)
