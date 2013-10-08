public class TriangleNumbers
{
    public static void main(String[] args)
    {
        int counter = 0;
        boolean done = false;
        while(!done)
        {
            counter++;
            System.out.println(counter);
            for(int i = 1; i <= counter; i++)
            {
                int triangle = getTriangleNumber(i);
                if(countDivisors(triangle) >= 500)
                {
                    System.out.println(triangle);
                    done = true;
                }
            }
        }
    }

    public static int countDivisors(int n)
    {
        int divs = 0;
        for(int i = 1; i <= n; i++)
        {
            if(n % i == 0)
                divs++;
        }
        return divs;
    }

    public static int getTriangleNumber(int pos)
    {
        int sum = 0;
        for(int i = 1; i <= pos; i++)
            sum += i;
        return sum;
    }
}
