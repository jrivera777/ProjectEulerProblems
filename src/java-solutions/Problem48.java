import java.math.BigInteger;

public class Problem48
{
    public static void main(String[] args)
    {
        BigInteger sum = BigInteger.ZERO;
        
        for(int i = 0; i < 1000; i++)
        {
            BigInteger n = BigInteger.valueOf(i+1);
            sum = sum.add(n.pow(i+1));
        }
        BigInteger mod = BigInteger.valueOf(100000);
        mod = mod.multiply(mod);
        System.out.println(sum.mod(mod));
    }
}
