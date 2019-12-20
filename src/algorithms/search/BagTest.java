package algorithms.search;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.StdOut;

public class BagTest {
    public static void main(String[] args) {
        Bag<String> bag = new Bag<String>();
        bag.add("A");
        bag.add("B");
        bag.add("C");
        bag.add("D");
        bag.add("E");
        bag.add("F");
        
        System.out.println(bag.size());
        
        for (String s : bag) {
            StdOut.println(s);
        }
        
        
        
        
        Graph graph = new Graph(6);
        
        
        graph.addEdge(1, 5);
        
        System.out.println(graph);
    }
}