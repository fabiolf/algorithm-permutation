import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private class RQIterator implements Iterator<Item> {

        
        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return (!isEmpty());
        }

        @Override
        public Item next() {
            // TODO Auto-generated method stub
            return null;
        }
        
        public void remove (){
            throw new java.lang.UnsupportedOperationException("remove method not implemented");
        }
    }
    
    public RandomizedQueue() {
        // construct an empty randomized queue
    }
   
    public boolean isEmpty() {
        // is the randomized queue empty?
    }
   
    public int size() {
        // return the number of items on the randomized queue
    }
   
    public void enqueue(Item item) {
        // add the item
    }
   
    public Item dequeue() {
        // remove and return a random item
    }
   
    public Item sample() {
        // return a random item (but do not remove it)
    }
   
    public Iterator<Item> iterator() {
        // return an independent iterator over items in random order
        return new RQIterator();
    }
   
    public static void main(String[] args) {
        // unit testing (optional)
    }
}