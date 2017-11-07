import edu.princeton.cs.algs4.StdIn;

public class Permutation {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("need at least one argument: the size of the array to be read");
            return;
        }

        RandomizedQueue<String> rq = new RandomizedQueue<String>();

        int k = Integer.parseInt(args[0]);
        
        while (true) {
            String str;
            try {
                str = StdIn.readString();
            } catch (Exception e) {
                break;
            }
            rq.enqueue(str);
        }
        
        for (int i = 0; i < k; i++) {
            String str = rq.dequeue();
            System.out.println(str);
        }
    }

}
