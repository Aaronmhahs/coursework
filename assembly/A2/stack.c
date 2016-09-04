/*
 *@author: Aaron Hahs
 *@title: Assignment 6 - CPE225-03
 *@description: C program file for stack functions
 */

#include <stdio.h>
#include "stack.h"

/*
 * Function to add an element to the stack
 */
int push(int value)
{
	if(st.top == 9)
	{
		return 1;
	}
	else
	{
		st.top++;
		st.s[st.top] = value;
		return 0;
	}
}

/*
 * Function to remove an element from the stack and store the value in a pointer
 */
int pop(int *value)
{
	if(st.top == -1)
	{
		return 1;
	}
	else
	{
		*value = st.s[st.top];
		st.top--;
		return 0;
	}
}

/*
 * Function to print the contents of the stack in decimal, hex, or character format
 */
void printStack(int arg)
{
	int i;
	if(arg == 0)
	{
		printf("Stack: ");
		for(i = 0; i <= st.top; i++)
		{
			printf("%d ", st.s[i]);
		}
		printf("\n");
	}
	else if(arg == 1)
	{
		printf("Stack: ");
		for(i = 0; i <= st.top; i++)
		{
			printf("%x ", st.s[i]);
		}
		printf("\n");
	}
	else if (arg == 2)
	{
		printf("Stack: ");
		for(i = 0; i <= st.top; i++)
		{
			printf("%c ", st.s[i]);	
		}
		printf("\n");
	}
	else
	{
		printf("Stack is empty!\n");
	}
}
