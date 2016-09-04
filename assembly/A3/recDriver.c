#include <stdio.h>
#include "rec.h"

int main(void)
{
	int number;

	printf("Please enter a number.\n");
	scanf(" %d", &number);
	
	printf("Counting backward...\n");
	countBackwardFrom(number);

	printf("Counting forward...\n");
	countForwardTo(number);

	printf("\n");

	return 0;
}
