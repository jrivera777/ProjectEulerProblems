#include <stdio.h>
#include <stdlib.h>

#define DIGITS 1024
#define NUM_SIZE 50

int main()
{
    int i, j;
    int digits[DIGITS] = {0};
    char *numbers[] = {"37107287533902102798797998220837590246510135740250", "46376937677490009712648124896970078050417018260538"};
    int carry = 0;
    int last_digit = DIGITS - 1;

    for(i = NUM_SIZE - 1; i >= 0; i--)
    {
        int sum = 0;
        for(j = 0; j < 2; j++)
        {
            sum += numbers[j][i] - '0';
        }
        sum += carry;
        carry = sum / 10;
        digits[last_digit--] = sum % 10;
    }
    if(carry)
        digits[last_digit] = carry;
    else
        last_digit++;

    int* ptr = digits;
    i = 0;
    while(*ptr == 0)
    {
        ptr++;
        i++;
    }
    printf("Sum is: ");
    for(; last_digit < DIGITS; last_digit++)
        printf("%d", digits[last_digit]);
    printf("\n");
    return 0;
}
