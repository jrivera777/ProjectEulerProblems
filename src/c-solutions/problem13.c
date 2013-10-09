#include <stdio.h>
#include <stdlib.h>

#define DIGITS 1024
#define NUM_SIZE 50
#define NUM_COUNT 100
int main(int argc, char **argv)
{
    int i, j;
    size_t len = 0;
    FILE *f;
    int digits[DIGITS] = {0};
    char *numbers[NUM_COUNT];
    int carry = 0;
    int last_digit = DIGITS - 1;

    if(argc < 2)
    {
	printf("Usage: /.problem13 <numberFile>\n");
	return -1;
    }
    f = fopen(argv[1], "r");
    for(i = 0; i < NUM_COUNT; i++)
    {
	numbers[i] = NULL;
	getline(&numbers[i], &len, f);
    }


    for(i = NUM_SIZE - 1; i >= 0; i--)
    {
	int sum = 0;
	for(j = 0; j < NUM_COUNT; j++)
	{
	    sum += (numbers[j][i] - '0');
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
