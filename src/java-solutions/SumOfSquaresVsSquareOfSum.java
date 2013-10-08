public class SumOfSquaresVsSquareOfSum
{
    public static void main(String[] args)
    {
        long sqOfSum = 0;
        long sumOfSq = 0;

        for(int i = 1; i <= 100; i++)
        {
            sumOfSq += Math.pow(i, 2);
            sqOfSum += i;
        }
        sqOfSum = (long) Math.pow(sqOfSum, 2);

        System.out.println(sqOfSum - sumOfSq);
    }
}
