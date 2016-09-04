; Author: Aaron Hahs
; Section: 225-03
; Assignment: 05
; File: UP2.asm
; Purpose: Instructions for a user program that continuously prints asterisks to the screen (when incremented register becomes negative).
; R2: register used to store loop iteration increments.
; R0: register used for TRAP instructions.

	.ORIG x3400
	
LOOP	ADD	R2, R2, #1	; increment register
	BRzp	LOOP
	LD	R0, AST		; loads character into R0
	TRAP	x21 		; echoes character to monitor
	AND	R2, R2, #0 	; reset register
	BRnzp	LOOP

AST	.FILL	x002A

	.END
