import java.util.Iterator;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private int m_last_element = 0;
    private Item[] m_array;

    private class RQIterator implements Iterator<Item> {
        int m_pointer = 0;
        
        public RQIterator() {
            StdRandom.shuffle(m_array, 0, m_last_element);
        }
        
        @Override
        public boolean hasNext() {
            return (!isEmpty() && (m_pointer < m_last_element));
        }

        @Override
        public Item next() {
            if (m_pointer > m_last_element)
                throw new java.util.NoSuchElementException("end of queue");
            
            Item item = m_array[m_pointer];
            m_pointer++;
            return item;
        }
        
        public void remove () {
            throw new java.lang.UnsupportedOperationException("remove method not implemented");
        }
    }
    
    @SuppressWarnings("unchecked")
    public RandomizedQueue() {
        // construct an empty randomized queue
        m_array = (Item[]) new Object[1];
        StdRandom.uniform();
    }

    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < m_last_element; i++) {
            copy[i] = m_array[i];
        }
        
        m_array = copy;
    }
    
    public boolean isEmpty() {
        // is the randomized queue empty?
        return (m_last_element == 0);
    }
   
    public int size() {
        // return the number of items on the randomized queue
        return m_last_element;
    }
   
    public void enqueue(Item item) {
        if (item == null)
            throw new java.lang.IllegalArgumentException("tried to enqueue a null element");
        // enqueue the item
        if (m_array.length == m_last_element)
            resize(m_array.length * 2);
        
        m_array[m_last_element] = item;
        m_last_element++;
    }
   
    public Item dequeue() {
        // remove and return a random item
        if (isEmpty())
            throw new java.util.NoSuchElementException("trying to dequeue from an empty queue");
        
        int random_pos = StdRandom.uniform(m_last_element);
        Item item = m_array[random_pos];
        m_array[random_pos] = m_array[m_last_element-1];
        m_array[m_last_element-1] = null;
        m_last_element--;
        
        if (m_last_element <= m_array.length / 4)
            resize(m_array.length / 2);
        
        return item;
    }
   
    public Item sample() {
        if (isEmpty())
            throw new java.util.NoSuchElementException("trying to sample an empty queue");
        
        return m_array[StdRandom.uniform(m_array.length)];
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
//        int len = rq.m_array.length;
//        int last = rq.m_last_element;
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