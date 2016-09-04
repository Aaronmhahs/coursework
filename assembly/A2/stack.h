/*
 * @author: Aaron Hahs
 * @title: Assignment 6 - CPE225-03
 * @description: header file for stack implementation
 */

#ifndef STACK_H
#define STACK_H

/*
 * function declarations(prototypes)
 */
int push(int value);
int pop(int *value);
void printStack(int arg);

/*
 * global structure of the stack
 */
struct stack
{
        int s[10];
        int top;
} st;

#endif
