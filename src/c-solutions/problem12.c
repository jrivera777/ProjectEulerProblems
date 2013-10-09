#include <stdio.h>


int countDivisors(unsigned int num)
{
    int total = 1;
    int count = 0;
    int i = 2;
    while(num > 1)
    {
        while(num % i == 0)
        {
            count++;
            num = num / i;
        }
        i++;
        total *= count+1;
        count = 0;
        if(num < i*i)
        {
            if(num > 1)
                total *= count + 2;
            break;
        }
    }
    return total;
}

int main()
{
    unsigned int num = 1;
    int i = 2;
    int divs = countDivisors(num);
    while(divs < 500)
    {
        num += i;
        divs = countDivisors(num);
        i++;
    }
    printf("Divisor count for %u is %d\n", num, divs);
    return 0;
}
