import java.util.ArrayList;

public class LargestPalindrome
{

    private static boolean isPalindrome(String str)
    {
        if(str.length() <= 1)
            return true;

        if(str.charAt(0) != str.charAt(str.length() - 1))
            return false;

        return isPalindrome(str.substring(1, str.length() - 1));
    }

    public static void main(String[] args)
    {
        String largest = "0";
        for(int i = 100; i <= 999; i++)
        {
            for(int j = 100; j <= 999; j++)
            {
                String num = String.valueOf(i * j);
                if(isPalindrome(num))
                {
                    if(Integer.parseInt(largest) < Integer.parseInt(num))
                        largest = num;
                }
            }
        }
        System.out.println(largest);
    }
}
