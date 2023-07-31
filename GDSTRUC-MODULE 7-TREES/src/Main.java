import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {

        //scanner
        Scanner scanner = new Scanner(System.in);

        //tree
        Tree tree = new Tree();

        //inserting values
        tree.insert(25);
        tree.insert(17);
        tree.insert(-11);
        tree.insert(100);
        tree.insert(16);
        tree.insert(-5);
        tree.insert(60);
        tree.insert(55);

        //display data
        System.out.println("Values in order: ");
        tree.traverseInOrder();

        //get value
        System.out.println();
        System.out.println("What value do you want to find? ");

        int input = scanner.nextInt();
        System.out.println(tree.get(input));

        //get lowest value
        System.out.println();
        System.out.println("Lowest value: " + tree.getMinimum());

        //get highest value
        System.out.println("Highest value: " + tree.getMaximum());

        //traverse in order descending
        System.out.println();
        System.out.println("Values in descending order: ");
        tree.traverseInOrderDescending();
    }
}