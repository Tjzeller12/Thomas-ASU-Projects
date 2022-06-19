//**************************************************************************************************
// CLASS: DList<E> (DList.java)
//
// AUTHOR
// Kevin R. Burger (burgerk@asu.edu)
// Computer Science & Engineering Program
// Fulton Schools of Engineering
// Arizona State University, Tempe, AZ 85287-8809
//
// (c) 2018 Kevin R Burger
//**************************************************************************************************
package p04;

/**
 * Implements a generic doubly linked list where the type of each
 * element is E.
 */
public class DList<E> {

    /**
     * For a nonempty DList, mHead is a reference to the first Node
     * in the DList. For an empty DList, mHead will be null.
     */
    private Node<E> mHead;

    /**
     * The number of Nodes containing data in this DList. For an
     * empty DList mSize is 0.
     */
    private int mSize;

    /**
     * For a nonempty DList mTail is a reference to the last Node in
     * the DList. For an empty DList, mTail will be null.
     */
    private Node<E> mTail;

    /**
     * Creates an empty DList. For an empty DList, mHead = null,
     * mTail = null, and mSize = 0.
     */
    public DList() {
        setHead(null);
        setTail(null);
        setSize(0);
    }

    /**
     * Creates a new DList with one element containing pData.
     */
    public DList(E pData) {
        // Create a new Node storing pData. Make the mPrev and mNext references null.
        Node<E> newNode = new Node<E>(pData);

        // Make the mHead reference refer to the new node.
        setHead(newNode);

        // Make the mTail reference refer to the new node.
        setTail(newNode);

        // The size of the list is now 1.
        setSize(1);
    }

    /**
     * Inserts a new Node containing pData into this DList at index
     * pIndex. Shifts the element currently at that index (if it
     * exists) and succeeding elements to the right (i.e., adds one
     * to their indices).
     *
     * Note that if pIndex == getSize() then new element is appended
     * to the list.
     *
     * Throws an IndexOutOfBoundsException if pIndex < 0 or pIndex >
     * size of the DList.
     */
    public void add(int pIndex, E pData) throws IndexOutOfBoundsException {
        // Check for pIndex out of bounds.
        if (pIndex < 0 || pIndex > getSize()) {
            throw new IndexOutOfBoundsException();
        }

        // Are we appending?
        if (pIndex == getSize()) {
            // Create a new Node storing pData. The mNext reference is initialized to null because
            // the new Node will become the tail Node of the DList and the mNext reference of the
            // tail Node is always null. The mPrev reference is initialized to mTail so it will
            // refer to the Node preceding the new Node.
            Node<E> newNode = new Node<E>(pData, getTail(), null);

            // If this DList is empty the new Node becomes the head Node. Otherwise change mNext of
            // the tail Node to refer to the new Node.
            if (isEmpty()) {
                setHead(newNode);
            } else {
                getTail().setNext(newNode);
            }

            // In any case, we must change mTail to refer to the new Node that is now at the tail.
            setTail(newNode);
        } // We are not appending.
        else {
            // Get a reference to the Node at pIndex. We are inserting a new Node before 'node'.
            Node<E> node = getNodeAt(pIndex);

            // Create a new Node storing pData. Set the mPrev reference of the new Node to refer to
            // the Node preceding 'node'. Set the mNext reference of the new Node to refer to
            // 'node'.
            Node<E> newNode = new Node<E>(pData, node.getPrev(), node);

            // If we are not inserting at pIndex = 0 then we need to change the mNext reference of
            // the Node preceding 'node' to refer to the new Node.
            if (pIndex != 0) {
                node.getPrev().setNext(newNode);
            }

            // Make the mPrev reference of 'node' refer to the new Node. The result of these three
            // operations is to "link" the the new Node into the DList.
            node.setPrev(newNode);

            // Are we inserting at index 0? If so, we need to change the head to refer to the new
            // Node because the new Node is now at head.
            if (pIndex == 0) {
                setHead(newNode);
            }
        }

        // We have added a new Node to the DList. Increment the size of the DList.
        setSize(getSize() + 1);
    }

    /**
     * Appends a new Node storing pData to this DList. Note that
     * passing an index of getSize() to add(int pIndex, E pData) will
     * cause add() to perform an append operation.
     */
    public void append(E pData) {
        add(getSize(), pData);
    }

    /**
     * Removes all of the elements from the DList. After this
     * operation the DList will be empty.
     */
    public void clear() {
        // To clear the list is simple. Simply remove the node at index 0 until the list becomes
        // empty.
        while (!isEmpty()) {
            remove(0);
        }
    }

    public DList<E> clone() {
        DList<E> cloneList = new DList<E>();
        Node<E> traverse = getHead();
        while (traverse != null) {
            cloneList.append(traverse.getData());
            traverse = traverse.getNext();
        }
        return cloneList;
    }

    /**
     * Returns the element at index pIndex.
     *
     * Thows IndexOutOfBoundsException if pIndex < 0 or pIndex >=
     * mSize.
     */
    public E get(int pIndex) throws IndexOutOfBoundsException {
        return getNodeAt(pIndex).getData();
    }

    /**
     * Accessor method for the mHead field.
     */
    protected Node<E> getHead() {
        return mHead;
    }

    /**
     * Returns a reference to the Node at index pIndex.
     *
     * Thows IndexOutOfBoundsException if pIndex < 0 or pIndex >=
     * getSize()
     */
    protected Node<E> getNodeAt(int pIndex) throws IndexOutOfBoundsException {
        // Check for pIndex out of bounds and throw exception is necessary.
        if (pIndex < 0 || pIndex >= getSize()) {
            throw new IndexOutOfBoundsException();
        }

        // Since accessing the head and tail nodes is a common operation we check for those cases
        // first.
        if (pIndex == 0) {
            return getHead();
        } else if (pIndex == getSize() - 1) {
            return getTail();
        }

        // Otherwise, start at the node at index 1 and walk forward until the node at index pIndex
        // is reached and then return it.
        Node<E> node = getHead().getNext();
        for (int index = 1; index < pIndex; ++index) {
            node = node.getNext();
        }
        return node;
    }

    /**
     * Accessor method for the mSize field.
     */
    public int getSize() {
        return mSize;
    }

    /**
     * Accessor method for the mTail field.
     */
    protected Node<E> getTail() {
        return mTail;
    }

    /**
     * Returns true if this DList is empty.
     */
    public boolean isEmpty() {
        return getSize() == 0;
    }

    /**
     * Prepends a new Node storing pData to this DList.
     */
    public void prepend(E pData) {
        add(0, pData);
    }

    /**
     * Removes the element at index pIndex from this DList. Shifts
     * any succeeding elements to the left (i.e., subtracts one from
     * their indices). Returns the element that was removed from the
     * list.
     *
     * Throws an IndexOutOfBoundsException is pIndex < 0 || pIndex >=
     * getSize().
     */
    public E remove(int pIndex) throws IndexOutOfBoundsException {
        Node<E> node = getNodeAt(pIndex);

        // Are we removing the only element in a list with one element?
        if (getSize() == 1) {
            setHead(null);
            setTail(null);
        } // Else are we removing the head node in a list with more than one element (note: we will
        // not get here if the list has only one element)?
        else if (pIndex == 0) {
            // Change the prev reference of the next node to null because the next node will now
            // be the head node in the list.
            node.getNext().setPrev(null);

            // Since we removed the head node, we have to change the head reference to refer to the
            // next node succeeding the one that was just removed.
            setHead(node.getNext());
        } // Else are we removing the tail node in a list with more than one element (note: we will
        // not get here if the list has only one element)?
        else if (pIndex == getSize() - 1) {
            // Change the next reference of the previous node to null because the previous node will
            // now be the tail node in the list.
            node.getPrev().setNext(null);

            // Since we removed the tail node, we have to change the tail reference to refer to the
            // previous node preceding the one that was just removed.
            setTail(node.getPrev());
        } // We are not removing the head or tail node.
        else {
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
        }

        // We have removed a Node so decrement the size of the list.
        setSize(getSize() - 1);

        // Return the data stored at the removed Node.
        return node.getData();
    }

    /**
     * Replaces the element at the specified position in this list
     * with the specified element. Returns the element that was
     * previously stored at pIndex.
     */
    public E set(int pIndex, E pData) throws IndexOutOfBoundsException {
        Node<E> node = getNodeAt(pIndex);
        E original = node.getData();
        node.setData(pData);
        return original;
    }

    /**
     * Mutator method for the mHead field.
     */
    protected void setHead(Node<E> pHead) {
        mHead = pHead;
    }

    /**
     * Mutator method for the mSize field.
     */
    protected void setSize(int pSize) {
        mSize = pSize;
    }

    /**
     * Mutator method for the mTail field.
     */
    protected void setTail(Node<E> pTail) {
        mTail = pTail;
    }

    /**
     * Returns a string representation of this DList where we define
     * string representation be the string representation of each of
     * the Nodes.
     */
    @Override
    public String toString() {
        String string = "";
        int i;
        for (i = 0; i < getSize() - 1; ++i) {
            string += get(i) + " ";
        }
        if (!isEmpty()) {
            string += get(i);
        }
        return string;
    }

    //**********************************************************************************************
    // Static Nested Class: Node
    //**********************************************************************************************
    /**
     * The data for each element of the DList is stored in a Node
     * object. A Node object contains three instance variables: (1)
     * mData is a reference to the data stored in the Node; (2) mNext
     * is a reference to the succeeding Node in the DList; and (3)
     * mPrev is a reference to the preceding Node in the DList.
     *
     * @param <E Note that Node is declared as protected so it is not
     * visible to other classes but it is accessible to subclasses of
     * DList.
     */
    protected static class Node<E> {

        /**
         * The data stored in this Node.
         */
        E mData;

        /**
         * A reference to the succeeding Node in the DList.
         */
        Node<E> mNext;

        /**
         * A reference to the preceding Node in the DList.
         */
        Node<E> mPrev;

        /**
         * Creates a new Node storing no data and with mNext and
         * mPrev set to null.
         */
        public Node() {
            this(null);
        }

        /**
         * Creates a new Node storing
         *
         * @param pData as the data and with mNext and mPrev set to
         * null.
         */
        public Node(E pData) {
            setData(pData);
            setNext(null);
            setPrev(null);
        }

        /**
         * Creates a new Node storing
         *
         * @param pData as the data, mPrev initialized to
         * @param pPrev, and mNext initialized to
         * @param pNext.
         */
        public Node(E pData, Node<E> pPrev, Node<E> pNext) {
            setData(pData);
            setPrev(pPrev);
            setNext(pNext);
        }

        /**
         * Returns true if this Node and pNode are equal to each
         * other where equal is defined as:
         *
         * 1. this Node cannot be null because if it were we would
         * not have been able to call the equals() method on it.
         * However, pNode might be null and if it is then clearly
         * this Node and pNode are not equal so we return false. 2.
         * If the address of this Node and pNode are the same then
         * they are the same object so they are clearly equal to each
         * other so we return true. 3. If this Node and pNode are
         * objects of different classes then they cannot be equal so
         * we return false. 4. If the instance variables of this Node
         * are equal to the instance variables of pNode then the two
         * objects are considered equal so return true. 5. Otherwise,
         * returns false.
         *
         * Also, the parameter object to equals() has to be of type
         * Object because we are over- riding the equals() method
         * declared in Object and for Object.equals() the paramemter
         * is an Object. However, we need to call the getData(),
         * getNext(), and getPrev() methods on pNode and we cannot do
         * that if the JVM thinks that pNode is an Object.
         *
         * @param pNode Consequently we must type case pNode to be a
         * Node<E>. Unfortunately, if you compile with the -Xlint
         * option you will get an "unchecked cast" warning on the
         * line where we declare node and type cast pNode to Node<E>.
         * For reasons I have not taken the time to fully understand
         * it is difficult to make this warning go away so a quick
         * and easy and sleazy way to eliminate the warning is to
         * provide a
         * @SuppressWarnings("unchecked") attribute which tells the
         * compiler not to complain about this uncheck cast.
         *
         * See: https://javaranch.com/journal/2002/10/equalhash.html
         */
        @Override
        @SuppressWarnings("unchecked")
        public boolean equals(Object pNode) {
            Node<E> node = (Node<E>) pNode;
            // Check condition 1.
            if (node == null) {
                return false;
            }

            // Check condition 2.
            if (this == node) {
                return true;
            }

            // Check condition 3.
            if (this.getClass() != node.getClass()) {
                return false;
            }

            // Check condition 4.
            if (getData() == node.getData() && getNext() == node.getNext()
                    && getPrev() == node.getPrev()) {
                return true;
            }

            // Condition 5.
            return false;
        }

        /**
         * See:
         * https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html#hashCode()
         * See:
         * https://www.javaworld.com/article/2073618/java-s-system-identityhashcode.html
         *
         * @return
         */
        @Override
        public int hashCode() {
            return System.identityHashCode(this);
        }

        /**
         * @return getData Accessor method for the mData instance
         * variable.
         */
        public E getData() {
            return mData;
        }

        /**
         * @return getNext Accessor method for the mNext instance
         * variable.
         */
        public Node<E> getNext() {
            return mNext;
        }

        /**
         * @return getPrev Accessor method for the mPrev instance
         * variable.
         */
        public Node<E> getPrev() {
            return mPrev;
        }

        /**
         * @param pData Mutator method for the mData instance
         * variable.
         */
        public void setData(E pData) {
            mData = pData;
        }

        /**
         * @param pNext Mutator method for the mNext instance
         * variable.
         */
        public void setNext(Node<E> pNext) {
            mNext = pNext;
        }

        /**
         * @param pPrev Mutator method for the mPrev instance
         * variable.
         */
        public void setPrev(Node<E> pPrev) {
            mPrev = pPrev;
        }

        /**
         * Returns a string representation of this Node where we
         * define the string representation to be the string
         * representation of the data stored in this Node.
         */
        @Override
        public String toString() {
            return "" + getData();
        }
    }
}
