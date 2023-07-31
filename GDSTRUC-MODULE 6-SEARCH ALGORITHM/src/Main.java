import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        //sample array
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17};

        //jump value
        int jumpSize = arr.length / 4;

        //declarations and initializations
        Scanner scanner = new Scanner(System.in);
        SequentialJumpSearch jumpSearch = new SequentialJumpSearch();

        //ask for user input
        System.out.println("What number do you want to search for? ");
        //input
        int input = scanner.nextInt();

        //look for index in array
        int index = jumpSearch.jumpSearch(arr, input, jumpSize);

        if (index != -1) {
            System.out.println("Element found at index " + index);
        } else
        {
            System.out.println("Element not found in the array.");
        }
    }
}