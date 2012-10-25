import java.math.BigInteger;

public class Problem36
{
    //Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.

    public static void main(String[] args)
    {
        BigInteger val = BigInteger.ZERO;

        for(int i = 1; i <= 1000000; i++)
        {
            String str = String.valueOf(i);

            if(isPalindrome(str) && isPalindrome(toBinaryString(i)))
                val = val.add(BigInteger.valueOf(Long.parseLong(str)));
        }
        System.out.println(val);
    }

    private static String toBinaryString(long val)
    {
        long temp = val;
        String bin = "";
        while(temp > 0)
        {
            bin = String.valueOf(temp % 2) + bin;
            temp = temp / 2;
        }

        return bin;
    }

    private static boolean isPalindrome(String str)
    {
        if(str.length() == 1)
            return true;

        int front = 0;
        int end = str.length() - 1;
        boolean result = false;
        while((front < str.length() && end >= 0))
        {
            if(front > end)
            {
                result = true;
                break;
            }
            if(str.charAt(front) != str.charAt(end))
                break;

            front++;
            end--;
        }

        return result;
    }
}
