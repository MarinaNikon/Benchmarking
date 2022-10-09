package ie.gmit.dip;

public class Algorithms {

	/* BubbleSort Code */
	// bubble sort algorithm sorting in descending order
	public static void BubbleSort(int[] intArray) {
		// outer loop
		for (int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) { // count down
			// inner loop
			for (int i = 0; i < lastUnsortedIndex; i++) { // bubble up
				if (intArray[i] > intArray[i + 1]) { // swap if one element is smaller then another
					swap(intArray, i, i + 1); // use swap method to swap
				}
			}
		}
	}

	// swap method
	public static void swap(int[] array, int i, int j) {

		if (i == j) { // no elements to swap
			return;
		}

		int temp = array[i]; // create a temporary int variable
		array[i] = array[j]; // overwrite the value that is at array i
		array[j] = temp; // assign temp to array j
	}

	/* SelectionSort Code*/
	public static void SelectionSort(int intArray[]) {
		// outer loop
		for (int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) { // decrement on each iteration

			int largest = 0; // Initialize the largest index to 0 in the unsorted partition

			// inner loop traverses the unsorted partition and looks for the largest element
			for (int i = 1; i <= lastUnsortedIndex; i++) { // start at 1, because largest is initialized to 0
				if (intArray[i] > intArray[largest]) {
					largest = i;
				}
			}
			swap1(intArray, largest, lastUnsortedIndex); // use swap method to swap
		}

// swap the largest element that we found with the last element in the unsorted partition
		for (int i = 0; i < intArray.length; i++) {
			// System.out.println(intArray[i]);
		}
	}
	// swap method
	public static void swap1(int[] array, int i, int j) {
		if (i == j) { // no elements to swap
			return;
		}

		int temp = array[i]; // create a temporary int variable
		array[i] = array[j]; // overwrite the value that is at array i
		array[j] = temp; // assign temp to array j
	}

	
	/* InsertionSort Code */
	public static void InsertionSort(int intArray[]) {

		// outer loop grows the sorted partition by one
		for (int firstUnsortedIndex = 1; firstUnsortedIndex < intArray.length; firstUnsortedIndex++) {
			// save the value of the element that we will insert into new element
			int newElement = intArray[firstUnsortedIndex];

			// declare i outside the loop, because we need it after the loop
			int i;

			//// inner loop that does the traversal of the sorted partition
			// and looks for the correct position to insert each element
			for (i = firstUnsortedIndex; i > 0 && intArray[i - 1] > newElement; i--) {
				// shift the element at i-1 from left to the right, i.e. make room for new
				// element
				intArray[i] = intArray[i - 1];
			}
			intArray[i] = newElement;
		}
		for (int i = 0; i < intArray.length; i++);
	}

	
	/* ShellSort Code*/
	public static void ShellSort(int intArray[]) {

		// int intArray = arr.length;
		// loop that initialize the gap value and reduce it on each iteration
		for (int gap = intArray.length / 2; gap > 0; gap /= 2) {

			// actual comparing and shifting, i.e. insertion sort
			for (int i = gap; i < intArray.length; i++) {
				// insertion sort
				int newElement = intArray[i];

				int j = i;

				while (j >= gap && intArray[j - gap] > newElement) {
					// shift the element at intArray[j-gap] up gap positions
					intArray[j] = intArray[j - gap];
					// subtract the gap from j to calculate new index
					j -= gap;
				}
				// assign intArray[j] with newElement
				intArray[j] = newElement;
			}
		}
	}

	
	/* Merge Sort Code */
	// merge sort method calls itself recursively
	public static void mergeSort(int[] input, int start, int end) {

		// break out of the recursion
		if (end - start < 2) {
			return;
		}
		// partition phase
		int mid = (start + end) / 2;
		// a merge sort on the left partition
		mergeSort(input, start, mid);
		// a merge sort on the right partition
		mergeSort(input, mid, end);
		// merge the left and right partitions
		merge(input, start, mid, end);
	}

	// Merge method
	public static void merge(int[] input, int start, int mid, int end) {
		// Optimization (if the last element in the left partition is <= the first
		// element
		// in the right partition, then all elements in the left partition are <= then
		// the smallest element
		// in the right partition because both of these arrays are sorted).
		if (input[mid - 1] <= input[mid]) {
			return;
		}

		int i = start;
		int j = mid;
		int tempIndex = 0; // track where we are in the temporary array, when we copy

		// create temporary array
		int[] temp = new int[end - start];
		// compare whatever is at index i in the left array, with whatever is at index
		// j, in the right array
		// and write the smaller of the two into the current position in temp
		while (i < mid && j < end) {
			temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
		}
		// Optimization (handle the remaining elements in the array that are in
		// traverse)
		System.arraycopy(input, i, input, start + tempIndex, mid - i);
		System.arraycopy(temp, 0, input, start, tempIndex);
	}

	
	/* QuickSort Code */
	// quick sort method
	public static void QuickSort(int[] input, int start, int end) {
		if (end - start < 2) {
			return;
		}
		// figure out what will be the index of the pivot, when the array is sorted
		int pivotIndex = partition(input, start, end);
		// quick sort of the left sub-array
		QuickSort(input, start, pivotIndex);
		for (int i = 0; i < input.length; i++) {

		}
		// quick sort of the right sub-array
		QuickSort(input, pivotIndex + 1, end);
	}

	// partition method
	public static int partition(int[] input, int start, int end) {
		// using the first element as the pivot
		int pivot = input[start];
		int i = start;
		int j = end;

		// traversal
		while (i < j) {

			// NOTE: empty loop body
			// use the loop to keep decrementing j until an element that is less then the
			// pivot
			// is found or j crosses i
			while (i < j && input[--j] >= pivot)
				;
			if (i < j) {
				input[i] = input[j];
			}

			// NOTE: empty loop body
			// Traverse the array from left to right,
			// looking for the first element that is greater than the pivot
			while (i < j && input[++i] <= pivot)
				;
			if (i < j) {
				input[j] = input[i]; // the value of j will be the index where the pivot should be inserted
			}
		}

		input[j] = pivot;
		return j;
	}

	
	/* RadixShort Code */
	// RadixSort method
	public static void RadixSort(int[] input, int radix, int width) {
		for (int i = 0; i < width; i++) {
			radixSingleSort(input, i, radix); // call radixSingleSort for each position in the values
		}
	}
	// radixSingleSort method
	public static void radixSingleSort(int[] input, int position, int radix) {

		int numItems = input.length; // it stores how many items will be sorting
		int[] countArray = new int[radix]; // create a countArray array, that is large enough to hold all the possible
											// values

		for (int value : input) { // for every value in the input array
			countArray[getDigit(position, value, radix)]++; // count how many values have a certain digit in any
															// position
		}
		// Adjust the count array (this has to be a stable sort)
		for (int j = 1; j < radix; j++) {
			countArray[j] += countArray[j - 1];
		}

		// copy the values into a temporary array (values are in sorted order)
		int[] temp = new int[numItems];
		for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) { // working from right to left
			temp[--countArray[getDigit(position, input[tempIndex], radix)]] = input[tempIndex];
		}

		// copy values back from the temporary array into the input array
		for (int tempIndex = 0; tempIndex < numItems; tempIndex++) {
			input[tempIndex] = temp[tempIndex];
		}
	}
	// getDigit method
	public static int getDigit(int position, int value, int radix) {
		return value / (int) Math.pow(radix, position) % radix;
	}

	
	/* CountingSort Code */
	public static void CountingSort(int[] input, int min, int max) {
		// Create the counting array (keeping track of the count)
		int[] countArray = new int[(max - min) + 1];

		// counting phase
		// traverse the array and count how many of each value there are
		for (int i = 0; i < input.length; i++) {
			countArray[input[i] - min]++;
		}

		// write the values back into the input array
		int j = 0;
		for (int i = min; i <= max; i++) {
			// traverse the countArray
			while (countArray[i - min] > 0) {
				input[j++] = i;
				countArray[i - min]--;
			}
		}
	}
}
