import java.math.BigInteger;

public class Problem20
{
    public static void main(String[] args)
    {

        //Find the sum of the digits in the number 100!

        BigInteger val = FactorialFunctions.factorialRecursiveProduct(100);
        String toRead = String.valueOf(val);

        int sum = 0;
        for(int i = 0; i < toRead.length(); i++)
            sum += Integer.parseInt(String.valueOf(toRead.charAt(i)));

        System.out.println(sum);
    }
}
