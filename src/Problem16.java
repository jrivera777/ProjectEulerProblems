import java.math.BigInteger;

public class Problem16
{
    public static final BigInteger TWO = new BigInteger("2");

    public static void main(String[] args)
    {
        BigInteger val = BigInteger.ONE;
        int power = 1000;
        int sum = 0;

        val = TWO.pow(1000);

        char[] chars = val.toString().toCharArray();

        for(char c : chars)
            sum += Integer.parseInt(String.valueOf(c));
        System.out.println(sum);
    }
}
