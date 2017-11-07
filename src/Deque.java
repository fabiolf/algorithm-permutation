import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    
    private Node m_first;
    private Node m_last;
    private int m_size;
    
    private class Node {
        Item m_item;
        Node m_next;
        Node m_prior;
    }
    
    private class DequeIterator implements Iterator<Item> {

        private Node m_current = m_first;
        
        @Override
        public boolean hasNext() {
            return m_current != null;
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new java.util.NoSuchElementException("no more items to iterate");
            Item item = m_current.m_item;
            m_current = m_current.m_next;
            return item;
        }
        
        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }
    }
    
    public Deque() {
        // construct an empty deque
        m_first = null;
        m_last = null;
        m_size = 0;
    }
    
    public boolean isEmpty() {
        // is the deque empty?
        return (m_first == null);
    }
    
    public int size() {
        // return the number of items on the deque
        return m_size;
    }
    
    public void addFirst(Item item) {
        // add the item to the front
        // corner case: adding a null item
        if (item == null)
            throw new java.lang.IllegalArgumentException("received null item");
        
        Node oldfirst = null;
        if (m_first != null)
            oldfirst = m_first;
        m_first = new Node();
        m_first.m_item = item;
        if (oldfirst != null) {
            m_first.m_next = oldfirst;
            oldfirst.m_prior = m_first;
        } else
            m_last = m_first;
        m_size++;
    }
    
    public void addLast(Item item) {
        // add the item to the end
        // corner case: adding a null item
        if (item == null)
            throw new java.lang.IllegalArgumentException("received null item");

        Node oldlast = null;
        if (m_last != null)
            oldlast = m_last;
        m_last = new Node();
        m_last.m_item = item;
        if (oldlast != null) {
            m_last.m_prior = oldlast;
            oldlast.m_next = m_last;
        } else
            m_first = m_last;
        m_size++;
    }
    
    public Item removeFirst() {
        // remove and return the item from the front
        if (this.isEmpty())
            throw new java.util.NoSuchElementException();
        
        Item item = m_first.m_item;
        if (m_first == m_last) {
            m_first = null;
            m_last = null;
        } else {
            m_first = m_first.m_next;
            m_first.m_prior = null;
        }
        m_size--;
        return item;
    }
    
    public Item removeLast() {
        // remove and return the item from the end
        if (this.isEmpty())
            throw new java.util.NoSuchElementException();
        
        Item item = m_last.m_item;
        if (m_first == m_last) {
            m_first = null;
            m_last = null;
        } else {
            m_last = m_last.m_prior;
            m_last.m_next = null;
        }
        m_size--;
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
//        
//        dq.addFirst("a");
//        printDeque(dq);
//        
//        //addLast
//        Deque<String> dq2 = new Deque<String>();
//        
//        dq2.addLast("a");
//        printDeque(dq2);
//        
//        dq2.addLast("b");
//        printDeque(dq2);
//
//        dq2.addFirst("c");
//        printDeque(dq2);
//        
//        dq2.removeLast();
//        printDeque(dq2);
//
//        dq2.removeFirst();
//        printDeque(dq2);

    }

}
