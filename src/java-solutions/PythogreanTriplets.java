public class PythogreanTriplets
{
    public static boolean isEven(double n)
    {
        return n % 2 == 0;
    }

    public static void main(String[] args)
    {
        int a = 0;
        int b = 0;
        int c = 0;
        int sum = 0;
        int product = 0;

        for(int m = 2; m < 100; m++)
        {
            for(int n = 1; n < 100; n++)
            {
                while(m > n)
                {
                    a = (m * m) - (n * n);
                    b = (2 * m) * n;
                    c = (m * m) + (n * n);

                    sum = a + b + c;
                    if(sum == 1000)
                    {
                        product = a * b * c;
                        System.out.print("a :" + a + "b :" + b + "c : " + c);
                        System.out.println("Product is " + product);
                        break;
                    }
                    break;
                }
            }
        }
    }
}
