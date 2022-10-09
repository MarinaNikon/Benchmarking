package ie.gmit.dip;

/**
 * 
 * @author G00398315
 *
 */

public class Runner extends Algorithms {
	/* Benchmark code */ 
	public static double benchmark(String sort, int[] arr) {
		// Each sort is measured for how long it takes to execute in nanoseconds
		// Switch statement
		long start = System.nanoTime();//Starting to measure time, source: lectures of D.Carr
		switch (sort) {
		case "BubbleSort":
			BubbleSort(arr);
			break; // program breaks out of switch once the matched statement is executed 
			//and continues execution at the statement following switch
		case "SelectionSort":
			SelectionSort(arr);
			break;
		case "InsertionSort":
			InsertionSort(arr);
			break;
		case "ShellSort":
			ShellSort(arr);
			break;
		case "MergeSort":
			mergeSort(arr, 0, arr.length);
			break;
		case "QuickSort":
			QuickSort(arr, 0, arr.length);
			break;
		case "RadixSort":
			RadixSort(arr, 10, 4);
			break;
		case "CountingSort":
			CountingSort(arr, 0, arr.length);
			break;
		default:
			break;
		}
		
		long end = System.nanoTime(); // Ending to measure time, source: lectures of D.Carr notes 
		long elapsed = end - start; // Get the difference of time, source: lectures of D.Carr 
		double time = elapsed / 1000000.0; // Convert from nanoseconds to milliseconds, source: lectures of D.Carr 
		return time;
	}

	// Create a random integer array of size n 
	// Source: lectures of D.Carr 
	public static int[] randomArray(int n) {
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = (int) (Math.random() * 100);
		}
		return array;
	}

	public static void main(String[] args) {
		double samplesize = 10.0f;
		// benchmark sample sizes  
		int sizes[] = { 100, 250, 500, 750, 1000, 1250, 2500, 3750, 5000, 6250, 7500, 8750, 10000 };
		String sorts[] = { "BubbleSort", "SelectionSort", "InsertionSort", "ShellSort", "MergeSort", "QuickSort",
				"RadixSort", "CountingSort" };
		// print heading
		System.out.println("\t\t\t\t\tThe running time (in milliseconds)\r");
		System.out.format("%-15s", "Size");
		for (int s = 0; s < sizes.length; s++) {
			System.out.format("%-11s", sizes[s]);
		}

		System.out.println();
		// Print average time in the form of table 
		for (int i = 0; i < sorts.length; i++) {
			System.out.format("%-15s", sorts[i]);
			for (int j = 0; j < sizes.length; j++) {
				double runtime = 0.0f;
				for (int n = 0; n < samplesize; n++) {
					runtime += benchmark(sorts[i], randomArray(sizes[j]));
				}
				double avg = runtime / samplesize;
				System.out.format("%-11s", (String.format("%.3f", avg)));
			}
			System.out.println();
		}
	}
}
