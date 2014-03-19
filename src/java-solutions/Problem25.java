import java.math.BigInteger;
import java.util.ArrayList;

public class Problem25
{
    static ArrayList<BigInteger> fibs = new ArrayList<BigInteger>();

    public static void main(String[] args)
    {
        fibs.add(BigInteger.ONE);
        fibs.add(BigInteger.ONE);
        int i = 4500;
        BigInteger fib = fibonacci(i);
        while(String.valueOf(fib).length() < 1000)
        {
            fib = fibonacci(++i);
        }
        System.out.printf("Fibonacci(%d) = %d has %d digits.\n", i, fib, String.valueOf(fib).length());
    }

    public static BigInteger fibonacci(int n)
    {
        if(n - 1 < fibs.size())
            return fibs.get(n - 1);
        for(int i = 0; i < n; i++)
        {
            if(i < fibs.size())
                continue;
            fibs.add(fibs.get(i - 1).add(fibs.get(i - 2)));
        }
        return fibs.get(n - 1);
    }
}
