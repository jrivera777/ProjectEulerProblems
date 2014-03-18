import java.util.ArrayList;

public class Problem14
{
    public static void main(String[] args)
    {
        int max = 13;
        long sz = 10;
        for(int i = 13; i < 1000000; i++)
        {
            long cs = CollatzSequence(i);
            if(cs > sz)
            {
                max = i;
                sz = cs;
            }
        }

        System.out.println(max);
        System.out.println(sz);

    }

    public static long CollatzSequence(long start)
    {
        long size = 0;
        do
        {
            if(start < 0)
                System.exit(-1);
            size++;
            if(start % 2 == 0)
                start /= 2;
            else
                start = 3 * start + 1;
        }
        while(start != 1);

        if(size > 1)
            size++;

        return size;
    }
}
