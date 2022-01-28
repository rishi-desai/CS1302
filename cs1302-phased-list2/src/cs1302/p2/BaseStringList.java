package cs1302.p2;

import cs1302.adt.StringList;
import cs1302.adt.FancyStringList;

/**
 * An abstract class that implements {@code StringList}.
 */
public abstract class BaseStringList implements FancyStringList {

    /** The size of the array or node. */
    protected int size;

    /**
     * Constructs an {@code BaseStringList} object and initializes {@code size} to 0.
     */
    public BaseStringList() {
        size = 0;
    } // BaseStringList

    /**
     * Appends an item to this string list.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public boolean append(String item) {
        if (item.equals("")) {
            throw new IllegalArgumentException();
        } else if (item == null) {
            throw new NullPointerException();
        } // if

        // calls the add() method from the respect class either ArrayStringList or LinkedStringList
        // with index at size
        return this.add(size, item);
    } // append

    /**
     * Returns {@code true} if the {@code Array List} or {@code Linked List} has no items.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        boolean isEmpty = false;
        if (size == 0) {
            isEmpty = true;
        } // if
        return isEmpty;
    } // isEmpty

    /**
     * Returns a string representation of this string list that begins with {@code start} and
     * ends with {@code end}, with each {@code item} seperated by {@code sep}.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public String makeString(String start, String sep, String end) {
        String str = start;
        for (int i = 0; i < size; i++) {

            // formats the str that is to be printed out
            str += (i != size - 1) ? this.get(i) + sep : this.get(i);
        } // for
        str += end;
        return str;
    } // makeString

    /**
     * Prepends an item to this string list. Returns {@code true} if item is
     * successfully inserted at index 0.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public boolean prepend(String item) {
        if (item == null) {
            throw new NullPointerException();
        } else if (item.equals("")) {
            throw new IllegalArgumentException();
        } // if
        // calls the add() method form the respect class either ArrayStringList or LinkedStringList
        // with index at 0
        return this.add(0, item);
    } // prepend

    /**
     * Returns the size of the {@code Array List} or {@code Linked List}.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return size;
    } // size

    /**
     * Returns {@link #makeString()}.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return makeString("[", ", ", "]");
    } // toString

    /**
     * Inserts an {@code items} from a string list into this string list at the specified
     * {@code index}.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public boolean add(int index, StringList items) {
        boolean add = false;
        if (items == null) {
            throw new NullPointerException();
        } else if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        } else {
            int count = index;
            if (this == items) {
                String[] tempItems = new String[size()];
                for (int i = 0; i < items.size(); i++) {
                    tempItems[i] = items.get(i);
                } // for
                for (int i = 0; i < tempItems.length; i++) {
                    this.add(count, tempItems[i]);
                    count++;
                } // for
            } else {
                for (int i = 0; i < items.size(); i++) {
                    this.add(count, items.get(i));
                    count++;
                } // for
            } // if
            add = true;
        } // if
        return add;
    } // add

    /**
     * Appends {@code items} from a string list into this string list.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public boolean append(StringList items) {
        boolean append = false;
        if (items == null) {
            throw new NullPointerException();
        } else {
            int count = 0;
            if (this == items) {
                String[] tempItems = new String[size()];
                for (int i = 0; i < items.size(); i++) {
                    tempItems[i] = items.get(i);
                } // for
                for (int i = 0; i < tempItems.length; i++) {
                    this.add(count, tempItems[i]);
                    count++;
                } // for
            } else {
                for (int i = 0; i < items.size(); i++) {
                    this.add(count, items.get(i));
                    count++;
                } // for
                append = true;
            } // if
        } // if
        return append;
    } // append

    /**
     * Returns {@code true} if there exists an item at or after the {@code start} index that equals
     * equals the {@code target} string. If no item, then {@code false} is returned.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public boolean contains(int start, String target) {
        boolean contains = false;
        if (start < 0 || start > size() || target.equals(null)) {
            return contains;
        } else {
            for (int i = start; i < size(); i++) {
                if (this.get(i).equals(target)) {
                    contains = true;
                } // if
            } // for
        } // if
        return contains;
    } // contains

    /**
     * Returns the index of the first item at or after the {@code start} index that equals the
     * {@code target} string.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public int indexOf(int start, String target) {
        if (start < 0 || start > size() || target.equals(null)) {
            return -1;
        } else {
            for (int i = 0; i < size(); i++) {
                if (i >= start && this.get(i).equals(target)) {
                    return i;
                } // if
            } // for
        } // if
        return -1;
    } // indexOf

    /**
     * Prepends {@code items} from a StringList into this string list.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public boolean prepend(StringList items) {
        boolean prepend = false;
        if (items == null) {
            throw new NullPointerException();
        } else {
            int count = size();
            if (this == items) {
                String[] tempItems = new String[size()];
                for (int i = 0; i < items.size(); i++) {
                    tempItems[i] = items.get(i);
                } // for
                for (int i = 0; i < tempItems.length; i++) {
                    this.add(count, tempItems[i]);
                    count++;
                } // for
            } else {
                for (int i = 0; i < items.size(); i++) {
                    this.add(count, items.get(i));
                    count++;
                } // for
                prepend = true;
            } // if
        } // if
        return prepend;
    } // prepend

} // BaseStringList
