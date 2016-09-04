; Author: Aaron Hahs
; Section: 225-03
; Assignment: 05
; File: UP1.asm
; Purpose: Instructions for the user program that echoes 5 input characters to the screen, prints a completion message, and runs again in a loop.
; R1: register used to store and load different values/addresses.
; R6: register used as a pointer to the top of the user stack.

	.ORIG	x3000

	LD	R1, TRAP_LOC	; load location of TRAP26
	STI	R1, VEC_TBL	; load R1 to vector table
	LD	R1, ISR	; load location of isr
	STI	R1, KBI	; load R1 to keyboard interrupt vector
LOOP	LD	R6, INIT	; initialize stack
	TRAP	x26  	; get char
	TRAP	x21 	; print char to screen
	TRAP	x26  	; get char
	TRAP	x21  	; print char to screen
	TRAP	x26  	; get char
	TRAP	x21  	; print char to screen
	TRAP	x26  	; get char
	TRAP	x21  	; print char to screen
	TRAP	x26	; get char
	TRAP	x21	; print char to screen
	LEA	R0, END_MSG
	PUTS
	BRnzp LOOP

END_MSG	.STRINGZ "\nSuccess!  Running again...\n"
TRAP_LOC	.FILL	x3300
VEC_TBL	.FILL	x0026
KBI	.FILL	x0180
ISR 	.FILL	x3500
INIT 	.FILL	x3000
        .END
