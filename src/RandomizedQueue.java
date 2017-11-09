import java.util.Iterator;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private int mLastElement = 0;
    private Item[] mArray;

    private class RQIterator implements Iterator<Item> {
        int mPointer = 0;
        private Item[] mLocalArray;
        
        public RQIterator() {
            mLocalArray = (Item[]) new Object[mLastElement];
            for (int i = 0; i < mLastElement; i++)
                mLocalArray[i] = mArray[i];
            StdRandom.shuffle(mLocalArray, 0, mLastElement);
        }
        
        @Override
        public boolean hasNext() {
            return (!isEmpty() && (mPointer < mLastElement));
        }

        @Override
        public Item next() {
            if (mPointer >= mLastElement)
                throw new java.util.NoSuchElementException("end of queue");
            
            Item item = mLocalArray[mPointer];
            mPointer++;
            return item;
        }
        
        public void remove() {
            throw new java.lang.UnsupportedOperationException("remove method not implemented");
        }
    }
    
    public RandomizedQueue() {
        // construct an empty randomized queue
        mArray = (Item[]) new Object[1];
        StdRandom.uniform();
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < mLastElement; i++) {
            copy[i] = mArray[i];
        }
        
        mArray = copy;
    }
    
    public boolean isEmpty() {
        // is the randomized queue empty?
        return (mLastElement == 0);
    }
   
    public int size() {
        // return the number of items on the randomized queue
        return mLastElement;
    }
   
    public void enqueue(Item item) {
        if (item == null)
            throw new java.lang.IllegalArgumentException("tried to enqueue a null element");
        // enqueue the item
        if (mArray.length == mLastElement)
            resize(mArray.length * 2);
        
        mArray[mLastElement] = item;
        mLastElement++;
    }
   
    public Item dequeue() {
        // remove and return a random item
        if (isEmpty())
            throw new java.util.NoSuchElementException("trying to dequeue from an empty queue");
        
        int randomPos = StdRandom.uniform(mLastElement);
        Item item = mArray[randomPos];
        mArray[randomPos] = mArray[mLastElement-1];
        mArray[mLastElement-1] = null;
        mLastElement--;
        
        if (mLastElement > 0 && mLastElement <= mArray.length / 4)
            resize(mArray.length / 2);
        
        return item;
    }
   
    public Item sample() {
        if (isEmpty())
            throw new java.util.NoSuchElementException("trying to sample an empty queue");
        
        return mArray[StdRandom.uniform(mLastElement)];
    }
   
    public Iterator<Item> iterator() {
        // return an independent iterator over items in random order
        return new RQIterator();
    }
    
//    public static void printRandomizedQueue(RandomizedQueue rq) {
//        String line = "";
//        for (Object str : rq) {
//            line += str;
//            line += " ";
//        }
//        int len = rq.mArray.length;
//        int last = rq.mLastElement;
//        System.out.println("Elements: " + rq.size() + " Len: " + len + " Last: " + last + " | " + line);
//    } 
  
    public static void main(String[] args) {
//        RandomizedQueue rq = new RandomizedQueue<String>();
//        rq.enqueue("a");
//        printRandomizedQueue(rq);
//        rq.enqueue("b");
//        printRandomizedQueue(rq);
//        rq.enqueue("c");
//        printRandomizedQueue(rq);
//        rq.enqueue("d");
//        printRandomizedQueue(rq);
//        rq.enqueue("e");
//        printRandomizedQueue(rq);
//        System.out.println(rq.dequeue());
//        printRandomizedQueue(rq);
//        System.out.println(rq.dequeue());
//        printRandomizedQueue(rq);
//        System.out.println(rq.dequeue());
//        printRandomizedQueue(rq);
//        System.out.println(rq.dequeue());
//        printRandomizedQueue(rq);
//        System.out.println(rq.dequeue());
//        printRandomizedQueue(rq);
//        rq.enqueue("f");
//        printRandomizedQueue(rq);
//        rq.enqueue("g");
//        printRandomizedQueue(rq);
    }
}