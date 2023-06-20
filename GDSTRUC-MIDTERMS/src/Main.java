import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InterruptedException {

        //User input
        Scanner scanner = new Scanner(System.in);

        //Card Names
        String[] cardNames =
                {
                        "The Magician", "The Fools", "The Empress", "The Emperor", "The Lovers",
                        "Death", "Chariot", "Star", "Moon", "Sun"
                };

        //Deck
        int deckCapacity = 30;
        CardStack deck = new CardStack(deckCapacity);

        //Populate deck
        //get current number of items before push
        int currentNumberOfItems = deckCapacity;
        deck.setNumberOfItems(deckCapacity);

        for (int i = 0; i < deckCapacity; i++)
        {
            //push
            deck.push(new Card(i + 1, cardNames[getRandomNumber(0, 9)]));
        }

        //Discard pile
        CardStack discardPile = new CardStack(30);
        int currentNumberOfItemsInDiscardPile = discardPile.getNumberOfItems();

        //Hand
        CardStack hand = new CardStack(5);
        int currentNumberOfItemsInHand = hand.getNumberOfItems();

        //-------------------------------------------------
        //This marks the beginning of the core loop
        while (!deck.isEmpty())
        {
            //will serve as the random command that will be done each turn
            int randomNumber = getRandomNumber(1, 3);

            //after each round, the following will be displayed:
            //player's hand
            if (hand.isEmpty())
            {
                System.out.println("You have no cards right now. \n");
            }

            System.out.println("You have: " + hand.getNumberOfItems() + " cards.");
            System.out.println("Your cards are: \n");
            hand.printStack();
            System.out.println("");

            //cards left in the deck
            System.out.println("There are " + deck.getNumberOfItems() + " cards left in the deck.");

            //cards in the discard pile
            System.out.println("There are " + discardPile.getNumberOfItems() + " cards left in the discard pile. \n\n");

            //draw x cards from deck
            if (randomNumber == 1)
            {
                System.out.println("---YOU GET TO DRAW CARDS FROM THE DECK!---\n" +
                        "Draw up to 5 cards from the deck,\n" +
                        "How many do you wish to draw: ");

                int numberOfCardsToDraw = scanner.nextInt();

                //if the number of to be drawn cards is greater than the number of items in the deck
                if (numberOfCardsToDraw > deck.getNumberOfItems())
                {
                    System.out.println("You have drawn all the cards. Game has ended");
                    System.exit(0);
                }
                else if (numberOfCardsToDraw > 5)
                {
                    System.out.println("Sorry, but you can only draw up to 5 cards.");
                }
                else
                {
                    //pop cards from the deck based on the numberOfCardsToDraw
                    for (int i = 0; i < numberOfCardsToDraw; i++)
                    {
                        //before popping from the deck, push the top card of the deck to the hand
                        hand.push(deck.peek());
                        deck.pop();
                    }
                    hand.setNumberOfItems(currentNumberOfItemsInHand += numberOfCardsToDraw);
                    deck.setNumberOfItems(currentNumberOfItems -= numberOfCardsToDraw);
                    currentNumberOfItems = deck.getNumberOfItems();
                }

                System.out.println("");
            }

            //discard x cards
            else if (randomNumber == 2)
            {
                System.out.println("---YOU GET TO DISCARD CARDS FROM YOUR HAND!---\n" +
                        "Discard up to 5 cards from your hand,\n" +
                        "How many do you wish to discard: ");

                int numberOfCardsToDiscard = scanner.nextInt();

                if (numberOfCardsToDiscard > hand.getNumberOfItems())
                {
                    System.out.println("Sorry, but there are only " + hand.getNumberOfItems() +
                            " cards left in your hand. Only discard less than or equal to that amount.");
                }
                else
                {
                    //pop cards from the deck based on the numberOfCardsToDraw
                    for (int i = 0; i < numberOfCardsToDiscard; i++)
                    {
                        //before popping from the hand, push the card from the hand into the discard pile
                        discardPile.push(hand.peek());
                        hand.pop();
                    }
                    discardPile.setNumberOfItems(currentNumberOfItemsInDiscardPile += numberOfCardsToDiscard);
                    hand.setNumberOfItems(currentNumberOfItemsInHand -= numberOfCardsToDiscard);
                }

                System.out.println("");
            }

            //draw x cards from discard pile
            else if (randomNumber == 3)
            {
                System.out.println("---YOU GET TO DRAW FROM THE DISCARD PILE!---\n" +
                        "Draw up to 5 cards from the discard pile,\n" +
                        "How many do you wish to draw: ");

                int numberOfCardsToDraw = scanner.nextInt();

                //if the number of cards to draw is greater than the amount of cards in the discard pile
                if (numberOfCardsToDraw > discardPile.getNumberOfItems())
                {
                    System.out.println("Sorry, but there are only " + discardPile.getNumberOfItems() +
                            " cards left in the discard pile. Only draw less than or equal to that amount.");
                }
                else
                {
                    //pop cards from the deck based on the numberOfCardsToDraw
                    for (int i = 0; i < numberOfCardsToDraw; i++)
                    {
                        //before popping from the discard pile, push the card into the hand of the player
                        hand.push(discardPile.peek());
                        discardPile.pop();
                    }
                    hand.setNumberOfItems(currentNumberOfItemsInHand += numberOfCardsToDraw);
                    discardPile.setNumberOfItems(currentNumberOfItemsInDiscardPile -= numberOfCardsToDraw);
                }

                System.out.println("");
            }
        }
    }

    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}