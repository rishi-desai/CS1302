package cs1302.p2;

import cs1302.adt.StringList;
import cs1302.adt.FancyStringList;
import cs1302.p2.BaseStringList;
import cs1302.adt.Node;

/**
 * A {@code Linked List} implementation using a String list data structure.
 */
public class LinkedStringList extends BaseStringList implements FancyStringList {

    /** the first node in the list. */
    private Node head;

    /**
     * Creates an {@code LinkedStringList} object and initializes {@code head} to be an
     * empty node.
     */
    public LinkedStringList() {
        // calls the parent constructor
        super();
    } // LinkedStringList

    /**
     * Inserts an {@code item} into the Node list at the specified {@code index}
     * position.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public boolean add(int index, String item) {
        boolean add = false;
        if (item == null) {
            throw new NullPointerException();
        } else if (item.length() == 0) {
            throw new IllegalArgumentException();
        } else if (index < 0 || index > super.size()) {
            throw new IndexOutOfBoundsException();
        } else {
            super.size++;
            if (index == 0) {
                Node temp = head;
                head = new Node(item);
                head.setNext(temp);
            } else {
                Node newNode = new Node(item);
                Node temp = head;
                // sets temp to the index directly preceding where we want to add the new item
                for (int i = 0; i < index - 1; i++) {
                    temp = temp.getNext();
                } // for
                newNode.setNext(temp.getNext());
                temp.setNext(newNode);
            } // if
            add = true;
        } // if
        return add;
    } // add

    /**
     * Sets the {@link cs1302.p2.BasedStringList} class {@code size}
     * variable to 0.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        super.size = 0;
        head = null;
    } // clear

    /**
     * Returns the String value at the specified {@code index} position.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public String get(int index) {
        if (index < 0 || index >= super.size()) {
            throw new IndexOutOfBoundsException();
        } // if
        Node temp = head;
        // calls the getNext() method until the specifed index is the current index
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        } // for
        return temp.getItem();
    } // get

    /**
     * Removes the item at the specified {@code index} position in the {@code Linked List}.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public String remove(int index) {
        String remove = "";
        if (index < 0 || index >= super.size()) {
            throw new IndexOutOfBoundsException();
        } else {
            super.size--;
            Node temp = head;
            if (index == 0) {
                remove = temp.getItem();
                head = temp.getNext();
            } else {
                // set temp to the index directly preceding the index being removed
                for (int i = 0; i < index - 1; i++) {
                    temp = temp.getNext();
                } // for
                remove = temp.getNext().getItem();
                temp.setNext(temp.getNext().getNext());
            } // if
        } // if
        return remove;
    } // remove

    /**
     * Returns a new {@code Linked List} that contains the items from the {@code head}
     * node between the specified {@code start} index and {@code stop} index.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public StringList slice(int start, int stop) {
        if (start < 0 || stop > super.size() || start > stop) {
            throw new IndexOutOfBoundsException();
        } // if
        StringList slice = new LinkedStringList();
        int count = 0;
        // uses the add() method to add elements from the list to the new slice variable
        // using the specified start and stop
        for (int i = start; i < stop; i++) {
            slice.add(count, get(i));
            count++;
        } // for
        return slice;
    } // slice

    /**
     * Constructs a string list that is a copy of the other string list.
     *
     * @param other an existing string list object that serves as the source object for the copy.
     * @throws NullPointerException if other is {@code null}.
     */
    public LinkedStringList(StringList other) {
        if (other == null) {
            throw new NullPointerException();
        } else {
            head = new Node(null);
            Node temp = head;
            for (int i = 0; i < other.size(); i++) {
                String obj = other.get(i);
                temp.setNext(new Node(obj, null));
                temp = temp.getNext();
            } // for
        } // if
    } // LikedStringList

    /**
     * Returns a new fancy string list that contains the items from this list in reverse order.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public FancyStringList reverse() {
        // creates a FancyStringList variable that references a LinkedStringList object
        FancyStringList reverse = new LinkedStringList();
        int count = 0;
        // uses the add() method to get the item at the end of the list and add it to the
        // first index of the FancyStringList
        for (int i = super.size() - 1; i >= 0; i--) {
            reverse.add(count, get(i));
            count++;
        } // for
        return reverse;
    } // reverse

    /**
     * Returns a new fancy string list that contains the items from this list between the specified
     * {@code start} index (inclusive) and {@code stop} index (exclusive) by step.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public FancyStringList slice(int start, int stop, int step) {
        if (start < 0 || stop > super.size() || start > stop || step < 1) {
            throw new IndexOutOfBoundsException();
        } // if
        // creates a FancyStringList variable that references a LinkedStringList object
        FancyStringList slice = new LinkedStringList();
        int count = 0;
        int j = start;
        for (int i = start; j  < stop; i++) {
            slice.add(count, get(j));
            count++;
            // changes the index using the formula provided in the FancyStringList API Doc
            j = start + (count * step);
        } // for
        return slice;
    } // slice

} // LinkedStringList
