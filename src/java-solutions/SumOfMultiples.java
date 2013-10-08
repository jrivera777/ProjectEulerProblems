public class SumOfMultiples 
{
    public static void main(String[] args)
    {
        int[] arr = {3, 5};
        System.out.println(GetSumOfMultiples(arr, 1000));
    }

    public static int GetSumOfMultiples(int[] mult, int amount)
    {
        int sum = 0;
        for(int i = 1; i< amount;i++)
        {
            for(int m : mult)
            {
                if(i%m == 0)
                {
                    sum += i;
                    break;
                }
            }
        }
        return sum;
    }
}
