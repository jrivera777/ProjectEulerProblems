public class MinMax
{
    public static void main(String [] args)
    {
        int min = 0;
        int max = 0;
        boolean triplet = false;

        int[] arr = {-3, 4, -3};
        
        for(int i = 0; i < arr.length; i++)
        {
            if (arr[i] > max)
                max = arr[i];
            if (arr[i] < min)
                min = arr[i];
        }
        
        int[] neg = new int[Math.abs(min)+1];
        int[] pos = new int[max+1];
        
        for(int i = 0; i < arr.length; i++)
        {
            if (arr[i] < 0)
                neg[Math.abs(arr[i])]++;
            else if (arr[i] > 0)
                pos[Math.abs(arr[i])]++;
            else 
            {
                triplet = true;
            }
        }
        
        for(int i = 0; i < pos.length; i++)
        {
            if(pos[i] > 0)
            {
                for(int j = 0; j < neg.length; j++)
                {
                    if(neg[j] > 0)
                    {
                        int sum = i + (j*-1);
                        if (sum < 0)
                        {
                            if (pos[Math.abs(sum)] > 0)
                            {
                                triplet = true;
                            }
                        }
                        else
                        {
                            if (neg[Math.abs(sum)] > 0)
                            {
                                triplet = true;
                            }    
                        }
                    }
                }
            }
        }
        
        if(triplet)
            System.out.println("Found Triplet!");
        else
            System.out.println("No Triplet found.");
    }
}
