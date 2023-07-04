import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class ArrayQueue {

    private Player[] queue;
    private int front;
    private int back;

    public int getBack() {
        return back;
    }

    public void setBack(int back) {
        this.back = back;
    }

    public ArrayQueue(int capacity) {
        queue = new Player[capacity];
    }

    //enqueue
    public void enqueue (Player player)
    {
        //resize array
        if (back == queue.length) //stack is full
        {
            //double the size of new stack
            Player[] newQueue = new Player[2 * queue.length];
            System.arraycopy(queue, 0, newQueue, 0, queue.length);
            queue = newQueue;
        }

        //actually pushing
        queue[back] = player;
        back++;
    }

    //dequeue
    public Player dequeue()
    {
        //if stack is empty
        if (size() == 0)
        {
            throw new NoSuchElementException();
        }

        Player removedPlayer = queue[front];
        queue[front] = null;
        front++;

        //reset trackers when queue is empty
        if (size() == 0)
        {
            front =  0;
            back = 0;
        }

        return removedPlayer;
    }

    //peek
    public Player peek()
    {
        //if stack is empty
        if (size() == 0)
        {
            throw new NoSuchElementException();
        }

        return queue[front];
    }

    public int size()
    {
        return back - front;
    }

    //display queue
    public void printQueue()
    {
        for (int i = front; i < back; i++)
        {
            System.out.println(queue[i]);
        }
    }
}
