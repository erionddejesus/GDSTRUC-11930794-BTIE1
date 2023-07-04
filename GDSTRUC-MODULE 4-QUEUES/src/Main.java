import java.util.Random;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        //scanner
        Scanner scanner = new Scanner(System.in);

        //array queue
        ArrayQueue queue = new ArrayQueue(5);

        //array string of random names
        String[] playerNames =
                {
                        "Sir G", "Doc B", "Sir Normz", "Sir Ralph", "Sir Dale",
                        "Sir Kevin", "Sir Abet", "Sir David", "Sir Jao", "Sir Felix"
                };

        //number of successfully queued games
        int success = 0;
        //when playersToBeQueued is less than 5, the players will be carried over
        //next iteration, so we need a total variable to keep track
        int totalPlayersToBeQueued = 0;

        while (success < 10)
        {
            //the amount of players to queue
            int playersToBeQueued = getRandomNumber(1, 7);
            totalPlayersToBeQueued += playersToBeQueued;

            //text
            System.out.println("----- WELCOME TO MATCHMAKING -----\n");
            for (int i = 0; i < playersToBeQueued; i++)
            {
                queue.enqueue(new Player(queue.getBack(), playerNames[getRandomNumber(0, 9)]));
            }

            //current queue
            System.out.println("Number of successful matches made: " + success + "\n");
            System.out.println("There are currently: " + totalPlayersToBeQueued + " people in queue." + "\n");
            System.out.println("They are: ");
            queue.printQueue();
            System.out.println("");


            //a game can be started if there are at least 5 players in the queue
            if (totalPlayersToBeQueued >= 5)
            {
                System.out.println("There are 5 or more people ready. GAME WILL START.\n");
                success++;

                //dequeue first 5 people
                for (int i = 0; i < 5; i++)
                {
                    queue.dequeue();
                }

                //reset totalPlayersToBeQueued
                totalPlayersToBeQueued = totalPlayersToBeQueued - 5;

                System.out.println("Press ENTER to continue.\n");
                scanner.nextLine();
            }
            else
            {
                System.out.println("Not enough players in queue.");
                System.out.println("Press ENTER to continue.\n");
                scanner.nextLine();
            }
        }
    }

    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}

