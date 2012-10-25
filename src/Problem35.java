import java.util.ArrayList;

public class Problem35
{
    public static void main(String [] args)
    {
        int circularPrimes = 0;

        for(int i = 2; i <= 1000000; i++)
        {
            ArrayList<String> rots = getRotations(String.valueOf(i));
            boolean allPrime = true;
            for(String str : rots)
            {
                if(!LargestPrimeFactor.isPrimeInteger(Integer.parseInt(str)))
                {
                    allPrime = false;
                    break;
                }
            }
            if(allPrime)
                circularPrimes++;
        }
        System.out.println(circularPrimes);
    }

    private static ArrayList<String> getRotations(String str)
    {
        ArrayList<String> rots = new ArrayList<String>();

        String currentForm = str;

        for(int i = 0; i < str.length(); i++)
        {
            rots.add(currentForm);
            currentForm = currentForm.substring(1) + currentForm.substring(0,1);
        }

        return rots;
    }
}
