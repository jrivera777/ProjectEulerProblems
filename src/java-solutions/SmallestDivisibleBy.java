public class SmallestDivisibleBy
{
    public static void main(String[] args)
    {
        boolean divByAll = false;
        int counter = 1;

        while(!divByAll)
        {
            divByAll = true;
            for(int i = 1; i <= 20; i++)
            {
                if(counter % i != 0)
                {
                    divByAll = false;
                    counter++;
                    break;
                }
            }
        }
        System.out.println(counter);
    }
}
