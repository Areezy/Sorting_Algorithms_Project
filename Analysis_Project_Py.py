import random
import time
def insertion_sort(array):    
    for i in range(1, len(array)):   
        key = array[i] 
        j = i-1
        while j >= 0 and array[j] > key: 
                array[j + 1] = array[j] 
                j -= 1
        array[j + 1] = key 

def selection_sort(array):
    for i in range(len(array)): 
        minindex = i 
        for j in range(i+1, len(array)): 
            if array[minindex] > array[j]: 
                minindex = j 
                     
        array[i], array[minindex] = array[minindex], array[i] 

def merge_sort(array):
    if len(array) > 1:
 
        
        mid = len(array)//2
 
       
        L = array[:mid]
 
       
        R = array[mid:]
 
        
        merge_sort(L)
 
        
        merge_sort(R)
 
        i = j = k = 0
 
        
        while i < len(L) and j < len(R):
            if L[i] < R[j]:
                array[k] = L[i]
                i += 1
            else:
                array[k] = R[j]
                j += 1
            k += 1
 
        
        while i < len(L):
            array[k] = L[i]
            i += 1
            k += 1
 
        while j < len(R):
            array[k] = R[j]
            j += 1
            k += 1


def give_running_times_insertion(array_size):
    array = []
    for i in range(0, array_size):
        array.append(random.randint(1, 100))
    
    start = time.time_ns()
    insertion_sort(array)
    end = time.time_ns()
    elapsed = end - start
    print(f"Elapsed time for insertion sort for size of {array_size} is {elapsed} \n")


def give_running_times_selection(array_size):
    array = []
    for i in range(0, array_size):
        array.append(random.randint(1, 100))
    
    start = time.time_ns()
    selection_sort(array)
    end = time.time_ns()
    elapsed = end - start
    print(f"Elapsed time for selection sort for size of {array_size} is {elapsed} \n")

def give_running_times_merge(array_size):
    array = []
    for i in range(0, array_size):
        array.append(random.randint(1, 100))

    start = time.time_ns()
    merge_sort(array)
    end = time.time_ns()
    elapsed = end - start
    print(f"Elapsed time for merge sort for size of {array_size} is {elapsed} \n")


array_sizes = [
				10, 100, 500, 1000, 10000, 20000, 30000
]

for i in array_sizes:
    give_running_times_merge(i)


		