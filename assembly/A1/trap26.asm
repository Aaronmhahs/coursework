; Author: Aaron Hahs
; Section: 225-03
; Assignment: 05
; File: trap26.asm
; Purpose: Instructions for xTRAP 26. Stores PC of UP1, enables interrupts and jumps to the UP2 program.
; R7: register stores the PC from UP1 when TRAP is reached.
; R1: register used to load/store memory/addresses.

	.ORIG x3300

	STI	R7, STORED	;	stores PC from UP1
	LD	R1, KBSRIE	;	enable keyboard interrupts
	STI	R1, KBSR
	LD	R1, UP2	;	load UP2 PC address 
	JMP	R1	;	jump to UP2


STORED	.FILL	x32FF
UP2	.FILL	x3400
KBSR	.FILL	xFE00
KBSRIE	.FILL	x4000
	.END
