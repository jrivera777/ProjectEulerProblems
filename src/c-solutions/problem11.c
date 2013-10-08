#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

#define BUFF_SIZE 32

typedef enum direction
{
    UP,
    DUL,
    DUR,
    LEFT,
    RIGHT,
    DOWN,
    DDL,
    DDR
} Direction;

char* get_line(FILE *f)
{
    char c;
    char* line = malloc(BUFF_SIZE * sizeof(char));
    unsigned int pos = 0;

    while(1)
    {
	c = fgetc(f);
	if(c == EOF && strlen(line) == 0)
	    return c;
	if(c == '\n')
	    break;
	if(pos >= BUFF_SIZE -1)
	    line = realloc(line, 2 * strlen(line) + 1);
	line[pos++] = c;
    }
    return line;
}

void  load_grid(FILE* f, int *grid, int M, int N)
{
    int i;
    int j;
    int len;
    char *line = NULL;
    for(i = 0; i < M; i++)
    {
        getline(&line, &len, f);
	char *num = strtok(line, " ");
	for(j = 0; j < N; j++)
	{
	    grid[i * M +j] = atoi(num);
	    num = strtok(NULL, " ");
	}
    }
    free(line);
}
void print_grid(int *grid, int M, int N)
{
    int i;
    int j;
    for(i = 0; i < M; i++)
    {
	for(j = 0; j < N; j++)
	{
	    printf("%02d ", grid[i * M + j]);
	}
	printf("\n");
    }
}

int validate_dir(int r, int c, int M, int N, int adjacents, Direction dir)
{
    int i;
    int valid = 1;
    switch(dir)
    {
	case UP:
	{
	    for(i = 0; i < adjacents; i++)
		if(r-i < 0)
		    valid = 0;
	    break;
	}
	case DOWN:
	{
	    for(i = 0; i < adjacents; i++)
		if(r+i >= M)
		    valid = 0;
	    break;
	}
	case LEFT:
	{
	    for(i = 0; i < adjacents; i++)
		if(c-i < 0)
		    valid = 0;
	    break;
	}
	case RIGHT:
	{
	    for(i = 0; i < adjacents; i++)
		if(c+i >= N)
		    valid = 0;
	    break;
	}
	case DUL:
	{
	    for(i = 0; i < adjacents; i++)
		if(c - i < 0 || r - i < 0)
		    valid = 0;
	    break;
	}
	case DUR:
	{
	    for(i = 0; i < adjacents; i++)
		if(c + i >= N || r - i < 0)
		    valid = 0;
	    break;
	}
	case DDL:
	{
	    for(i = 0; i < adjacents; i++)
		if(c - i < 0 || r + i >= M)
		    valid = 0;
	    break;
	}
	case DDR:
	{
	    for(i = 0; i < adjacents; i++)
		if(c + i >= N || r + i>= M)
		    valid = 0;
	    break;
	}
	default:
	    valid = 0;
    }
    return valid;
}

unsigned long calc_largest_at(int *grid, int M, int N, int r,
			     int c, Direction dir, int adjacents)
{
    unsigned long prod = 1;
    int i;
    if(!validate_dir(r, c, M, N, adjacents, dir))
	return 0;

    switch(dir)
    {
	case UP:
	{
	    for(i = 0; i < adjacents; i++)
		prod *= grid[(r-i) * M + c];
	    break;
	}
	case DOWN:
	{
	    for(i = 0; i < adjacents; i++)
		prod *= grid[(r+i) * M + c];
	    break;
	}
	case LEFT:
	{
	    for(i = 0; i < adjacents; i++)
		prod *= grid[r * M + (c-i)];
	    break;
	}
	case RIGHT:
	{
	    for(i = 0; i < adjacents; i++)
		prod *= grid[r * M + (c+i)];
	    break;
	}
        case DUL:
	{
	    for(i = 0; i < adjacents; i++)
		prod *= grid[(r - i) * M + (c - i)];
	    break;
	}
        case DUR:
	{
	    for(i = 0; i < adjacents; i++)
		prod *= grid[(r - i) * M + (c + i)];
	    break;
	}
        case DDL:
	{
	    for(i = 0; i < adjacents; i++)
		prod *= grid[(r + i) * M + (c - i)];
	    break;
	}
        case DDR:
	{
	    for(i = 0; i < adjacents; i++)
		prod *= grid[(r + i) * M + (c + i)];
	    break;
	}
	default:
	{
	    prod = -1;
	    break;
	}
    }
    return prod;
}

int main(int argc, char **argv)
{
    FILE *f;
    int M, N, adjacents;
    int *grid;
    int i, j;
    clock_t begin, end;
    double time_spent;

    begin = clock();

    if(argc < 5)
    {
	printf("Usage: ./problem11 <gridFile> <M> <N> <adjacentNumbers>\n");
	return -1;
    }

    M = atoi(argv[2]);
    N = atoi(argv[3]);
    adjacents = atoi(argv[4]);

    grid = malloc(sizeof(int*) * M * N);

    f = fopen(argv[1], "r");
    if(f == NULL)
    {
	printf("Failed to open grid file. Exiting...\n");
	return -1;
    }

    load_grid(f, grid, M, N);
    print_grid(grid, M, N);

    //brute force search.  Not good, but works for this size grid...
    Direction dir;
    unsigned long maxProd = 0;
    for(i = 0; i < M; i++)
    {
        for(j = 0; j < N; j++)
        {
            for(dir = 0; dir < 8; dir++)
            {
                unsigned long prod = calc_largest_at(grid, M, N, i, j, dir, adjacents);                
                if(prod > maxProd)
                    maxProd = prod;
            }
        }
    }

    free(grid);

    end = clock();
    time_spent = (double)(end - begin) / CLOCKS_PER_SEC;
    printf("Prod = %lu found in %f\n", maxProd, time_spent);

    return 0;
}
