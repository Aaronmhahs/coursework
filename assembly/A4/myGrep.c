#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "myGrep.h"

/*
 * Main method for the myGrep program which counts word occurences in an input file
 */

int main(int argc, char *argv[])
{

	/*
	 * Reference declarations
	 */
	char string[MAX_LINE_LENGTH];
	char *sp;
	FILE *inFile;
	Word * key = (Word*)malloc(sizeof(Word));	

	
	char line_value[MAX_LINE_LENGTH];
	int line_length = -1;
	int line_longest = -1;
	int line_current = 0;
	int occ = 0;

	/*
	 * Checks for 3 arguments in the command line
	 */
	if(argc != 3)
	{
		printf("myGrep: improper number of arguments\n");
		printf("Usage: ./a.out <filename> <word>\n");
		return 0;
	}
	/*
	 * Checks for input file and opens it
	 */
	inFile = fopen(argv[1], "r");
	if(inFile == NULL)
	{
		printf("Unable to open file: %s\n", argv[1]);
		return 0;
	}
	else
	{
		printf("./a.out %s %s\n", argv[1], argv[2]);
	}
	
	

	
	/*
	 * Initialize the input word key
	 */
	strcpy(key->val, argv[2]);
	key->next = NULL;
			
	
	
	
	/*
	 * Reads each line of the file
	 */
	while(fgets(string, MAX_LINE_LENGTH, inFile) != NULL)
	{
		int temp_length = strlen(string) -1;
		int wordCount = 0;
		Word *wordIt = key;
		char tmp[MAX_LINE_LENGTH];
		strcpy(tmp, string);

		
		
		/*
		 * Splits each line into individual words
		 */
		sp = strtok(tmp, " \r\n\t,.?!");
		while(sp != NULL)
		{
			if(strcmp(key->val, sp)==0)
			{
				Word * newWord = (Word*)malloc(sizeof(Word));
				strcpy(newWord->val, string);
				newWord->location = wordCount;
				newWord->line = line_current;
				newWord->next = NULL;
				while(wordIt->next != NULL)
				{
					wordIt = wordIt->next;
				}
				wordIt->next = newWord;
				occ++;
			}
			sp = strtok(NULL, " \r\n\t,.?!");
			wordCount++;
		}
		

		


	
	
		/*
		 * Finds the longest line in the input file
		 */
		if(string[temp_length] == '\n')
		{
			string[temp_length] = '\0';
		}

		if(line_length < temp_length)
		{
			strncpy(line_value, string, temp_length +1);
			line_length = temp_length;
			line_longest = line_current;
		}
		line_current++;
	}
	line_length++;
	fclose(inFile);











	/*
	 * Program output information
 	 */
	printf("longest line: %s\n", line_value);
	printf("num chars: %d\n", line_length);
	printf("num lines: %d\n", line_current);
	printf("total occurrences of word: %d\n", occ);
	while((*key).next != NULL)
	{
		key = (*key).next;
		printf("line %d; word %d; %s", key->line, key->location, key->val);
	}
	
	return 0;
}
