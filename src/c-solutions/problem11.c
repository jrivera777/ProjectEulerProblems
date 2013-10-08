#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define BUFF_SIZE 32

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
    char* line;
    for(i = 0; i < M; i++)
    {
        line = get_line(f);
        char *num = strtok(line, " ");
        for(j = 0; j < N; j++)
        {
            
            grid[i * M + j] = atoi(num);
            num = strtok(NULL, " ");
        }
        free(line);
    }
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
int main(int argc, char **argv)
{
    FILE *f;
    int M, N;

    if(argc < 4)
    {
        printf("Usage: ./problem11 <gridFile> <M> <N>\n");
        return -1;
    }
    
    M = atoi(argv[2]);
    N = atoi(argv[3]);
    int grid[M][N];

    f = fopen(argv[1], "r");
    if(f == NULL)
    {
        printf("Failed to open grid file. Exiting...\n");
        return -1;
    }

    load_grid(f, *grid, M, N);
    print_grid(*grid, M, N);
    return 0;
}
