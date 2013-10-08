public class Fibonacci1000
{
    static Matrix matrix;
    static double arr[][] = {{1.0,1.0},{1.0,0.0}};
    public static void main(String[] args)
    {
        int i = 1;
        String s = String.valueOf(i);
       
        
        matrix = new Matrix(arr);
       
        while(s.length() < 1000)
        {
            s = String.valueOf(fib(i++));
            System.out.println(s);
        }
        System.out.println(s);
    }
    
    public static double fib(int n)
    {
        matrix = new Matrix(arr);
        matpow(n-1);
        return matrix.getPoint(0,0);
    }
    
    public static void matpow(int n)
    {
        
        if (n > 1) 
        {
            matpow(n/2);
            matrix = matrix.times(matrix);
        }
        if(n % 2 != 0)
        {
            double arr[][] = {{1.0,1.0},{1.0,0.0}};
            Matrix N = new Matrix(arr);
            matrix = matrix.times(N);
        }
    }
}
