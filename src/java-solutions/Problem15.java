import java.math.BigInteger;

public class Problem15
{
    public static void main(String[] args)
    {
        double t0 = System.currentTimeMillis();
        int points = 21;
        BigInteger[][] grid = new BigInteger[points][points];
        BigInteger[][] old = new BigInteger[points][points];;
        for(int i = 0; i < points; i++)
            for(int j = 0; j < points; j++)
                grid[i][j] = BigInteger.ZERO;

        countPaths(grid, 0, 0, points);
        printGrid(grid);

        System.out.println(grid[points - 1][points - 1]);
        double t1 = System.currentTimeMillis();
        System.out.println((t1 - t0) / 1000.0);
    }

    public static void countPaths(BigInteger[][] grid, int x, int y, int goal)
    {
        for(int i = 0; i < goal; i++)
        {
            for(int j = 0; j < goal; j++)
            {
                int left = i - 1;
                int above = j - 1;

                if(left < 0 || above < 0)
                    grid[i][j] = BigInteger.ONE;
                else
                    grid[i][j] = grid[left][j].add(grid[i][above]);
            }
        }
    }

    public static void printGrid(BigInteger[][] grid)
    {
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[i].length; j++)
            {
                System.out.printf("[%d] ", grid[i][j]);
            }
            System.out.println();
        }
    }
}
