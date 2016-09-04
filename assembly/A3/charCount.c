#include <stdio.h>

int charCount(char str[], char c);

int main()
{
   char word[20], search, count;

   printf("Input a word: ");
   scanf("%s", word);
   printf("Character to search for: ");
   scanf(" %c", &search);

   count = charCount(word, search);

   printf("Occurs %d times!\n", count);
 
   return 0;
}
int charCount(char *str, char c)
{
   int count;

   if (*str == 0)
      count = 0;
   else { 
      if (*str == c)
         count = 1;
      else
         count = 0;

      count += charCount(str+1, c);
   }

   return count;
}
   
