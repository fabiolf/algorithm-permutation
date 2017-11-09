import edu.princeton.cs.algs4.StdIn;

public class Permutation {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("need at least one argument: the size of the array to be read");
            return;
        }
        
//        for (String str : args)
//            System.out.println(str);

        RandomizedQueue<String> rq = new RandomizedQueue<String>();

        int k = Integer.parseInt(args[0]);
        
        String str = null;
        while (!StdIn.isEmpty()) {
            str = StdIn.readString();
//            System.out.println(str);
            rq.enqueue(str);
            // boolean b3 = StdIn.hasNextLine();
        }
//        System.out.println("finished!");
        
        for (int i = 0; i < k; i++) {
            str = rq.dequeue();
            System.out.println(str);
        }
    }

}
