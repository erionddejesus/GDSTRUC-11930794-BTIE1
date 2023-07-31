public class Tree {

    private Node root;

    public void insert (int value)
    {
        if (root == null)
        {
            root = new Node(value);
        }
        else
        {
            root.insert(value);
        }
    }

    public void traverseInOrder()
    {
        if (root != null) {
            root.traverseInOrder();
        }
    }

    public void traverseInOrderDescending()
    {
        if (root != null) {
            root.traverseInOrderDescending();
        }
    }

    public Node get(int value)
    {
        if (root != null)
        {
            return root.get(value);
        }
        return null;
    }

    //get lowest value
    public int getMinimum() {
        if (root != null) {
            Node current = root;
            while (current.getLeftChild() != null) {
                current = current.getLeftChild();
            }
            return current.getData();
        }
        return 0;
    }

    //get highest value
    public int getMaximum() {
        if (root != null) {
            Node current = root;
            while (current.getRightChild() != null) {
                current = current.getRightChild();
            }
            return current.getData();
        }

        return 0;
    }
}
