public class Problem28
{
    enum Dir
    {
        UP, DOWN, LEFT, RIGHT;
    }

    public static void main(String[] args)
    {
        int n = 1001;
        int size = n * n;
        int[] big_arr = new int[size];

        for(int i = 0; i < size; i++)
            big_arr[i] = i + 1;

        int increase = 2;
        long sum = 1;
        int curr = 0;
        while(curr < size - 1)
        {
            for(int i = 0; i < 4; i++)
            {
                curr += increase;
                sum += big_arr[curr];
            }
            increase += 2;
        }

        System.out.println(sum);
    }
}
