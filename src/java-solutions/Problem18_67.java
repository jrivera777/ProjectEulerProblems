
import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;
import weiss.nonstandard.Graph;

/**
 *
 * @author Joseph Rivera
 * 
 * Note: requires weiss.nonstandard.Graph
 * 
 * Solves #18 and #67
 */
public class Problem18_67
{
    public static void main(String[] args) throws IOException
    {
        double t0 = System.currentTimeMillis();
        Graph g = new Graph();
        Scanner scan = new Scanner(new File("p067_triangle.txt"));

        loadGraph(g, scan);

        g.acyclic("start");
        g.printPath("end"); // final cost is the answer, but negative
        
        double t1 = System.currentTimeMillis();
        System.out.println((t1 - t0) / 1000.0);
    }
    
    static int id = 0; //id to keep graph nodes unique

    public static void loadGraph(Graph g, Scanner scan)
    {
        Queue<String> prevLine = new ArrayDeque<>();
        boolean start = true;
       
        //parse triangle lines
        while(scan.hasNextLine())
        {
            String line = scan.nextLine();
            String[] vals = line.split(" ");
            int nextElem = 0;
            Deque<String> ids = new ArrayDeque<>(); //helps stop duplicate values in graph
            
            while(!prevLine.isEmpty())
            {
                String parentNode = prevLine.remove();
                int weight = Integer.parseInt(parentNode.split("-")[0]);
                String nodeName = vals[nextElem] + "-" + id;
                int cost = -weight;
                
                g.addEdge(parentNode, nodeName, cost);
                
                //stop duplicate entries
                if(ids.isEmpty()|| !ids.getLast().equals(nodeName))
                    ids.add(nodeName);
                nextElem++;
                id++;
                
                nodeName = vals[nextElem] + "-" + id;
                g.addEdge(parentNode, nodeName, cost);

                //stop duplicate entries
                if(!ids.getLast().equals(nodeName))
                    ids.add(nodeName);
            }

            //edge-case: first node in triangle
            if(start)
            {
                String other = vals[nextElem] + "-" + id++;
                int cost = 0;
                g.addEdge("start", other, cost);
                ids.add(other);
                start = false;
            }
            
            for(String s : ids)
                prevLine.add(s);
        }

        //attach last line nodes to end goal node
        while(!prevLine.isEmpty())
        {
            String val = prevLine.remove();
            int cost = 0;
            g.addEdge(val, "end", -Integer.parseInt(val.split("-")[0]));
        }
    }
}
