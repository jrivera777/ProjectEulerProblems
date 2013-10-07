
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author fdot
 */
public class Problem22
{

    public static void main(String[] args)
    {
        long startTime = System.nanoTime();
        ArrayList<String> names = readNames("names.txt");
        Collections.sort(names);
        long totalScore = 0;
        for(int i = 0; i < names.size(); i++)
        {
            totalScore += (i + 1) * getNameScore(names.get(i));
        }
        
        System.out.println(totalScore);
        System.out.println("Time Elapsed: " + (System.nanoTime() - startTime)/1000000000.0);
    }

    public static long getNameScore(String name)
    {
        long score = 0;
        
        for(char letter : name.toCharArray())
            score += ((long)letter) - 64;
        return score;
    }
    public static ArrayList<String> readNames(String fileName)
    {
        ArrayList<String> names = new ArrayList<String>();
        try
        {
            File f = new File(fileName);
            Scanner scan = new Scanner(f);
            scan.useDelimiter(",");
            while (scan.hasNext())
            {
                String name = scan.next().replace("\"", "");
                names.add(name);
                //System.out.println(name);
            }
        }
        catch (FileNotFoundException ex)
        {
            System.err.println("File is missing or does not exist.");
            System.exit(-1);
        }

        return names;
    }
}
