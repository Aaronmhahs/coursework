#ifndef MYGREP_H

#define MAX_LINE_LENGTH 100

typedef struct wordType Word;

struct wordType
{
	char val[MAX_LINE_LENGTH];
	int line;
	int location;
	Word *next;
};

#endif
