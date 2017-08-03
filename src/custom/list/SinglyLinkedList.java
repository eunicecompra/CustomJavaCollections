package custom.list;

import java.util.NoSuchElementException;

public class SinglyLinkedList {

    private Node headNode;
    private int size;

    /**
     * Appends the specified element to the end of this list.
     * @param value - element to be appended to this list
     * @return true
     */
    public boolean add(int value) {
        if ( headNode == null ) { //Empty list
            headNode = new Node(value,null);
        } else {
            Node newNode = new Node(value,null);
            Node tailNode = headNode;
            while ( tailNode.getNextNode() != null ) {
                tailNode = tailNode.getNextNode();
            }
            tailNode.setNextNode(newNode);
        }

        size++;

        return true;
    }

    /**
     * Removes and returns the last element from the list
     * @return the last element from the list
     * @throws NoSuchElementException if this list is empty
     */
    public int removeTail() throws NoSuchElementException {
        int removedValue = 0;

        if ( headNode == null ) { //Empty list!
            throw new NoSuchElementException();
        } else {
            Node tmpNode = headNode;
            Node beforeTailNode = headNode;
            while ( tmpNode.getNextNode() != null ) {
                beforeTailNode = tmpNode;
                tmpNode = tmpNode.getNextNode();
            }
            if ( beforeTailNode == headNode ) {
                removedValue = headNode.getValue();
                headNode = null; //Now the list is empty
            } else {
                removedValue = tmpNode.getValue();
                beforeTailNode.setNextNode(null); //The new tail
            }
        }

        size--;

        return removedValue;
    }

    /**
     * Removes and returns the elements larger than the passed targetValue from the list
     * @return the number of elements removed
      */
    public int removeLargerValues(int targetValue) {
        int removedElementsCtr = 0;

        Node tmpNode = headNode;
        Node beforeNode = null;
        while ( tmpNode != null ) {
            if (tmpNode.getValue() > targetValue) {
                if ( beforeNode != null ) {
                    beforeNode.setNextNode(tmpNode.getNextNode());
                } else {
                    headNode = tmpNode.getNextNode();
                }
                removedElementsCtr++;
                size--;
            } else {
                beforeNode = tmpNode;
            }
            tmpNode = tmpNode.getNextNode();
        }

        return removedElementsCtr;
    }

    public int getSize() {
        return size;
    }

    public String toString() {
        Node tmpNode = headNode;
        StringBuilder strElements = new StringBuilder();
        strElements.append("[");
        while ( tmpNode != null ) {
            strElements.append(tmpNode.getValue());
            tmpNode = tmpNode.getNextNode();
            if ( tmpNode != null ) strElements.append(", ");
        }
        strElements.append("]");

        return strElements.toString();
    }

    private class Node {

        private int value;
        private Node nextNode;

        public Node() {

        }

        public Node(int value, Node nextNode) {
            this.value = value;
            this.nextNode = nextNode;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }
    }
}
