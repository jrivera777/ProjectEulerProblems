public class PythogreanTriplets 
{

    public static boolean isEven(double n)
    {
        return n % 2 == 0;
    }
    public static void main(String[] args)
    {
        int n = 1;
        double a = 2*n + 1;
        double b = 2*n*(n+1);
        double c = 2*n*(n+1) + 1;
        while (a+b+c != 1000 && a+b+c <= 1000)
        {
            System.out.printf("a=%.0f, b=%.0f, c=%.0f : %.0f\n",a,b,c, a+b+c);
            n++;

            a = 2*n + 1;
            b = 2*n*(n+1);
            c = 2*n*(n+1) + 1;
        }
        if(a+b+c == 1000)
            System.out.println("Result = " + a*b*c);
    }
}
