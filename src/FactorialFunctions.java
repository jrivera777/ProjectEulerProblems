import java.math.BigInteger;

public class FactorialFunctions
{
    public static BigInteger factorialRecursiveProduct(int n)
    {
        if(n < 0)
        {
            throw new ArithmeticException("Factorial: n has to be >= 0, but was " + n);
        }

        if(1 < n)
        {
            return recProduct(1, n);
        }
        return BigInteger.ONE;
    }

    private static BigInteger recProduct(int n, int len)
    {
        if(1 < len)
        {
            int temp = len / 2;

            return recProduct(n, temp).multiply(recProduct(n + temp, len - temp));
        }
        return BigInteger.valueOf(n);
    }

    public static void main(String[] args)
    {
        System.out.println(factorialRecursiveProduct(100));
    }
}
