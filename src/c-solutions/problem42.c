#include <stdio.h>
#include <ctype.h>
#include <string.h>

#define BUF_SIZE 128

/* Given triangle function. Gets nth triangle number) */
int triangle(int n)
{
    return (n / 2.0) * (n + 1);
}

/*
    Too lazy to do the algebra to get the inverse of the triangle function.
    Would probably make things faster.
*/
int isTriangle(int val)
{
    int n = 1;
    int tri;
    do
    {
        tri = triangle(n);
        if(tri == val)
            return 1;

        n++;
    }
    while(tri < val);

    return 0;
}

int letterToPosition(char ch)
{
    return toupper(ch) - 'A' + 1;
}

int getWordValue(char *word)
{
    int count = 0;
    char *ptr = word;

    while(*ptr != '\0')
        count += letterToPosition(*ptr++);

    return count;
}

int main()
{
    FILE *file;
    char word[BUF_SIZE];
    int triCount = 0;


    file = fopen("words.txt", "r");
    if(file == NULL)
    {
        printf("Error opening file! Exiting...\n");
        return -1;
    }

    while(fscanf(file, "\"%[^\"]\",",word) != EOF)
    {
        int wordValue, isTri;

        wordValue = getWordValue(word);
        isTri = isTriangle(wordValue);

        /*printf("%s - %d. Triangle Word? %s\n", word, wordValue, isTri ? "Yes" : "No");*/
        if(isTri)
            triCount++;
    }

    fclose(file);

    printf("Triangle Word Count = %d\n", triCount);

    return 0;
}
