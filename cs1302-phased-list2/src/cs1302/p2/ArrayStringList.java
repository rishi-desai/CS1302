package cs1302.p2;

import cs1302.adt.StringList;
import cs1302.adt.FancyStringList;
import cs1302.p2.BaseStringList;

/**
 * A {@code Array List} implementation using a String list data structure.
 */
public class ArrayStringList extends BaseStringList implements FancyStringList {

    /** The items string array. */
    private String[] items;

    /**
     * Creates an {@code ArrayStringList} object and initializes {@code items} to be an array of
     * size 4.
     */
    public ArrayStringList() {
        // calls the parent constructor
        super();
        items = new String[4];
    } // BaseStringList

    /**
     * Inserts an {@code item} into the array list at the specified {@code index}
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
            // check if the array is full and creates a bigger array if it is
            if (super.size == items.length) {
                newItemsArray();
            } // if
            if (items[index] == null) {
                items[index] = item;
            } else {
                String[] tempItems = new String[items.length];
                // copies items from index 0 to the new index of the item
                for (int i = 0; i < index; i++) {
                    tempItems[i] = items[i];
                } // for
                // adds new item to specified index
                tempItems[index] = item;
                // copies items after new item to end of array
                for (int i = index + 1; i < items.length; i++) {
                    tempItems[i] = items[i - 1];
                } // for
                items = tempItems;
            } // if
            add = true;
        } // if
        return add;
    } // add

    /**
     * If the {@code items} array is full this method creates a new array
     * that is the size of the previous {@code items} array plus 3 more indices.
     * The old {@code items} array is then copied over to the new {@code items}
     * array and then 3 extra indices are added.
     */
    public void newItemsArray() {
        // creates a temporary items array
        String[] tempItems = new String[super.size() + 3];
        // copies item from orginal items array into temporary items array
        for (int i = 0; i < items.length; i++) {
            tempItems[i] = items[i];
        } // for
        // sets instance variable array to temporary array
        items = tempItems;
    } // newItemsArray

    /**
     * Removes all the items from the {@code items} array and sets the length to 0.
     * Then changes the {@link cs1302.p2.BasedStringList} {@code size} variable to 0.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        items = new String[0];
        super.size = 0;
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
        return items[index];
    } // get

    /**
     * Removes the item at the specified {@code index} position in the {@code Array List}.
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
            remove = items[index];
            // any items after the removed string are shifted left
            for (int i = index; i < super.size(); i++) {
                items[i] = items[i + 1];
            } // for
        } // if
        return remove;
    } // remove

    /**
     * Returns a new {@code Array List} that contains the items from the {@code items} list
     * between the specified {@code start} index and {@code stop} index.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public StringList slice(int start, int stop) {
        if (start < 0 || stop > super.size() || start > stop) {
            throw new IndexOutOfBoundsException();
        } // if
        StringList slice = new ArrayStringList();
        int count = 0;
        // uses the add() method to add elements from the list to the new slice variable
        // using the specified start and stop
        for (int i = start; i < stop; i++) {
            slice.add(count, get(i));
            count++;
        } // for
        return slice;
    } // StringList

    /**
     * Constructs a string list that is a copy of the other string list.
     *
     * @param other an existing string list object that serves as the source object for the copy.
     * @throws NullPointerException if other is {@code null}.
     */
    public ArrayStringList(StringList other) {
        if (other == null) {
            throw new NullPointerException();
        } else {
            items = new String[other.size()];
            for (int i = 0; i < other.size(); i++) {
                items[i] = other.get(i);
            } // for
        } // if
    } // ArrayStringList

    /**
     * Returns a new fancy string list that contains the items from this list in reverse order.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public FancyStringList reverse() {
        // creates a FancyStringList variable that references a ArrayStringList object
        FancyStringList reverse = new ArrayStringList();
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
        // creates a FancyStringList variable that references a ArrayStringList object
        FancyStringList slice = new ArrayStringList();
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

} // ArrayStringList
