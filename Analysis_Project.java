import java.util.Arrays;
import java.util.Random;
public class Analysis_Project {

	public static void main(String[] args) {
		
		int array_sizes [] = {
				10, 100, 1000, 10000, 100000, 250000, 500000,
		};
		
			
	
		for(int i = 0; i < array_sizes.length; i++) {
			give_running_times_insertion(array_sizes[i]);
		}
		
		for(int i = 0; i < array_sizes.length; i++) {
			give_running_times_selection(array_sizes[i]);
		}

		for(int i = 0; i < array_sizes.length; i++) {
			give_running_times_merge(array_sizes[i]);
		}
	

	}
	
	static void give_running_times_insertion(int array_size) {
		int array [] = new int [array_size];
		
		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());

		
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(100);
		}
		
		long starttime = System.nanoTime();
		
		insertion_sort(array);
		
		long endtime = System.nanoTime();
		
		long elapsed = endtime - starttime;
		
		
		System.out.printf("Elapsed time for insertion sort for size of %d is %d \n",array_size, elapsed);
	
			
		
	}
	
	
	static void give_running_times_selection(int array_size) {
		int array [] = new int [array_size];
		
		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());

		
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(100);
		}
		
		long starttime = System.nanoTime();
		
		selection_sort(array);
		
		long endtime = System.nanoTime();
		
		long elapsed = endtime - starttime;
		
		
		System.out.printf("Elapsed time for selection sort for size of %d is %d \n",array_size, elapsed);
	
			
		
	}
	
	static void give_running_times_merge(int array_size) {
		int array [] = new int [array_size];
		
		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());

		
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(100);
		}
		
		long starttime = System.nanoTime();
		
		merge_sort(array, 0, array.length - 1);
		
		long endtime = System.nanoTime();
		
		long elapsed = endtime - starttime;
		
		
		System.out.printf("Elapsed time for merge sort for size of %d is %d \n",array_size, elapsed);
	
			
		
	}
	
	
	
	static void insertion_sort(int [] array) {
		 int n = array.length; 
	        for (int i = 1; i < n; ++i) { 
	            int key = array[i]; 
	            int j = i - 1; 
	  
	            while (j >= 0 && array[j] > key) { 
	            	array[j + 1] = array[j]; 
	                j = j - 1; 
	            } 
	            array[j + 1] = key; 
	        } 
	}
	
	static void selection_sort(int [] array) {
		   int n = array.length; 
		   
	        for (int i = 0; i < n-1; i++) 
	        { 
	        
	            int minindex = i; 
	            for (int j = i+1; j < n; j++) {
	            	if (array[j] < array[minindex]) {
	            		minindex = j; 
	                }
	            }
	                    
	            int temp = array[minindex]; 
	            array[minindex] = array[i]; 
	            array[i] = temp; 
	        } 
	}
	
	public static void merge_sort(int [] A, int p, int r)
	{
		int q;

		if (p < r)
		{
			q = (int)Math.floor((p+r)/2);
			merge_sort(A, p, q);
			merge_sort(A, q+1, r);
			merge(A, p, q, r);
		}
	}
	
	
	
	public static void merge(int [] A, int p, int q, int r)
	{
		int n1, n2;
		int i, j;

		n1 = q-p+1;
		n2 = r-q;

		int [] L = new int[n1];
		int [] R = new int[n2];

		for (i = 0; i < n1; i++)
			L[i] = A[p+i];

                for (i = 0; i < n2; i++)
                        R[i] = A[q+i+1];		

		i = 0;
		j = 0;
		
		for (int k=p; k <= r; k++)
		{
			if (i >= n1) 
			{
				A[k] = R[j];
				j++;
				continue;
			}
			
			if (j >= n2) 
			{
				A[k] = L[i];
				i++;
				continue;
			}
	
			if (L[i] <= R[j])
			{
				A[k] = L[i];
				i++;
			}
			else
			{
				A[k] = R[j];
				j++;
			}
		} 
	}	

}
