; Author: Aaron Hahs
; Section: 225-03
; Assignment: 05
; File: isr.asm
; Purpose: Instructions for the interrupt service routine to store the last key pressed, reset the KBSR, and overrite the return location.
; R0: register used to store input value.
; R1: register used to store/load memory/addresses.
; R6: register used as a pointer to the top of stack.

	.ORIG x3500

	LDI	R0, KBDR	;	get character from KBDR
	AND	R1, R1, #0	;	clear R1
	STI	R1, KBSR	;	clear KBSR
	LDI	R1, STORED	; load stored UP1 PC address
	STR	R1, R6, #0	;	overwrite UP2 PC with UP1 PC
	RTI

KBDR	.FILL	xFE02
KBSR	.FILL	xFE00
STORED	.FILL	x32FF
TOP	.FILL	x2FFE
	.END
