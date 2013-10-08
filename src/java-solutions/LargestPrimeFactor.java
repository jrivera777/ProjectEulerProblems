import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class LargestPrimeFactor
{
    public static boolean isPrimeInteger(int n)
    {
        for(int i = 2; i <= (int) Math.floor(Math.sqrt(n)); i++)
        {
            if(n % i == 0)
            {
                //System.out.println(n + " / " + i);
                return false;
            }
        }
        return true;
    }

    public static boolean isPrimeLong(long n)
    {
        for(long i = 2; i <= (long) Math.floor(Math.sqrt(n)); i++)
        {
            if(n % i == 0)
            {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrimeBigInteger(BigInteger n)
    {
        BigInteger root = squareRootN(n);
        if(root.compareTo(BigInteger.ZERO) == 0)
            return false;
        for(long i = 2; i <= Math.floor(root.longValue()); i++)
        {
            long val = n.remainder(new BigInteger((Long.toString(i)))).longValue();
            if(val == 0)
                return false;
        }
        return true;
    }

    //Uses Newton's method
    public static BigInteger squareRootN(BigInteger N)
    {

        BigInteger G = new BigInteger((N.shiftRight((N.bitLength() + 1) / 2)).toString());
        if(G.compareTo(BigInteger.ZERO) == 0)
            return BigInteger.ZERO;
        BigInteger LastG = null;
        BigInteger One = new BigInteger("1");
        while(true)
        {
            LastG = G;
            G = N.divide(G).add(G).shiftRight(1);

            int i = G.compareTo(LastG);

            if(i == 0)
                return G;
            if(i < 0)
            {
                if(LastG.subtract(G).compareTo(One) == 0)
                    if(G.multiply(G).compareTo(N) < 0 && LastG.multiply(LastG).compareTo(N) > 0)
                        return G;
            }
            else
            {
                if(G.subtract(LastG).compareTo(One) == 0)
                    if(LastG.multiply(LastG).compareTo(N) < 0 && G.multiply(G).compareTo(N) > 0)
                        return LastG;
            }
        }
    }

    //Terribly inefficient!  N^2 or worse!
    public static BigInteger getLargestPrimeFactor(BigInteger n)
    {
        ArrayList<BigInteger> primes = new ArrayList<BigInteger>();
        for(BigInteger i = BigInteger.ONE; i.compareTo(n) < 0; i = i.add(BigInteger.ONE))
        {
            System.out.println(i.toString());
            if(n.remainder(i).compareTo(BigInteger.ZERO) == 0)
            {
                if(isPrimeBigInteger(i))
                {
                    primes.add(i);
                    System.out.println("Added " + i.toString() + "to Primes!");
                }

            }
        }
        return primes.get(primes.size() - 1);
    }

    private static BigInteger findLargestPrimeFactor(BigInteger n)
    {
        BigInteger i = new BigInteger("2");
        BigInteger answer = n;
        while(i.compareTo(answer) < 0)
        {
            if(answer.remainder(i).compareTo(n.ZERO) == 0)
                answer = answer.divide(i);

            i = i.add(BigInteger.ONE);
        }
        return answer;
    }

    public static long find1001Prime()
    {
        long counter = 0;
        long num = 2;
        long prime = -1;
        while(counter < 10001)
        {
            if(isPrimeLong(num))
            {
                prime = num;
                counter++;
                System.out.println(counter + ": " +prime);
            }
            num++;
        }
        return prime;
    }

    public static long sumPrimesBelowTwoMil()
    {
        long sum = 0;
        for(long i = 2; i <= 2000000; i++)
            if(isPrimeLong(i))
                sum +=i;
        return sum;
    }

    public static void main(String[] args)
    {
        //System.out.println(findLargestPrimeFactor(new BigInteger("600851475143")));
        
        //System.out.println(find1001Prime());

        System.out.println(sumPrimesBelowTwoMil());
    }
}
