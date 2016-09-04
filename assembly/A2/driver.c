/*
 *@author: Aaron Hahs
 *@title: Assignment 6 - CPE225-03
 *@description: Driver file for stack testing/use
 */

#include <stdio.h>
#include "stack.h"

/*
 * Main method for running the driver
 */
int main(void)
{
	char choice;
	int pushed;
	int check;
	int popped;
	int mode = 0;
	int done = 0;
	

	st.top = -1;

	printf("Welcome to the stack program.\n");
	
	while(done == 0)
	{
		printf("\nEnter option: ");
		scanf(" %c", &choice);
		switch(choice)
		{
			case 'u':
				printf("What number? ");
				scanf(" %d", &pushed);
				check = push(pushed);
				if(check == 1)
				{
					printf("Overflow!!!\n");
				}
				printStack(mode);
				break;
			case 'o':
				check = pop(&popped);
				if(check == 1)
				{
					printf("Underflow!!!\n");
				}
				else
				{
					printf("Popped ");
					printf("%d\n", popped);
				}
				printStack(mode);
				break;
			case 'h':
                                mode = 1;
                                printStack(mode);
                                break;
                        case 'c':
                                mode = 2;
                                printStack(mode);
                                break;
                        case 'd':
                                mode = 0;
                                printStack(mode);
                                break;
			case 'x':
				printf("Goodbye!");
				done = 1;
			default:
				printf("\n");
		}	
	}
	return 0;
}
