import java.util.EmptyStackException;

public class CardStack {
    private Card[] stack;
    private int top;
    public int numberOfItems;

    //constructor
    public CardStack (int capacity)
    {
        stack = new Card[capacity];
    }

    //getter and setter for numberOfItems;
    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    //push
    public void push (Card card)
    {
        //resize array
        if (top == stack.length) //stack is full
        {
            //double the size of new stack
            Card[] newStack = new Card[2 * stack.length];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        }

        //actually pushing
        stack[top++] = card;
    }

    //pop
    public Card pop()
    {
        //if stack is empty
        if (isEmpty())
        {
            //System.exit(0);
            throw new EmptyStackException();
        }

        Card poppedCard = stack[--top];
        stack[top] = null;
        setNumberOfItems(numberOfItems--);
        return poppedCard;
    }

    //peak
    public Card peek()
    {
        //if stack is empty
        if (isEmpty())
        {
            throw new EmptyStackException();
        }

        //returns the value at the top of the stack
        return stack[top - 1];
    }

    //bool to check if stack is empty
    public boolean isEmpty()
    {
        return top == 0;
    }

    //print function to display contents of stack
    public void printStack()
    {
        for (int i = top - 1; i >= 0; i--)
        {
            System.out.println(stack[i]);
        }
    }
}
