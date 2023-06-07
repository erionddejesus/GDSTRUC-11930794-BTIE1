public class Main {
    public static void main(String[] args) {

        //array
        int numbers[] = new int[10];

        //values of the array
        numbers[0] = 35;
        numbers[1] = 69;
        numbers[2] = 1;
        numbers[3] = 10;
        numbers[4] = -50;
        numbers[5] = 320;
        numbers[6] = 63;
        numbers[7] = 58;
        numbers[8] = 26;
        numbers[9] = 13;

        //NORMAL BUBBLE SORT
        /*
        System.out.println("Before bubble sort: ");
        //print before
        printArrayElements(numbers);

        //sort
        bubbleSort(numbers);

        System.out.println("\n \nAfter bubble sort: ");
        //print after
        printArrayElements(numbers);
        */

        //NORMAL SELECTION SORT
        /*
        System.out.println("Before selection sort: ");
        //print before
        printArrayElements(numbers);

        //sort
        selectionSort(numbers);

        System.out.println("\n \nAfter selection sort: ");
        //print after
        printArrayElements(numbers);
        */

        //DESCENDING BUBBLE SORT
        /*
        System.out.println("Before descending bubble sort: ");
        //print before
        printArrayElements(numbers);

        //sort
        modifiedBubbleSort(numbers);

        System.out.println("\n \nAfter descending bubble sort: ");
        //print after
        printArrayElements(numbers);
        */

        //DESCENDING SELECTION SORT BUT SMALLEST TO THE END
        /*
        System.out.println("Before descending selection sort: ");
        //print before
        printArrayElements(numbers);

        //sort
        modifiedSelectionSort(numbers);

        System.out.println("\n \nAfter descending selection sort: ");
        //print after
        printArrayElements(numbers);
        */

        //SELECTION SORT BUT BIGGEST IN FRONT
        ///*
        System.out.println("Before descending selection sort: ");
        //print before
        printArrayElements(numbers);

        //sort
        secondModifiedSelectionSort(numbers);

        System.out.println("\n \nAfter descending selection sort: ");
        //print after
        printArrayElements(numbers);
        //*/
    }

    //bubble sort method
    private static void bubbleSort(int[] arr)
    {
        for (int lastSortedIndex = arr.length - 1; lastSortedIndex > 0; lastSortedIndex--)
        {
            for (int i = 0; i < lastSortedIndex; i++)
            {
                //compare current value against next value
                if (arr[i] > arr[i + 1])
                {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
    }

    //selection sort method
    private static void selectionSort(int[] arr)
    {
        for (int lastSortedIndex = arr.length - 1; lastSortedIndex > 0; lastSortedIndex--)
        {
            //largest index
            int largestIndex = 0;

            for (int i = 1; i <= lastSortedIndex; i++)
            {
                if (arr[i] > arr[largestIndex])
                {
                    largestIndex = i;
                }
            }
            //sort after going through everything
            int temp = arr[lastSortedIndex];
            arr[lastSortedIndex] = arr[largestIndex];
            arr[largestIndex] = temp;
        }
    }

    //modified bubble sort
    private static void modifiedBubbleSort(int[] arr)
    {
        for (int lastSortedIndex = arr.length - 1; lastSortedIndex > 0; lastSortedIndex--)
        {
            for (int i = 0; i < lastSortedIndex; i++)
            {
                //compare current value against next value
                if (arr[i] < arr[i + 1])
                {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
    }

    //modified selection sort, THIS ONE LOOKS FOR SMALLEST IN DESCENDING ORDER
    private static void modifiedSelectionSort(int[] arr)
    {
        for (int lastSortedIndex = arr.length - 1; lastSortedIndex > 0; lastSortedIndex--) {
            // Smallest index
            int smallestIndex = 0;

            for (int i = 1; i <= lastSortedIndex; i++)
            {

                if (arr[i] < arr[smallestIndex]) {
                    smallestIndex = i;
                }
            }

            // Swap the smallest value (smallestIndex) with the value at the end (lastSortedIndex)
            int temp = arr[lastSortedIndex];
            arr[lastSortedIndex] = arr[smallestIndex];
            arr[smallestIndex] = temp;
        }
    }

    //second modified selection sort in descending order BUT LOOKS FOR BIGGEST AND PLACES IT IN FRONT
    private static void secondModifiedSelectionSort(int[] arr)
    {
        for (int lastSortedIndex = arr.length - 1; lastSortedIndex > 0; lastSortedIndex--)
        {
            //largest index
            int largestIndex = 0;

            for (int i = 1; i <= lastSortedIndex; i++) {

                if (arr[i] < arr[largestIndex]) {
                    largestIndex = i;
                }

                int temp = arr[largestIndex];
                arr[largestIndex] = arr[lastSortedIndex];
                arr[lastSortedIndex] = temp;
            }
        }
    }

    //print contents of the array
    private static void printArrayElements(int[] arr)
    {
        //iterate through array and display current value (j)
        for (int j : arr)
        {
            System.out.print(j + " ");
        }
    }
}