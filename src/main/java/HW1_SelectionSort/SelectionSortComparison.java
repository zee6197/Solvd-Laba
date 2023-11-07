
public class SelectionSortComparison {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide numbers as command-line arguments.");
            return;
        }

        int n = args.length;

        int[] arrayForSelectionSort = new int[n];
        int[] arrayForQuickSort = new int[n];

        for (int i = 0; i < n; i++) {
            arrayForSelectionSort[i] = Integer.parseInt(args[i]);
            arrayForQuickSort[i] = arrayForSelectionSort[i];
        }

        long startTime = System.nanoTime();
        selectionSort(arrayForSelectionSort);
        long endTime = System.nanoTime();
        System.out.println("Selection Sort took: " + (endTime - startTime) + " nanoseconds.");
        System.out.print("Sorted array (Selection Sort): ");
        for (int num : arrayForSelectionSort) {
            System.out.print(num + " ");
        }
        System.out.println();

        startTime = System.nanoTime();
        quickSort(arrayForQuickSort, 0, n - 1);
        endTime = System.nanoTime();
        System.out.println("Quick Sort took: " + (endTime - startTime) + " nanoseconds.");
        System.out.print("Sorted array (Quick Sort): ");
        for (int num : arrayForQuickSort) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIdx = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIdx]) {
                    minIdx = j;
                }
            }

            int temp = array[minIdx];
            array[minIdx] = array[i];
            array[i] = temp;
        }
    }

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }
}
