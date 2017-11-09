import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    
    private Node mFirst;
    private Node mLast;
    private int mSize;
    
    private class Node {
        Item mItem;
        Node mNext;
        Node mPior;
    }
    
    private class DequeIterator implements Iterator<Item> {

        private Node mCurrent = mFirst;
        
        @Override
        public boolean hasNext() {
            return mCurrent != null;
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new java.util.NoSuchElementException("no more items to iterate");
            Item item = mCurrent.mItem;
            mCurrent = mCurrent.mNext;
            return item;
        }
        
        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }
    }
    
    public Deque() {
        // construct an empty deque
        mFirst = null;
        mLast = null;
        mSize = 0;
    }
    
    public boolean isEmpty() {
        // is the deque empty?
        return (mFirst == null);
    }
    
    public int size() {
        // return the number of items on the deque
        return mSize;
    }
    
    public void addFirst(Item item) {
        // add the item to the front
        // corner case: adding a null item
        if (item == null)
            throw new java.lang.IllegalArgumentException("received null item");
        
        Node oldfirst = null;
        if (mFirst != null)
            oldfirst = mFirst;
        mFirst = new Node();
        mFirst.mItem = item;
        if (oldfirst != null) {
            mFirst.mNext = oldfirst;
            oldfirst.mPior = mFirst;
        } else
            mLast = mFirst;
        mSize++;
    }
    
    public void addLast(Item item) {
        // add the item to the end
        // corner case: adding a null item
        if (item == null)
            throw new java.lang.IllegalArgumentException("received null item");

        Node oldlast = null;
        if (mLast != null)
            oldlast = mLast;
        mLast = new Node();
        mLast.mItem = item;
        if (oldlast != null) {
            mLast.mPior = oldlast;
            oldlast.mNext = mLast;
        } else
            mFirst = mLast;
        mSize++;
    }
    
    public Item removeFirst() {
        // remove and return the item from the front
        if (this.isEmpty())
            throw new java.util.NoSuchElementException();
        
        Item item = mFirst.mItem;
        if (mFirst == mLast) {
            mFirst = null;
            mLast = null;
        } else {
            mFirst = mFirst.mNext;
            mFirst.mPior = null;
        }
        mSize--;
        return item;
    }
    
    public Item removeLast() {
        // remove and return the item from the end
        if (this.isEmpty())
            throw new java.util.NoSuchElementException();
        
        Item item = mLast.mItem;
        if (mFirst == mLast) {
            mFirst = null;
            mLast = null;
        } else {
            mLast = mLast.mPior;
            mLast.mNext = null;
        }
        mSize--;
        return item;
    }
    
    public Iterator<Item> iterator() {
        // return an iterator over items in order from front to end
        return new DequeIterator();
    }
    
//    public static void printDeque(Deque dq) {
//        String line = "";
//        for (Object str : dq) {
//            line += str;
//            line += " ";
//        }
//        System.out.println("Size: " + dq.size() + " | " + line);
//    }

    public static void main(String[] args) {
//        //addFirst
//        Deque<String> dq = new Deque<String>();
//        dq.addFirst("a");
//        printDeque(dq);
//        //addLast
//        Deque<String> dq2 = new Deque<String>();
//        dq2.addLast("a");
//        printDeque(dq2);
//        dq2.addLast("b");
//        printDeque(dq2);
//        dq2.addFirst("c");
//        printDeque(dq2);
//        dq2.removeLast();
//        printDeque(dq2);
//        dq2.removeFirst();
//        printDeque(dq2);

    }

}
