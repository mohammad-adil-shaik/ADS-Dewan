import matplotlib.pyplot as plt

# Input sizes
sizes = [1000, 2000, 3000, 4000, 5000, 10000, 20000, 40000, 50000, 60000, 80000, 90000, 100000]

# Example times for each sorting algorithm (replace with actual data from Java output)
insertion_sort_times = [112066,
224633,
339300,
444333,
494966,
993333,
2034233,
4072933,
4824266,
5710066,
7254200,
7822600,
7632166

]
merge_sort_times = [1419600,
1842800,
2552200,
2508966,
2951633,
5093733,
8935133,
16790433,
27814433,
28127200,
33004100,
39895600,
43081966

]
heap_sort_times = [1175733,
1921666,
2739500,
3037966,
3921033,
6457866,
15627400,
29186000,
32491166,
29176000,
30301366,
34822366,
47985633

]
Inplace_quicksort_times=[9629400,
23978466,
19465243,
54552400,
57359133,
84675866,
191669633,
541261133,
881819666,
1240308566,
2332722366,
2962329866,
3817157533

]
Modified_quicksort_times=[954733,
1756166,
3105333,
2951033,
2837500,
4323000,
7701200,
14170400,
19221166,
21701133,
28494333,
32058633,
36240833

]
# Plotting
plt.plot(sizes, insertion_sort_times, label='Insertion Sort')
plt.plot(sizes, merge_sort_times, label='Merge Sort')
plt.plot(sizes, heap_sort_times, label='Heap Sort')
plt.plot(sizes, Inplace_quicksort_times ,label='inplace quick sort')
plt.plot(sizes,  Modified_quicksort_times ,label='Modified quick  sort')
plt.xlabel('Input Size')
plt.ylabel('Execution Time (ns)')
plt.title('Sorting Algorithm Performance')
plt.legend()
plt.show()